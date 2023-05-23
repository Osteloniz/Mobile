package com.example.agenda.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agenda.R;
import com.example.agenda.activity.EditResumActivity;
import com.example.agenda.model.Agenda;

import java.util.List;

public class AgendaAdapter extends RecyclerView.Adapter<AgendaAdapter.AgendaViewHolder> {

    private final List<Agenda> agendas;

    Context context;

    public AgendaAdapter(List<Agenda> agendas, Context context) {
        this.context = context;
        this.agendas = agendas;
    }
    @NonNull
    @Override
    public AgendaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AgendaViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_agenda, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AgendaViewHolder holder, int position) {
        Agenda agen = agendas.get(position);
        holder.getData().setText("Data: " + agen.getData());
        holder.getHora().setText("Hora: " + agen.getHora());
        holder.getProfessor().setText("Professor: " + agen.getProfessor());
        holder.getCurso().setText("Curso: " + agen.getCurso());
        holder.getResumo().setText("Resumo: " + agen.getResumo());
        holder.getUf().setText("UF: " + agen.getUf());
        holder.getCidade().setText("Cidade: " + agen.getCidade());
        holder.getCep().setText("CEP: " + agen.getCep());
        holder.getBtnEditar().setOnClickListener(view -> editar(position));
    }

    private void editar(int position) {
        int id = agendas.get(position).getId();
        System.out.println("id" + id);
        Intent intent = new Intent(context, EditResumActivity.class);
        intent.putExtra("id", id);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return agendas != null ? agendas.size() : 0;
    }

    public class AgendaViewHolder extends RecyclerView.ViewHolder {
        private TextView data, hora, professor, curso, resumo, uf, cidade, cep;

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

        public AgendaViewHolder(@NonNull View itemView) {
            super(itemView);

            data = (TextView) itemView.findViewById(R.id.textData);
            hora = (TextView) itemView.findViewById(R.id.textHora);
            professor = (TextView) itemView.findViewById(R.id.textProfessor);
            curso = (TextView) itemView.findViewById(R.id.textCurso);
            resumo = (TextView) itemView.findViewById(R.id.textResumo);
            uf = (TextView) itemView.findViewById(R.id.textUf);
            cidade = (TextView) itemView.findViewById(R.id.textCidade);
            cep = (TextView) itemView.findViewById(R.id.textCep);
            btnEditar = (ImageButton) itemView.findViewById(R.id.btnEditar);
        }
    }
}
