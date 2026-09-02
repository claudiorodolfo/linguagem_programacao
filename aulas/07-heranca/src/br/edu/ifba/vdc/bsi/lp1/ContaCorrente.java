package br.edu.ifba.vdc.bsi.lp1;

public class ContaCorrente extends Conta {

    private double limite; // quanto pode ficar negativa

    public ContaCorrente(String numero, double saldoInicial, double limite) {
        if (limite < 0) {
            throw new IllegalArgumentException("limite >= 0");
        }
        super(numero, saldoInicial);
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= 0) {
            return false;
        }
        if (valor > saldo + limite) {
            return false;
        }
        saldo -= valor;
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " limite=" + limite;
    }
}
