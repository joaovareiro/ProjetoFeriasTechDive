package com.vareiro.sistemafuncionarios;

import java.util.ArrayList;

public class Colaborador extends FuncionarioPadrao{
    private String dept;
    private static ArrayList<Colaborador> listaColaboradores = new ArrayList<>();

    public Colaborador(String cpf, String nome, String telefone, String endereco, String dept) {
        super(cpf, nome, telefone, endereco);
        this.dept = dept;
        listaColaboradores.add(this);
    }

    public void alteraDados(String novoTelefone, String novoEndereco,String novoDept){
        setTelefone(novoTelefone);
        setEndereco(novoEndereco);
        this.dept = novoDept;
    }

    public static Colaborador procuraColaborador(String cpf) {
        for(Colaborador a : listaColaboradores){
            if(cpf.equals(a.getCpf()))
            return a;
        }
        return null;
    }


    @Override
    public String identificacao(){
        return "Colaborador" +
                " ; cpf: " + getCpf() +
                " ; nome: " + getNome() +
                " ; telefone: " + getTelefone()+
                " ; endereco: " + getEndereco() +
                " ; departamento: " + dept +
                " ; " + isEmpregado();
    }

    @Override
    public String toString() {
        return identificacao();
    }
}
