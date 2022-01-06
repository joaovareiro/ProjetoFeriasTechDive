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
                    4 - Listar turmas com seus respectivos assuntos, docentes e semanas
                    5 - Listar todos os docentes
                    6 - Listar um docente e suas semanas de aula já definidas
                    7 - Sair""");

            op = sc.nextInt();
            if (op == 1) {
                System.out.printf("Digite o numero de identificacao da turma:\n");
                sc.nextLine();
                String idTurma= sc.nextLine();
                System.out.printf("Digite o nome da turma: \n");
                String nomeTurma = sc.nextLine();
                System.out.println("Digite a quantidade de alunos: \n");
                int qtdAlunos = sc.nextInt();
                System.out.println("Digite a data de inicio das aulas");
                String datainicio = sc.nextLine();
                Turma t1 = new Turma(idTurma,nomeTurma,qtdAlunos,datainicio);
            } else if (op == 2) {
                System.out.printf("Digite o numero de identificacao do docente:\n");
                sc.nextLine();
                String idDocente = sc.nextLine();
                System.out.printf("Digite o nome do docente: \n");
                String nomeDocente = sc.nextLine();
                Docente d1 = new Docente(idDocente,nomeDocente);
            } else if (op == 3) {
            } else if (op == 4) {
            } else if (op == 5) {
                Docente.listaDocentes();
            } else if (op == 6) {
            } else if (op == 7) {
                break;
            }
        }
    }
    public static void main(String[] args) {
        menuInicial();
    }
}
