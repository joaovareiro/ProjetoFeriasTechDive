package com.vareiro.sistemafuncionarios;

public class Colaborador extends FuncionarioPadrao{
    private String dept;
    private String cpfLiderTecnico;

    public Colaborador(String cpf, String nome, String telefone, String endereco, String dept, String cpfLiderTecnico) {
        super(cpf, nome, telefone, endereco);
        this.dept = dept;
        this.cpfLiderTecnico = cpfLiderTecnico;
    }

    public String idLider(String cpfProcura){
        String a;
        if(LiderTecnico.procuraLiderTecnico(cpfProcura)==null){
            a = "Lider tecnico: não encontrado";
        }
        else{
            a = "Lider tecnico: " + (LiderTecnico.procuraLiderTecnico(cpfProcura)).getNome();
        }
        return a;
    }

    @Override
    public String identificacao(){
        return "Colaborador" +
                " cpf: " + getCpf() +
                " ; nome: " + getNome() +
                " ; telefone: " + getTelefone()+
                " ; endereco: " + getEndereco() +
                " ; departamento: " + dept +
                " ; " + isEmpregado() +
                " ; " + idLider(cpfLiderTecnico) ;
    }

    @Override
    public String toString() {
        return identificacao();
    }
}
