package com.vareiro.sistemaprofessores;

import java.util.ArrayList;

public class Docente {
    private String idDocente;
    private String nomeDocente;
    private static ArrayList<Turma> listaTurmas = new ArrayList<>();
    private static ArrayList<Docente> listaTodosDocentes = new ArrayList<>();

    public Docente(String idDocente, String nomeDocente) {
        this.idDocente = idDocente;
        this.nomeDocente = nomeDocente;
    }

    public String getIdDocente() {
        return idDocente;
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
            System.out.println(a);
        }
    }

    @Override
    public String toString() {
        return "Docente{" +
                "idDocente='" + idDocente + '\'' +
                ", nomeDocente='" + nomeDocente + '\'' +
                '}';
    }
}

