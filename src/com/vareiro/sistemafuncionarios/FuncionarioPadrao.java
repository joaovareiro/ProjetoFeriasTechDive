package com.vareiro.sistemafuncionarios;

import java.util.ArrayList;

public abstract class FuncionarioPadrao implements Funcionario {
    private String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private boolean status;
    private static ArrayList<FuncionarioPadrao> listaTodosFuncionarios= new ArrayList<>();

    public FuncionarioPadrao(String cpf, String nome, String telefone, String endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.status = true;
        listaTodosFuncionarios.add(this);
    }

    @Override
    public String identificacao(){
            return "Colaborador" +
                    " cpf: " + cpf +
                    " ; nome: " + nome  +
                    " ; telefone: " + telefone+
                    " ; endereco: " + endereco + " ; " +
                    isEmpregado();
    }

    public static String getCpf(FuncionarioPadrao a) {
        return a.cpf;
    }
    public void alteraStatus(String cpf){
        if(procuraColaborador(cpf)!=null){
        }
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String isEmpregado(){
        if(this.status==true){
            return "Status: trabalhando";
        }else{
            return "Status: demitido";
        }
    }

    public static FuncionarioPadrao procuraColaborador(String cpf){
        for(FuncionarioPadrao a : listaTodosFuncionarios){
            if(getCpf(a)==cpf)
                return a;
        }
        return null;
    }

    public static void listaTodosFuncionariosSistema(){
        for(FuncionarioPadrao a : listaTodosFuncionarios){
            System.out.println(a);
        }
    }

    public static void listaTodosFuncionariosTrabalhando(){
        for(FuncionarioPadrao a : listaTodosFuncionarios){
            if(a.status==true){
                System.out.println(a);
            }
        }
    }

    public static void listaTodosFuncionariosDemitidos(){
        for(FuncionarioPadrao a : listaTodosFuncionarios){
            if(a.status==false){
                System.out.println(a);
            }
        }
    }
}
