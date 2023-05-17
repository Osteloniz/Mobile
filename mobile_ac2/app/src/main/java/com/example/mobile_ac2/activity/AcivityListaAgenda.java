package com.example.mobile_ac2.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_ac2.R;
import com.example.mobile_ac2.adapter.AgendaAdapter;
import com.example.mobile_ac2.api.AgendaService;
import com.example.mobile_ac2.api.ApiClient;
import com.example.mobile_ac2.models.Agenda;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AcivityListaAgenda extends AppCompatActivity {

     RecyclerView recyclerAgenda;

     AgendaAdapter agendaAdapter;

     List<Agenda> listaAgendas;

     AgendaService agendaService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acivity_lista_agenda);
        recyclerAgenda = (RecyclerView) findViewById(R.id.recyclerAgenda);
        agendaService = ApiClient.getUsuarioService();
        configurarRecyclerUsuario();
    }
    @Override
    protected void onResume(){
        super.onResume();
        obterAgenda();
    }

    private void obterAgenda(){
        Call<List<Agenda>> call = agendaService.getUsuarios();
        call.enqueue(new Callback<List<Agenda>>() {
            @Override
            public void onResponse(Call<List<Agenda>> call, Response<List<Agenda>> response) {
                listaAgendas = response.body();
                configurarRecyclerUsuario();
            }
            @Override
            public void onFailure(Call<List<Agenda>> call, Throwable t) {
                Log.e("Erro ao Puxar Agenda",t.getMessage());
            }
        });
    }

    private void configurarRecyclerUsuario() {

           LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            agendaAdapter = new AgendaAdapter(listaAgendas, this);
            recyclerAgenda.setLayoutManager(linearLayoutManager);
            recyclerAgenda.setAdapter(agendaAdapter);
            recyclerAgenda.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));

    }


}