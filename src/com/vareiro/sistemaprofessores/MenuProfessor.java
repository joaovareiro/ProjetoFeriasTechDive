package com.vareiro.sistemaprofessores;
import java.util.Scanner;

public abstract class MenuProfessor {
    static Scanner sc= new Scanner(System.in);
    public static void menuInicial() {
        int op;
        while (true) {
                System.out.println("----- SISTEMA DE GERENCIAMENTO DE PROFESSORES TECH-DIVE -----");
            System.out.println("""
                    Selecione uma opcao:\s
                    1 - Cadastrar turma\s
                    2 - Cadastrar docentes
                    3 - Definir docentes para uma determinada turma
                    4 - Listar turmas
                    5 - Listar todos os docentes
                    6 - Listar um docente
                    7 - Sair""");

            op = sc.nextInt();
            if (op == 1) {
                System.out.printf("Digite o numero de identificacao da turma:\n");
                sc.nextLine();
                String idTurma= sc.nextLine();
                System.out.printf("Digite o nome da turma: \n");
                String nomeTurma = sc.nextLine();
                System.out.println("Digite a quantidade de alunos:");
                int qtdAlunos = sc.nextInt();
                System.out.println("Digite a data de inicio das aulas (no formato dd-mm-yyyy)");
                sc.nextLine();
                String datainicio = sc.nextLine();
                System.out.println("""
                    Selecione uma opcao de assunto:\s
                    1 - Arquitetura de Software\s
                    2 - C#
                    3 - Estruturas de dados
                    4 - JAVA
                    5 - Qualidade de Sofware""");
                    int opAssunto = sc.nextInt();
                        if(opAssunto==1) {
                            String nomeAssunto1 = "Arquitetura de Software";
                            Turma t1 = new Turma(idTurma, nomeTurma, qtdAlunos, nomeAssunto1, datainicio);

                        } else if(opAssunto==2) {
                            String nomeAssunto2 = "C#";
                            Turma t2 = new Turma(idTurma,nomeTurma,qtdAlunos,nomeAssunto2,datainicio);

                        } else if(opAssunto==3) {
                            String nomeAssunto3 = "Estruturas de dados";
                            Turma t3 = new Turma(idTurma,nomeTurma,qtdAlunos,nomeAssunto3,datainicio);

                        } else if(opAssunto==4) {
                            String nomeAssunto4 = "JAVA";
                            Turma t4 = new Turma(idTurma,nomeTurma,qtdAlunos,nomeAssunto4,datainicio);

                        } else if(opAssunto==5) {
                            String nomeAssunto5 = "Qualidade de Sofware";
                            Turma t5 = new Turma(idTurma,nomeTurma,qtdAlunos,nomeAssunto5,datainicio);
                    }

            } else if (op == 2) {
                System.out.printf("Digite o numero de identificacao do docente:\n");
                sc.nextLine();
                String idDocente = sc.nextLine();
                System.out.printf("Digite o nome do docente: \n");
                String nomeDocente = sc.nextLine();
                Docente d1 = new Docente(idDocente,nomeDocente);
            } else if (op == 3) {
                System.out.printf("Digite o numero de identificacao da turma:\n");
                sc.nextLine();
                String idTurma= sc.nextLine();
                if(Turma.procuraTurma(idTurma)!=null){
                    if(Turma.numDocentes(Turma.procuraTurma(idTurma))==0){
                        System.out.println("""
                        Selecione a opcao referente ao numero de docentes da turma\s
                        1 - 1 docente
                        2 - 2 docentes""");
                        int op1 = sc.nextInt();
                        if(op1 == 1){
                            System.out.println("Digite o numero de identificacao do docente");
                            sc.nextLine();
                            String idprocurar = sc.nextLine();
                            if(Docente.procuraDocente(idprocurar)!=null){
                                Turma.procuraTurma(idTurma).addDocente(Docente.procuraDocente(idprocurar));
                            }else{
                                System.out.println("Docente não encontrado");
                            }
                        }else if (op1 == 2){

                            System.out.println("Digite o numero de identificacao do docente que dara as aulas de segunda a terca");
                            sc.nextLine();
                            String idprocurar1 = sc.nextLine();
                            if(Docente.procuraDocente(idprocurar1)!=null){
                                Turma.procuraTurma(idTurma).addDocente(Docente.procuraDocente(idprocurar1));
                            }else{
                                System.out.println("Docente não encontrado");
                            }

                            System.out.println("Digite o numero de identificacao do docente que dara as aulas de quarta a sexta");
                            String idprocurar2 = sc.nextLine();
                            if(Docente.procuraDocente(idprocurar2)!=null){
                                Turma.procuraTurma(idTurma).addDocente(Docente.procuraDocente(idprocurar2));
                            }else{
                                System.out.println("Docente não encontrado");
                            }
                        }
                    }else if(Turma.numDocentes(Turma.procuraTurma(idTurma))==1){
                        System.out.println("""
                        Um docente ja e reponsavel por essa turma, Selecione uma das opcoes abaixo\s
                        1 - Desejo colocar alocar um professor para as aulas de quarta a sexta
                        2 - Desejo redefinir os professores dessa turma""");
                        int op1 = sc.nextInt();
                        if(op1==1){
                            System.out.println("Digite o numero de identificacao do docente que dara as aulas de quarta a sexta");
                            sc.nextLine();
                            String idprocurar = sc.nextLine();
                            if(Docente.procuraDocente(idprocurar)!=null){
                                Turma.procuraTurma(idTurma).addDocente(Docente.procuraDocente(idprocurar));
                            }else{
                                System.out.println("Docente não encontrado");
                            }
                        }else if(op1==2){
                            Turma.procuraTurma(idTurma).limpaHorario();
                            System.out.println("Digite o numero de identificacao do docente que dara as aulas de segunda a terca");
                            sc.nextLine();
                            String idprocurar1 = sc.nextLine();
                            if(Docente.procuraDocente(idprocurar1)!=null){
                                Turma.procuraTurma(idTurma).addDocente(Docente.procuraDocente(idprocurar1));
                            }else{
                                System.out.println("Docente não encontrado");
                            }
                            System.out.println("Digite o numero de identificacao do docente que dara as aulas de quarta a sexta");
                            sc.nextLine();
                            String idprocurar2 = sc.nextLine();
                            if(Docente.procuraDocente(idprocurar2)!=null){
                                Turma.procuraTurma(idTurma).addDocente(Docente.procuraDocente(idprocurar2));
                            }else{
                                System.out.println("Docente não encontrado");
                            }
                        }
                    }else if(Turma.numDocentes(Turma.procuraTurma(idTurma))==2){
                        System.out.println("""
                        O numero maximo de docentes foi alocado para essa turma, deseja realocar o horario da turma?\s
                        1 - Sim
                        2 - Nao""");
                        int op1 = sc.nextInt();
                        if(op1==1){
                            Turma.procuraTurma(idTurma).limpaHorario();
                            System.out.println("Digite o numero de identificacao do docente que dara as aulas de segunda a terca");
                            sc.nextLine();
                            String idprocurar1 = sc.nextLine();
                            if(Docente.procuraDocente(idprocurar1)!=null){
                                Turma.procuraTurma(idTurma).addDocente(Docente.procuraDocente(idprocurar1));
                            }else{
                                System.out.println("Docente não encontrado");
                            }
                            System.out.println("Digite o numero de identificacao do docente que dara as aulas de quarta a sexta");
                            String idprocurar2 = sc.nextLine();
                            if(Docente.procuraDocente(idprocurar2)!=null){
                                Turma.procuraTurma(idTurma).addDocente(Docente.procuraDocente(idprocurar2));
                            }else{
                                System.out.println("Docente não encontrado");
                            }
                        }
                    }
                }else{
                    System.out.println("Turma nao encontrada");
                }
            } else if (op == 4) {
                Turma.listaTurmas();
            } else if (op == 5) {
                Docente.listaDocentes();
            } else if (op == 6) {
                System.out.println("Digite o numero de identificacao do docente:");
                sc.nextLine();
                String idprocurar = sc.nextLine();
                if(Docente.procuraDocente(idprocurar)!=null){
                    Docente.procuraDocente(idprocurar).identificacaoDocente(6);
                }else{
                    System.out.println("Docente não encontrado");
                }
            } else if (op == 7) {
                break;
            }
        }
    }
    public static void main(String[] args) {
        Docente d1 = new Docente("45","Henry Manuel Viana");
        Docente d2 = new Docente("22","Lucia Vieira Souza");
        Docente d3 = new Docente("15","Allana Isabella Costa");
        Docente d4 = new Docente("89","Daniel Arthur Dias");
        Docente d5 = new Docente("82","Livia Amanda Araujo");
        Docente d6 = new Docente("66","Tim Figueiredo");
        Docente d7 = new Docente("56","Guilherme de Cruz Rocha");
        Turma t1 = new Turma("044","A",21,"Arquitetura de Software","10-01-2022");
        Turma t2 = new Turma("049","B",16,"Arquitetura de Software","10-01-2022");
        Turma t3 = new Turma("521","A",18,"C#","17-01-2022");
        Turma t4 = new Turma("454","B",29,"C#","17-01-2022");
        Turma t5 = new Turma("418","A",22,"JAVA","17-01-2022");
        Turma t6 = new Turma("756","A",14,"Estruturas de dados","10-01-2022");
        Turma t7 = new Turma("126","A",12,"Qualidade de Software","17-01-2022");
        t1.addDocente(d1);
        t1.addDocente(d7);
        t2.addDocente(d1);
        t2.addDocente(d3);
        t3.addDocente(d6);
        t4.addDocente(d2);
        t5.addDocente(d3);
        t5.addDocente(d2);
        t6.addDocente(d5);
        t7.addDocente(d4);
        menuInicial();
    }
}
