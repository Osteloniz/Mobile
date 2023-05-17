package com.example.mobile_ac2.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_ac2.R;
import com.example.mobile_ac2.activity.ActivityCadResumoCurso;
import com.example.mobile_ac2.models.Agenda;

import java.util.List;

public class AgendaAdapter extends RecyclerView.Adapter<AgendaAdapter.AgendaHolder> {

    private final List<Agenda> listaAgendas;
    Context context;

    public AgendaAdapter(List<Agenda> listaAgendas, Context context){
        this.context = context;
        this.listaAgendas = listaAgendas;
    }


    @NonNull
    @Override
    public AgendaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AgendaHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_acivity_lista_agenda,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AgendaHolder holder, int position) {
        Agenda ag = listaAgendas.get(position);
        holder.getData().setText(ag.getData());
        holder.getHora().setText(ag.getHora());
        holder.getProfessor().setText(ag.getProfessor());
        holder.getResumo().setText(ag.getResumo());
        holder.getUf().setText(ag.getUf());
        holder.getCidade().setText(ag.getCidade());
        holder.getCep().setText(ag.getCep());
        holder.getBtnEditar().setOnClickListener(view -> editar(position));
    }

    private void editar (int position){
        int id = listaAgendas.get(position).getId();
        Intent intent = new Intent(context, ActivityCadResumoCurso.class);
        intent.putExtra("id",id);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {return listaAgendas != null ? listaAgendas.size() : 0;}
    public class AgendaHolder extends RecyclerView.ViewHolder{

        private TextView data;
        private TextView hora;
        private TextView professor;
        private TextView curso;
        private TextView resumo;
        private TextView uf;
        private TextView cidade;
        private TextView cep;

        private ImageButton btnEditar;

        public TextView getData() {
            return data;
        }

        public void setData(TextView data) {
            this.data = data;
        }

        public TextView getHora() {
            return hora;
        }

        public void setHora(TextView hora) {
            this.hora = hora;
        }

        public TextView getProfessor() {
            return professor;
        }

        public void setProfessor(TextView professor) {
            this.professor = professor;
        }

        public TextView getCurso() {
            return curso;
        }

        public void setCurso(TextView curso) {
            this.curso = curso;
        }

        public TextView getResumo() {
            return resumo;
        }

        public void setResumo(TextView resumo) {
            this.resumo = resumo;
        }

        public TextView getUf() {
            return uf;
        }

        public void setUf(TextView uf) {
            this.uf = uf;
        }

        public TextView getCidade() {
            return cidade;
        }

        public void setCidade(TextView cidade) {
            this.cidade = cidade;
        }

        public TextView getCep() {
            return cep;
        }

        public void setCep(TextView cep) {
            this.cep = cep;
        }

        public ImageButton getBtnEditar() {
            return btnEditar;
        }

        public void setBtnEditar(ImageButton btnEditar) {
            this.btnEditar = btnEditar;
        }

        public AgendaHolder(@NonNull View itemView) {
            super(itemView);

            data = (TextView) itemView.findViewById(R.id.textData);
            hora = (TextView) itemView.findViewById(R.id.textHora);
            professor = (TextView) itemView.findViewById(R.id.textProfessor);
            curso = (TextView) itemView.findViewById(R.id.textCurso);
            resumo = (TextView) itemView.findViewById(R.id.textResumo);
            uf = (TextView) itemView.findViewById(R.id.textUf);
            cidade = (TextView) itemView.findViewById(R.id.textCidade);
            cep = (TextView) itemView.findViewById(R.id.textCep);
        }
    }






}

