package com.vareiro.sistemafuncionarios;

import java.util.ArrayList;

public class GerenteDepartamento extends FuncionarioPadrao {
    private String dept;
    private ArrayList<LiderTecnico> listaLideresTecnicos = new ArrayList<>();

    public GerenteDepartamento(String cpf, String nome, String telefone, String endereco, String dept) {
        super(cpf, nome, telefone, endereco);
        this.dept = dept;
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
