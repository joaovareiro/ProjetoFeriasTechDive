package com.vareiro.sistemafuncionarios;

import java.util.ArrayList;

public class GerenteDepartamento extends FuncionarioPadrao {
    private String dept;
    private static ArrayList<GerenteDepartamento> listaGerenteDepartamento = new ArrayList<>();

    public GerenteDepartamento(String cpf, String nome, String telefone, String endereco, String dept) {
        super(cpf, nome, telefone, endereco);
        this.dept = dept;
        listaGerenteDepartamento.add(this);
    }

    public void alteraDados(String novoTelefone, String novoEndereco,String novoDept){
        setTelefone(novoTelefone);
        setEndereco(novoEndereco);
        this.dept = novoDept;
    }

    public static GerenteDepartamento procuraGerenteDepartamento(String cpf){
        for(GerenteDepartamento a : listaGerenteDepartamento){
            if(cpf.equals(a.getCpf()))
                return a;
        }
        return null;
    }

    @Override
    public String identificacao(){
        return "Gerente de Departamento" +
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
