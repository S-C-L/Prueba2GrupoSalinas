package com.example.prueba2gruposalinas.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.prueba2gruposalinas.R;

public class Detallecard extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detallecard);

        String id = getIntent().getStringExtra("id");
        String nombre = getIntent().getStringExtra("nombre");
        String status = getIntent().getStringExtra("status");
        String species = getIntent().getStringExtra("species");
        String type = getIntent().getStringExtra("type");
        String gender = getIntent().getStringExtra("gender");
        String image = getIntent().getStringExtra("image");


         ImageView fotooImageView = findViewById(R.id.fotooimageView);
        Glide.with(this)
                .load(image)
                .apply(new RequestOptions().placeholder(R.drawable.ic_launcher_background)) // Opcional: imagen de carga mientras se descarga la imagen real
                .into(fotooImageView);

        TextView idTextView = findViewById(R.id.idpeopletextView); // Suponiendo que tienes un TextView con el id "nombreTextView"
        idTextView.setText(id);

        TextView nombreTextView = findViewById(R.id.nombreetextView); // Suponiendo que tienes un TextView con el id "nombreTextView"
        nombreTextView.setText(nombre);

        TextView statusTextView = findViewById(R.id.estatusstextView); // Suponiendo que tienes un TextView con el id "nombreTextView"
        statusTextView.setText(status);

        TextView speciesTextView = findViewById(R.id.especieetextView); // Suponiendo que tienes un TextView con el id "nombreTextView"
        speciesTextView.setText(species);

        TextView typeTextView = findViewById(R.id.tipootextView); // Suponiendo que tienes un TextView con el id "nombreTextView"
        typeTextView.setText(type);

        TextView genderTextView = findViewById(R.id.genderrtextView); // Suponiendo que tienes un TextView con el id "nombreTextView"
        genderTextView.setText(gender);

        Button regresar = (Button) findViewById(R.id.regresarbutton);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crear un Intent y especificar la actividad de destino (ActivityB)
                Intent intent = new Intent(Detallecard.this, MainActivity.class);

                // Iniciar la ActivityB
                startActivity(intent);
            }
        });

    }
}