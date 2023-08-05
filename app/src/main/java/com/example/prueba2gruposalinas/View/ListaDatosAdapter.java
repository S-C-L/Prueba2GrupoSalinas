package com.example.prueba2gruposalinas.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.prueba2gruposalinas.Model.Datos;
import com.example.prueba2gruposalinas.R;

import java.util.ArrayList;

public class ListaDatosAdapter extends RecyclerView.Adapter<ListaDatosAdapter.ViewHolder>{


    private ArrayList<Datos> dataset;
    private Context context;

    public ListaDatosAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    @NonNull
    @Override
    public ListaDatosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_datos,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        Datos p = dataset.get(position);
       // holder.idpersonaTextView.setText(p.getId());
        holder.idpeopleTextView.setText(String.valueOf(p.getId()));
        holder.nombreTextView.setText(p.getName());
        holder.statusTextView.setText(p.getStatus());
        holder.especieTextView.setText(p.getSpecies());
        holder.tipoTextView.setText(p.getType());
        holder.genderTextView.setText(p.getGender());
        //holder.genderTextView.setText(String.valueOf(p.getId()));

        String idpersona = String.valueOf(p.getId());
        String nombrepersona = String.valueOf(p.getName());
        String imageUrl = "https://rickandmortyapi.com/api/character/avatar/"+idpersona+".jpeg";


        Glide.with(context)
                .load(imageUrl)
                .apply(new RequestOptions().placeholder(R.drawable.ic_launcher_background)) // Opcional: imagen de carga mientras se descarga la imagen real
                .into(holder.fotoImageView);


        holder.fotoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                bundle.putString("id",String.valueOf(p.getId()));
                bundle.putString("nombre", p.getName());
                bundle.putString("status", p.getStatus());
                bundle.putString("species", p.getSpecies());
                bundle.putString("type", p.getType());
                bundle.putString("gender", p.getGender());
                bundle.putString("image", imageUrl);


                Intent intent = new Intent(view.getContext(), Detallecard.class);
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);
            }
        }); // Fin Image

        holder.idpeopleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                bundle.putString("id",String.valueOf(p.getId()));
                bundle.putString("nombre", p.getName());
                bundle.putString("status", p.getStatus());
                bundle.putString("species", p.getSpecies());
                bundle.putString("type", p.getType());
                bundle.putString("gender", p.getGender());
                bundle.putString("image", imageUrl);


                Intent intent = new Intent(view.getContext(), Detallecard.class);
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);
            }
        }); // fin Id


        holder.nombreTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                bundle.putString("id",String.valueOf(p.getId()));
                bundle.putString("nombre", p.getName());
                bundle.putString("status", p.getStatus());
                bundle.putString("species", p.getSpecies());
                bundle.putString("type", p.getType());
                bundle.putString("gender", p.getGender());
                bundle.putString("image", imageUrl);


                Intent intent = new Intent(view.getContext(), Detallecard.class);
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);

            }
        }); // Fin Nombre


        holder.statusTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                bundle.putString("id",String.valueOf(p.getId()));
                bundle.putString("nombre", p.getName());
                bundle.putString("status", p.getStatus());
                bundle.putString("species", p.getSpecies());
                bundle.putString("type", p.getType());
                bundle.putString("gender", p.getGender());
                bundle.putString("image", imageUrl);


                Intent intent = new Intent(view.getContext(), Detallecard.class);
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);
            }
        }); // Fin Status


        holder.especieTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                bundle.putString("id",String.valueOf(p.getId()));
                bundle.putString("nombre", p.getName());
                bundle.putString("status", p.getStatus());
                bundle.putString("species", p.getSpecies());
                bundle.putString("type", p.getType());
                bundle.putString("gender", p.getGender());
                bundle.putString("image", imageUrl);


                Intent intent = new Intent(view.getContext(), Detallecard.class);
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);
            }
        }); // Fin especie

        holder.tipoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                bundle.putString("id",String.valueOf(p.getId()));
                bundle.putString("nombre", p.getName());
                bundle.putString("status", p.getStatus());
                bundle.putString("species", p.getSpecies());
                bundle.putString("type", p.getType());
                bundle.putString("gender", p.getGender());
                bundle.putString("image", imageUrl);


                Intent intent = new Intent(view.getContext(), Detallecard.class);
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);

            }
        }); // Fin Tipo

        holder.genderTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                bundle.putString("id",String.valueOf(p.getId()));
                bundle.putString("nombre", p.getName());
                bundle.putString("status", p.getStatus());
                bundle.putString("species", p.getSpecies());
                bundle.putString("type", p.getType());
                bundle.putString("gender", p.getGender());
                bundle.putString("image", imageUrl);


                Intent intent = new Intent(view.getContext(), Detallecard.class);
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);
            }
        }); // Fin Gender


    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarListaPokemon(ArrayList<Datos> listapokemon) {
        dataset.addAll(listapokemon);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{



        private ImageView fotoImageView;

        private TextView idpeopleTextView;
        private TextView nombreTextView;

        private TextView statusTextView;

        private TextView especieTextView;
        private TextView tipoTextView;

        private TextView genderTextView;


        public ViewHolder(View itemView) {
            super(itemView);


            fotoImageView = (ImageView) itemView.findViewById(R.id.fotoImageView);
            idpeopleTextView = (TextView) itemView.findViewById(R.id.idpersonaTextView);
            nombreTextView = (TextView) itemView.findViewById(R.id.nombreTextView);
            statusTextView = (TextView) itemView.findViewById(R.id.statusTextView);
            especieTextView = (TextView) itemView.findViewById(R.id.specieTextView);
            tipoTextView = (TextView) itemView.findViewById(R.id.tipoTextView);
            genderTextView = (TextView) itemView.findViewById(R.id.genderTextView);
        }
    }
}
