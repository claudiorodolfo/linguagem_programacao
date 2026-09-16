/*
Q7 — Questão Integradora
A classe ContaBancaria está em
br.edu.ifba.conquista.lp1.exercicio.modelo e a Demo em
br.edu.ifba.conquista.lp1.exercicio.
*/

package br.edu.ifba.conquista.lp1.exercicio.modelo;

public class ContaBancaria {
    private String numero;
    private double saldo;

    public ContaBancaria(String numero, double saldoInicial) {
        this.numero = numero;
        this.saldo = saldoInicial < 0 ? 0 : saldoInicial;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        if (valor <= 0 || valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }
}
