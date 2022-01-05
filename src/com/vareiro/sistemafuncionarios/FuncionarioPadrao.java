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

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }
    public static String getCpf(FuncionarioPadrao a) {
        return a.cpf;
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

    public static void demiteFuncionario(String cpfprocurar){
        int cont = 0;
        for(FuncionarioPadrao b : listaTodosFuncionarios){
            if(cpfprocurar.equals(b.cpf)) {
                cont ++;
                b.setStatus(false);
            }
        }
        if(cont == 0){
            System.out.println("Funcionario nao encontrado");
        }
    }

    public static void infoFuncionario(String cpfprocurar){
        int cont = 0;
        for(FuncionarioPadrao b : listaTodosFuncionarios){
            if(cpfprocurar.equals(b.cpf))  {
                cont ++;
                System.out.println(b.toString());
            }
        }
        if(cont == 0){
            System.out.println("Funcionario nao encontrado");
        }
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

    @Override
    public String toString() {
        return "FuncionarioPadrao{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                ", status=" + status +
                '}';
    }
}
