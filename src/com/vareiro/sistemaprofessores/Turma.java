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

    public void addDocente(Docente docente){
        listaDocentes.add(docente);
        docente.addTurma(this);
    }

    public void limpaHorario(){
        listaDocentes.clear();
        for (Docente a : Docente.listaTodosDocentes){
            if(listaDocentes.contains(a)){
                listaDocentes.remove(a);
            }
        }
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

    public int getdocentesTurma(Turma t){
        int n = 0;
        for(Docente a: listaDocentes){
            n++;
        }
        return n;
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
            if(numDocentes(a)!=0){
                a.identificacaoTurma(4);
            }else{
                System.out.println("A turma " + a.nomeTurma + " de " + a.assunto + " nao tem professores definidos para essa semana");
            }
        }
    }

    public void identificacaoTurma(int op) {
        if(op==4){
            if(getdocentesTurma(this)==1){
                System.out.printf("A turma " + nomeTurma + " de " + assunto +" terá aula com o docente ");
                System.out.println((listaDocentes.get(0)).getNomeDocente() + " esta semana" );
            }else if(getdocentesTurma(this)==2) {
                System.out.printf("A turma " + nomeTurma + " de " + assunto + " terá aula com os docentes ");
                System.out.println((listaDocentes.get(0)).getNomeDocente() + " e " + (listaDocentes.get(1)).getNomeDocente() + " esta semana");
            }
        }else if(op == 5){
            System.out.println(nomeTurma + " de " + assunto);
        }
    }
}
