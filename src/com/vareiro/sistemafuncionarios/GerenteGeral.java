package com.vareiro.sistemafuncionarios;

import java.util.ArrayList;

public class GerenteGeral extends FuncionarioPadrao {
    private ArrayList<GerenteDepartamento> listaGerentesDepartamento = new ArrayList<>();

    public GerenteGeral(String cpf, String nome, String telefone, String endereco) {
        super(cpf, nome, telefone, endereco);
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
