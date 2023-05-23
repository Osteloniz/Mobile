package com.example.agenda.model;

public class Agenda {

    private int id;
    private String professor, resumo, data, hora, curso,cidade, uf, cep;

    public Agenda() {
    }

    public Agenda(int id, String professor, String resumo, String data, String curso, String cidade, String uf, String cep, String hora) {
        this.id = id;
        this.professor = professor;
        this.resumo = resumo;
        this.data = data;
        this.curso = curso;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "id=" + id +
                ", professor='" + professor + '\'' +
                ", resumo='" + resumo + '\'' +
                ", data='" + data + '\'' +
                ", hora='" + hora + '\'' +
                ", curso='" + curso + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
