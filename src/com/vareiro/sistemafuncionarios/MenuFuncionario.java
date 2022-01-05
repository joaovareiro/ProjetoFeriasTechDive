package com.vareiro.sistemafuncionarios;

import java.util.Scanner;

public abstract class MenuFuncionario{
    static Scanner sc= new Scanner(System.in);
    public static void menuInicial(){
        int op;
        while(true) {
            System.out.println("----- SISTEMA FUNCIONARIOS TECH-DIVE -----");
            System.out.println("""
                    Selecione uma opcao:\s
                    1 - Adicionar funcionário
                    2 - Ver detalhes de um funcionário
                    3 - Demitir funcionário (Neste caso o funcionário não deverá ser apagado)
                    4 - Atualizar informações de um funcionário
                    5 - Listar todos os funcionários
                    6 - Listar somente os funcionários trabalhando
                    7 - Listar somente os funcionários demitidos
                    8 - Sair""");

            op = sc.nextInt();
            if (op == 1) {
                System.out.printf("Digite o cpf do funcionario \n");
                sc.nextLine();
                String cpfNovo = sc.nextLine();
                System.out.printf("Digite o nome do funcionario \n");
                String nomeNovo = sc.nextLine();
                System.out.printf("Digite o telefone do funcionario \n");
                String telefoneNovo = sc.nextLine();
                System.out.printf("Digite o endereco do funcionario \n");
                String enderecoNovo = sc.nextLine();
                System.out.printf("Digite o departamento do funcionario \n");
                String deptNovo = sc.nextLine();
                System.out.printf("Digite o cargo do funcionario \n");
                System.out.println("""
                    Selecione uma opcao:\s
                    1 - Colaborador
                    2 - Lider Tecnico
                    3 - Gerente de Departamento
                    4 - Gerente Geral""");
                int op1 = sc.nextInt();
                switch (op1) {
                    case 1:
                        sc.nextLine();
                        System.out.printf("Digite o cpf do lider tecnico\n");
                        String cpfLider = sc.nextLine();
                        Colaborador c1 = new Colaborador(cpfNovo, nomeNovo, telefoneNovo, enderecoNovo, deptNovo, cpfLider);
                        break;
                    case 2:
                        LiderTecnico lt1 = new LiderTecnico(cpfNovo, nomeNovo, telefoneNovo, enderecoNovo, deptNovo);
                        break;
                    case 3:
                        GerenteDepartamento gd1 = new GerenteDepartamento(cpfNovo, nomeNovo, telefoneNovo, enderecoNovo, deptNovo);
                        break;
                    case 4:
                        GerenteGeral gg1 = new GerenteGeral(cpfNovo, nomeNovo, telefoneNovo, enderecoNovo);
                        break;
                    }
                }
                else if (op == 2) {

                    System.out.printf("Digite o cpf do funcionario que voce deseja encontrar \n");
                    sc.nextLine();
                    String cpfNovo = sc.nextLine();
                    FuncionarioPadrao.infoFuncionario(cpfNovo);

                } else if (op == 3) {
                    //fix
                    System.out.printf("Digite o cpf do funcionario que voce deseja demitir: \n");
                    sc.nextLine();
                    String cpfNovo = sc.nextLine();
                    FuncionarioPadrao.demiteFuncionario(cpfNovo);

                } else if (op == 4) {

                } else if (op == 5) {
                    FuncionarioPadrao.listaTodosFuncionariosSistema();
                } else if (op == 6) {
                    FuncionarioPadrao.listaTodosFuncionariosTrabalhando();
                } else if (op == 7) {
                    FuncionarioPadrao.listaTodosFuncionariosDemitidos();
                } else if (op == 8) {
                    break;
                }
        }
    }

    public static void main(String[] args) {
        menuInicial();
    }
}