package com.example.prueba2gruposalinas.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.prueba2gruposalinas.Model.Datos;
import com.example.prueba2gruposalinas.Model.DatosRespuesta;
import com.example.prueba2gruposalinas.R;
import com.example.prueba2gruposalinas.ViewModel.DatosApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Consumo de API Pokemon";

    private Retrofit retrofit;

    private RecyclerView recyclerView;
    private ListaDatosAdapter listaDatosAdapter;

    private int offset;

    private boolean aptoparaCargar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //retrofit = new Retrofit.Builder().baseUrl("https://rickandmortyapi.com/api/").addConverterFactory(GsonConverterFactory.create()).build();
        //obtenerDatos();
        recyclerView = (RecyclerView) findViewById(R.id.reciclerView);
        listaDatosAdapter = new ListaDatosAdapter(MainActivity.this);
        recyclerView.setAdapter(listaDatosAdapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView,dx,dy);
                if (dy>0){

                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findLastVisibleItemPosition();

                    if (aptoparaCargar){
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount){
                            Log.i(TAG,"Llegamos al final.");

                            aptoparaCargar = false;
                            offset += 20;
                            obtenerDatos(offset);
                        }
                    }
                }
            }
        });

        retrofit = new Retrofit.Builder().baseUrl("https://rickandmortyapi.com/api/").addConverterFactory(GsonConverterFactory.create()).build();
        aptoparaCargar = true;
        offset = 0;
        obtenerDatos(offset);

    }

    private void obtenerDatos(int offset) {

        DatosApiService service = retrofit.create(DatosApiService.class);
        Call<DatosRespuesta> pokemonRespuestaCall = service.obtenerlistadatos();

        pokemonRespuestaCall.enqueue(new Callback<DatosRespuesta>() {
            @Override
            public void onResponse(Call<DatosRespuesta> call, Response<DatosRespuesta> response) {

                aptoparaCargar = true;


                if (response.isSuccessful()) {
                    DatosRespuesta pokemonRespuesta = response.body();
                    ArrayList<Datos> listapokemon = pokemonRespuesta.getResults();

                    listaDatosAdapter.adicionarListaPokemon(listapokemon);

                    for (int i = 0; i < listapokemon.size(); i++) {
                        Datos p = listapokemon.get(i);
                        Log.i(TAG, "id: " + p.getId());
                        Log.i(TAG, "name: " + p.getName());
                        Log.i(TAG, "Status: " + p.getStatus());
                        Log.i(TAG, "Especies: " + p.getSpecies());
                        Log.i(TAG, "Tipo: " + p.getType());
                        Log.i(TAG, "Gender: " + p.getGender());
                     //   Log.i(TAG,"Origin: " + p.getOrigin());
                        //  Toast.makeText(MainActivity.this, p.getName(), Toast.LENGTH_LONG).show();

                    }


                } else {
                    Log.e(TAG, "onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<DatosRespuesta> call, Throwable t) {

                Log.e(TAG, "onFailure: " + t.getMessage());

            }
        });




    }

}