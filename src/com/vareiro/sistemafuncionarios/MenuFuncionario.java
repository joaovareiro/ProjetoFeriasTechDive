package com.vareiro.sistemafuncionarios;

import java.util.Scanner;

public abstract class MenuFuncionario{
    static Scanner sc= new Scanner(System.in);
    public static void menuInicial() {
        int op;
        while (true) {
            System.out.println("----- SISTEMA DE GERENCIAMENTO DE FUNCIONARIOS TECH-DIVE -----");
            System.out.println("""
                    Selecione uma opcao:\s
                    1 - Adicionar funcionário
                    2 - Ver detalhes de um funcionário
                    3 - Demitir funcionário
                    4 - Atualizar informações de um funcionário
                    5 - Listar todos os funcionários
                    6 - Listar somente os funcionários trabalhando
                    7 - Listar somente os funcionários demitidos
                    8 - Sair""");

            op = sc.nextInt();
            if (op == 1) {
                System.out.printf("Digite o cpf do funcionario (somente os numeros)\n");
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
                System.out.println("""
                        Selecione o cargo do funcionario\s
                        1 - Colaborador
                        2 - Lider Tecnico
                        3 - Gerente de Departamento
                        4 - Gerente Geral""");
                int op1 = sc.nextInt();
                switch (op1) {
                    case 1:
                        Colaborador c1 = new Colaborador(cpfNovo, nomeNovo, telefoneNovo, enderecoNovo, deptNovo);
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
            } else if (op == 2) {
                System.out.printf("Digite o cpf do funcionario que voce deseja encontrar (somente os numeros) \n");
                sc.nextLine();
                String cpfNovo = sc.nextLine();
                FuncionarioPadrao.infoFuncionario(cpfNovo);

            } else if (op == 3) {
                System.out.printf("Digite o cpf do funcionario que voce deseja demitir (somente os numeros) : \n");
                sc.nextLine();
                String cpfNovo = sc.nextLine();
                FuncionarioPadrao.demiteFuncionario(cpfNovo);

            } else if (op == 4) {
                System.out.println("Digite o cpf do funcionario (somente os numeros) :");
                sc.nextLine();
                String cpfProcura = sc.nextLine();
                if (FuncionarioPadrao.procuraFuncionarioPadrao(cpfProcura) != null) {
                    menuOp(FuncionarioPadrao.procuraFuncionarioPadrao(cpfProcura), cpfProcura);
                } else {
                    System.out.println("Colaborador nao encontrado");
                }

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
    public static void menuOp(FuncionarioPadrao a, String cpfProcura){
        System.out.printf("Digite o telefone do funcionario \n");
        String telefoneNovo = sc.nextLine();
        System.out.printf("Digite o endereco do funcionario \n");
        String enderecoNovo = sc.nextLine();

    if(a instanceof Colaborador){
        System.out.printf("Digite o departamento do funcionario \n");
        String deptNovo = sc.nextLine();
        if(Colaborador.procuraColaborador(cpfProcura)!=null) {
            Colaborador.procuraColaborador(cpfProcura).alteraDados(telefoneNovo, enderecoNovo, deptNovo);
        }else{
            System.out.println("Colaborador nao encontrado");
        }

    } else if(a instanceof LiderTecnico){
        System.out.printf("Digite o departamento do funcionario \n");
        String deptNovo = sc.nextLine();
        if(LiderTecnico.procuraLiderTecnico(cpfProcura)!=null) {
            LiderTecnico.procuraLiderTecnico(cpfProcura).alteraDados(telefoneNovo, enderecoNovo, deptNovo);
        }else{
            System.out.println("Lider tecnico nao encontrado");
        }

    } else if(a instanceof GerenteDepartamento){
            System.out.printf("Digite o departamento do funcionario \n");
            String deptNovo = sc.nextLine();
            if(GerenteDepartamento.procuraGerenteDepartamento(cpfProcura)!=null) {
                GerenteDepartamento.procuraGerenteDepartamento(cpfProcura).alteraDados(telefoneNovo, enderecoNovo, deptNovo);
            }else{
                System.out.println("Gerente de Departamento nao encontrado");
            }

    } else if(a instanceof GerenteGeral){

        if(GerenteGeral.procuraGerenteGeral(cpfProcura)!=null) {
            GerenteGeral.procuraGerenteGeral(cpfProcura).alteraDados(telefoneNovo, enderecoNovo);
        }else{
            System.out.println("Gerente Geral nao encontrado");
        }
        }
    }

    public static void main(String[] args) {
        Colaborador c1 = new Colaborador("24503667840","Vera Gabrielly Lima","9845-2134","Travessa Cesar da Silva, 772","Recursos Humanos");
        Colaborador c2 = new Colaborador("37215364100","Vinicius da Conceicao","91145-2285","Alameda Manoel Soares, 313","Financeiro");
        Colaborador c3 = new Colaborador("91322762902","Calebe Eduardo Jesus","94545-6232","Rua Professor Jose Augustu, 186","Comercial");
        Colaborador c4 = new Colaborador("28621768771", "Livia Jaqueline Nunes","92875-0587","Rua Vinicius Andrade, 462","Recursos Humanos");
        Colaborador c5 = new Colaborador("56262423176","Luciana Maria Bernardes","93658-4975","Rua Amapa, 158","Contabilidade");
        LiderTecnico lt1 = new LiderTecnico("63369614278", "Enzo Victor Mateus","99290-8459","Jardim Aero Rancho,164","Contabilidade");
        LiderTecnico lt2 = new LiderTecnico("44262231569","Nicolas Rodrigo Almada","99470-2465","Travessa Sao Sebastiao","Comercial");
        LiderTecnico lt3 = new LiderTecnico("35090428247","Carolina Sophia Pires","98239-3431","Rua Bom Retiro, 978","Recursos Humanos");
        LiderTecnico lt4 = new LiderTecnico("17801332350","Larissa Jaqueline Assuncao","99690-5298","Travessa Cesar da Silva, 455","Financeiro");
        GerenteDepartamento gd1 = new GerenteDepartamento("96356223090","Sophie Giovanna Caroline dos Santos","98753-7804","Rua Amadeu de Paula, 202","Financeiro");
        GerenteDepartamento gd2 = new GerenteDepartamento("79638395826","Yuri Rafael da Luz","97029-5090","Avenida 14 de Julho","Recursos Humanos");
        GerenteDepartamento gd3 = new GerenteDepartamento("21215967390","Patricia Luiza da Rocha","97880-8430","Avenida Italo Calvino","Comercial");
        GerenteDepartamento gd4 = new GerenteDepartamento("18839670904","Marcilio Miranda Souza","93353-9179","Rua Julia Lopes de Almeida","Contabilidade");
        GerenteGeral gg1 = new GerenteGeral("67728914227","Ricardo Lopes","99535-2286","Avenida Visconde de Taunay, 445");
        FuncionarioPadrao.demiteFuncionarioSilencioso("91322762902");
        FuncionarioPadrao.demiteFuncionarioSilencioso("24503667840");
        menuInicial();
    }
    }