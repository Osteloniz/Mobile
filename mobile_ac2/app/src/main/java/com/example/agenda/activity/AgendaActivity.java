package com.example.agenda.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.agenda.R;
import com.example.agenda.adapter.AgendaAdapter;
import com.example.agenda.api.AgendaService;
import com.example.agenda.api.ApiClient;
import com.example.agenda.model.Agenda;
import com.example.agenda.util.Loading;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AgendaActivity extends AppCompatActivity {
    AgendaService agendaService;
    RecyclerView recyclerAgenda;

    AgendaAdapter adapterAgenda;

    List<Agenda> agendas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
        agendaService = ApiClient.getAgendaService();
        recyclerAgenda = (RecyclerView) findViewById(R.id.recyclerAgenda);
    }

    @Override
    protected void onResume() {
        super.onResume();
        obterUsuarios();
    }

    private void obterUsuarios() {
        Loading.start(this,"Carregando...");
        Call<List<Agenda>> call = agendaService.getUsuarios();
        call.enqueue(new Callback<List<Agenda>>() {
            @Override
            public void onResponse(Call<List<Agenda>> call, Response<List<Agenda>> response) {
                agendas = response.body();
                configurarReclycerUsuario();
                Loading.stop();
            }

            @Override
            public void onFailure(Call<List<Agenda>> call, Throwable t) {
                Log.e("Erro getUsuario",t.getMessage());
                Loading.stop();
            }
        });
    }

    private void configurarReclycerUsuario() {
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);
        recyclerAgenda.setLayoutManager(linearLayoutManager);
        adapterAgenda = new AgendaAdapter(agendas,this);
        recyclerAgenda.setAdapter(adapterAgenda);
        recyclerAgenda.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}