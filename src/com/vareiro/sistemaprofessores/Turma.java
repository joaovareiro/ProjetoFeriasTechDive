package com.vareiro.sistemaprofessores;
import java.util.ArrayList;

public class Turma {
    private String idTurma;
    private String nomeTurma;
    private int qtdAlunos;
    private static ArrayList<Assunto> listaAssuntos = new ArrayList<>();
    private static ArrayList<Turma> listaTurmas = new ArrayList<>();
    private String dataInicio;

    public Turma(String idTurma, String nomeTurma, int qtdAlunos, String dataInicio) {
        this.idTurma = idTurma;
        this.nomeTurma = nomeTurma;
        this.qtdAlunos = qtdAlunos;
        this.dataInicio = dataInicio;
        listaTurmas.add(this);
    }

    public Turma(String idTurma, String nomeTurma, int qtdAlunos) {
        this.idTurma = idTurma;
        this.nomeTurma = nomeTurma;
        this.qtdAlunos = qtdAlunos;
        listaTurmas.add(this);
    }

    public void adicionaAssunto(Assunto a){
        listaAssuntos.add(a);
    }
}
