package com.example.mobile_ac2.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    //constante estatica - final da url tem que ser uma barra (/)
    private static final String BASE_URL = "https://63055f7d697408f7edc56890.mockapi.io/Usuario/";
    // professor rafael -> https://61560fe1e039a0001725a8ed.mockapi.io/api/v1/
    private static Retrofit retrofit = null;
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    //metodo chamado getUsuarioService que implementa a classe ( a magia acontece aqui)
    // muda apenas esse conforme interface alterado
    public static AgendaService getUsuarioService() {
        return getClient().create(AgendaService.class);
    }
}
