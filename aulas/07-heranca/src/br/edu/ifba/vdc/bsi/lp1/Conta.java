package br.edu.ifba.vdc.bsi.lp1;

/** Superclasse: estado comum e saque conservador (sem negativo). */
public class Conta {

    private String numero;
    protected double saldo;

    public Conta(String numero, double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("saldo inicial >= 0");
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
            throw new IllegalArgumentException("depósito positivo");
        }
        saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor <= 0 || valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + numero + " saldo=" + saldo;
    }
}
