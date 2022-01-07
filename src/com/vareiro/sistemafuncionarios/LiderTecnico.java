package com.vareiro.sistemafuncionarios;

import java.util.ArrayList;

public class LiderTecnico extends FuncionarioPadrao {
    private String dept;
    private static ArrayList<LiderTecnico> listaLideresTecnicos = new ArrayList<>();

    public LiderTecnico(String cpf, String nome, String telefone, String endereco, String dept) {
        super(cpf, nome, telefone, endereco);
        this.dept = dept;
        listaLideresTecnicos.add(this);
    }

    public void alteraDados(String novoTelefone, String novoEndereco,String novoDept){
        setTelefone(novoTelefone);
        setEndereco(novoEndereco);
        this.dept = novoDept;
    }

    @Override
    public String identificacao(){
        return "Lider tecnico" +
                " ; cpf: " + getCpf() +
                " ; nome: " + getNome() +
                " ; telefone: " + getTelefone()+
                " ; endereco: " + getEndereco() +
                " ; departamento: " + dept +
                " ; " + isEmpregado();
    }

    public static LiderTecnico procuraLiderTecnico(String cpf){
        for(LiderTecnico a : listaLideresTecnicos){
            if(cpf.equals(a.getCpf()))
                return a;
        }
        return null;
    }

    @Override
    public String toString() {
        return identificacao();
    }

}
