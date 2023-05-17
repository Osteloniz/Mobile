package com.example.mobile_ac2.api;

import com.example.mobile_ac2.models.Agenda;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface AgendaService {

   @GET("Agenda")
    Call<List<Agenda>> getUsuarios();

    @GET("Agenda/{id}")
    Call<Agenda> getAgendaById(@Path("id") int id);

    @POST("Agenda")
    Call<Agenda> postAgenda(@Body Agenda agenda);

    @DELETE("Agenda/{id}")
    Call<Void> deleteAgenda(@Path("id")int id);

    @PUT("Usuario/{id}")
    Call<Agenda> editAgenda(@Path("int") int id, @Body Agenda agenda);


}
