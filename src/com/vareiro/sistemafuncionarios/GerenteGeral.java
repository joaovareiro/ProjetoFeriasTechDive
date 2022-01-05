package com.vareiro.sistemafuncionarios;

import java.util.ArrayList;

public class GerenteGeral extends FuncionarioPadrao {
    private static ArrayList<GerenteGeral> listaGerenteGeral = new ArrayList<>();

    public GerenteGeral(String cpf, String nome, String telefone, String endereco) {
        super(cpf, nome, telefone, endereco);
    }

    public void alteraDados(String novoTelefone, String novoEndereco) {
        setTelefone(novoTelefone);
        setEndereco(novoEndereco);
    }

    public static GerenteGeral procuraGerenteGeral(String cpf) {
        for(GerenteGeral a : listaGerenteGeral){
            if(cpf.equals(a.getCpf()))
                return a;
        }
        return null;
    }

    @Override
    public String identificacao(){
        return "Gerente Geral" +
                " ; cpf: " + getCpf() +
                " ; nome: " + getNome() +
                " ; telefone: " + getTelefone()+
                " ; endereco: " + getEndereco() +
                " ; " + isEmpregado();
    }

    @Override
    public String toString() {
        return identificacao();
    }

}
