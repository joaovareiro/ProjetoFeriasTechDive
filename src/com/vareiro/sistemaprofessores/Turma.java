package com.vareiro.sistemaprofessores;
import java.util.ArrayList;

public class Turma {
    private String idTurma;
    private String nomeTurma;
    private int qtdAlunos;
    private String dataInicio;
    private String assunto;
    private ArrayList<Docente>listaDocentes = new ArrayList<>();
    private static ArrayList<Turma> listaTurmas = new ArrayList<>();


    public Turma(String idTurma, String nomeTurma, int qtdAlunos,String Assunto, String dataInicio) {
        this.idTurma = idTurma;
        this.nomeTurma = nomeTurma;
        this.qtdAlunos = qtdAlunos;
        this.assunto = Assunto;
        this.dataInicio = dataInicio;
        listaTurmas.add(this);
    }

    public void addDocente(Docente a){
        listaDocentes.add(a);
    }

    public void limpaHorario(){
        listaDocentes.clear();
    }

    public String getIdTurma() {
        return idTurma;
    }

    public static Turma procuraTurma(String idProcurar){
        for(Turma a : listaTurmas){
            if(idProcurar.equals(a.idTurma))
            return a;
        }
        return null;
    }

    public ArrayList<Docente> getListaDocentes() {
        return listaDocentes;
    }

    public static int numDocentes(Turma a){
        int numDocentesTurma = 0;
        for(int i=0;i<a.getListaDocentes().size();i++){
            if(a.getListaDocentes().get(i) != null){
                numDocentesTurma++;
            }
        }
        return numDocentesTurma;
    }

    public static void listaTurmas(){
        for(Turma a : listaTurmas){
            System.out.println(a);
        }
    }

    @Override
    public String toString() {
        return "Turma{" +
                "idTurma='" + idTurma + '\'' +
                ", nomeTurma='" + nomeTurma + '\'' +
                ", qtdAlunos=" + qtdAlunos +
                ", dataInicio='" + dataInicio + '\'' +
                ", assunto='" + assunto + '\'' +
                ", listaDocentes=" + listaDocentes +
                '}';
    }
}
