package com.example.prueba2gruposalinas.ViewModel;

import com.example.prueba2gruposalinas.Model.Datos;
import com.example.prueba2gruposalinas.Model.DatosRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DatosApiService {

    @GET("character")
    Call<DatosRespuesta> obtenerlistadatos();

}
