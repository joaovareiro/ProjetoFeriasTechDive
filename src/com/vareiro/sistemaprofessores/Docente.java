package com.vareiro.sistemaprofessores;

import java.util.ArrayList;

public class Docente {
    private String idDocente;
    private String nomeDocente;
    private ArrayList<Turma> listaTurmasDocente = new ArrayList<>();
    public static ArrayList<Docente> listaTodosDocentes = new ArrayList<>();

    public Docente(String idDocente, String nomeDocente) {
        this.idDocente = idDocente;
        this.nomeDocente = nomeDocente;
        listaTodosDocentes.add(this);
    }

    public void addTurma(Turma t){
        listaTurmasDocente.add(t);
    }

    public String getIdDocente() {
        return idDocente;
    }

    public String getNomeDocente() {
        return nomeDocente;
    }

    public static Docente procuraDocente(String id){
        for(Docente a : listaTodosDocentes){
            if(id.equals(a.getIdDocente()))
                return a;
        }
        return null;
    }

    public static void listaDocentes(){
        for(Docente a : listaTodosDocentes){
            a.identificacaoDocente(5);
        }
    }

    public void listaTurmasdoDocente(Docente doc){
        for(Turma a : doc.listaTurmasDocente){
            a.identificacaoTurma(5);
        }
    }


    public void identificacaoDocente(int op) {
        if(op==5){
            System.out.println("Nome: " + nomeDocente + " , id: " + idDocente);
        }else if(op==6){
           if(this.listaTurmasDocente.isEmpty()){
               System.out.println("O docente " + nomeDocente + " nao possui nenhuma turma nesta semana");
           }else{
                System.out.println("O docente " + nomeDocente + " esta responsavel pelas turmas:");
                listaTurmasdoDocente(this);
                System.out.println( "nesta semana");
            }
        }
    }
}

