package com.vareiro.sistemafuncionarios;

import java.util.ArrayList;

public class LiderTecnico extends FuncionarioPadrao {
    private String dept;
    private static ArrayList<LiderTecnico> listaLideresTecnicos = new ArrayList<>();

    public LiderTecnico(String cpf, String nome, String telefone, String endereco, String dept) {
        super(cpf, nome, telefone, endereco);
        this.dept = dept;
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

    public void alteraDados(String telefone, String endereco){
    }

    public static LiderTecnico procuraLiderTecnico(String cpf){
        for(LiderTecnico a : listaLideresTecnicos){
            if(getCpf(a)==cpf)
                return a;
        }
        return null;
    }

    @Override
    public String toString() {
        return identificacao();
    }

}
