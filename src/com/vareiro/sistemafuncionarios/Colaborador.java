package com.vareiro.sistemafuncionarios;

public class Colaborador extends FuncionarioPadrao{
    private String dept;
    private LiderTecnico lt;

    public Colaborador(String cpf, String nome, String telefone, String endereco, String dept, LiderTecnico lt) {
        super(cpf, nome, telefone, endereco);
        this.dept = dept;
        this.lt = lt;
    }
    
}
