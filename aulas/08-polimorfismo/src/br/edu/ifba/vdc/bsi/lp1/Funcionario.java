package br.edu.ifba.vdc.bsi.lp1;

public class Funcionario {

    private String nome;
    private double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public double folha() {
        return salario;
    }

    @Override
    public String toString() {
        return nome + " (" + getClass().getSimpleName() + ")";
    }
}
