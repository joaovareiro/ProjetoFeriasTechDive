package com.vareiro.sistemafuncionarios;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class FuncionarioPadrao implements Funcionario {
    private String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private boolean status;
    private static ArrayList<FuncionarioPadrao> listaTodosFuncionarios= new ArrayList<>();

    public FuncionarioPadrao(String cpf, String nome, String telefone, String endereco) {
        if (validarCPF(cpf)) {
            this.cpf = cpf;
        } else {
            solicitarCPF();
        }
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.status = true;
        listaTodosFuncionarios.add(this);
    }

    public boolean validarCPF(String cpf){
        int soma,d1,d2;
        try {
            if(cpf.length()!=11){
                return false;
            }
            ArrayList<Integer> cpfArrayList = new ArrayList<>();
            for(int i = 0;i<cpf.length();i++){
                cpfArrayList.add(Integer.parseInt(cpf.substring(i,i+1)));
            }
            soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += cpfArrayList.get(i) * (10 - i);
            }
            d1 = 11 - (soma%11);
            if(d1>9){
                d1 = 0;
            }
            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += cpfArrayList.get(i) * (11 - i);
            }

            d2 = 11 - (soma%11);
            if(d2>9){
                d2 = 0;
            }

            if ((d1 == cpfArrayList.get(9)) && (d2 == cpfArrayList.get(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException ERRO) {
            return (false);
        }
    }

    public void solicitarCPF() {
        Scanner sc = new Scanner(System.in);
        boolean cpfIncorreto = true;
        while (cpfIncorreto) {
            System.out.println("Por favor, digite um CPF valido");
            String cpfTeste = sc.next();
            if (validarCPF(cpfTeste) == true) {
                this.cpf = cpfTeste;
                cpfIncorreto = false;
            } else {
                cpfIncorreto = true;
            }
        }
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

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public String isEmpregado(){
        if(this.status==true){
            return "Status: trabalhando";
        }else{
            return "Status: demitido";
        }
    }

    public static FuncionarioPadrao procuraFuncionarioPadrao(String cpf) {
        for(FuncionarioPadrao a : listaTodosFuncionarios){
            if(cpf.equals(a.getCpf()))
                return a;
        }
        return null;
    }

    public static void demiteFuncionario(String cpfprocurar){
        int cont = 0;
        for(FuncionarioPadrao b : listaTodosFuncionarios){
            if(cpfprocurar.equals(b.cpf)) {
                cont ++;
                b.setStatus(false);
                System.out.println("O funcionario " + b.nome + " foi demitido");
            }
        }
        if(cont == 0){
            System.out.println("Funcionario nao encontrado");
        }
    }

    public static void demiteFuncionarioSilencioso(String cpfprocurar){
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
