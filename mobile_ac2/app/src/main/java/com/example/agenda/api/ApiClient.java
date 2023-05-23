package com.example.agenda.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://63055f7d697408f7edc56890.mockapi.io/";
    private static final String BASE_TEST_URL = "https://localhost/";

    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    public static AgendaService getAgendaService() {
        return getClient().create(AgendaService.class);
    }
}
