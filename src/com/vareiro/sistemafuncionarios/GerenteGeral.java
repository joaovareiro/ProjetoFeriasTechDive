package com.vareiro.sistemafuncionarios;

import java.util.ArrayList;

public class GerenteGeral extends FuncionarioPadrao {
    private ArrayList<GerenteDepartamento> listaGerentesDepartamento = new ArrayList<>();

    public GerenteGeral(String cpf, String nome, String telefone, String endereco) {
        super(cpf, nome, telefone, endereco);
    }
}
