package com.example.agenda.api;

import com.example.agenda.model.Agenda;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AgendaService {
    @GET("Usuario")
    Call<List<Agenda>> getUsuarios();

    @GET("Usuario/{id}")
    Call<Agenda> getAgendaById(@Path("id") int id);

    @PUT("Usuario/{id}")
    Call<Agenda> editAgenda(@Path("id") int id, @Body Agenda agenda);
}
