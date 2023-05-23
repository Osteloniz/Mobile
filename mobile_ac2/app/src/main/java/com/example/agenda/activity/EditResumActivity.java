package com.example.agenda.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agenda.R;
import com.example.agenda.api.AgendaService;
import com.example.agenda.api.ApiClient;
import com.example.agenda.model.Agenda;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditResumActivity extends AppCompatActivity {

    TextView idResumo;

    Button btnSalvar;

    AgendaService agendaService;

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_resum);
        agendaService = ApiClient.getAgendaService();
        idResumo = findViewById(R.id.idResumo);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);

        id = getIntent().getIntExtra("id",0);
        if(id > 0){
            agendaService.getAgendaById(id).enqueue(new Callback<Agenda>() {
                @Override
                public void onResponse(Call<Agenda> call, Response<Agenda> response) {
                    if(response.isSuccessful()){
                        idResumo.setText(response.body().getResumo());
                    }
                }

                @Override
                public void onFailure(Call<Agenda> call, Throwable t) {
                    Log.e("buscar dados",t.getMessage());
                }
            });
        }

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Agenda agen = new Agenda();
                agen.setResumo(idResumo.getText().toString());
                agen.setId(id);
                editarAgenda(agen);
            }
        });
    }

    private void editarAgenda(Agenda agen) {
        Call<Agenda> call = agendaService.editAgenda(id,agen);
        call.enqueue(new Callback<Agenda>() {
            @Override
            public void onResponse(Call<Agenda> call, Response<Agenda> response) {
                if(response.isSuccessful()){
                    Toast.makeText(EditResumActivity.this,
                            "Editado com sucesso!", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(EditResumActivity.this,
                            "Erro ao editar", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Agenda> call, Throwable t) {
                Toast.makeText(EditResumActivity.this,
                        "Erro ao editar", Toast.LENGTH_SHORT).show();

            }
        });
    }


}