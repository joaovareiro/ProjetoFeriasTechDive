package com.vareiro.sistemafuncionarios;

import java.util.ArrayList;

public class LiderTecnico extends FuncionarioPadrao {
    private String dept;
    private static ArrayList<LiderTecnico> listaLideresTecnicos = new ArrayList<>();
    private ArrayList<FuncionarioPadrao> listaColaboradores = new ArrayList<>();

    public LiderTecnico(String cpf, String nome, String telefone, String endereco, String dept) {
        super(cpf, nome, telefone, endereco);
        this.dept = dept;
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
}
