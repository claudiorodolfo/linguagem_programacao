package br.edu.ifba.conquista.lp1.aula04.modelo;

/** Saldo só muda por depósito e saque. Não há setSaldo. */
public class ContaBancaria {

    private String numero;
    private double saldo;

    public ContaBancaria(String numero, double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("saldo inicial não pode ser negativo");
        }
        this.numero = numero;
        this.saldo = saldoInicial;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("depósito deve ser positivo");
        }
        saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor <= 0) {
            return false;
        }
        if (valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }
}
