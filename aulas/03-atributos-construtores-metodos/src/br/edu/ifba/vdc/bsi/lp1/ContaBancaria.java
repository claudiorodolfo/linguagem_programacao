package br.edu.ifba.vdc.bsi.lp1;

/**
 * Conta bancária didática: cada objeto tem o próprio saldo.
 * Contador estático pertence à classe.
 */
public class ContaBancaria {

    static int totalDeContas = 0;

    String numero;
    double saldo;

    public ContaBancaria(String numero) {
        this(numero, 0.0);
    }

    public ContaBancaria(String numero, double saldoInicial) {
        this.numero = numero;
        this.saldo = saldoInicial;
        totalDeContas++;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            IO.println("Depósito deve ser positivo.");
            return;
        }
        saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor <= 0) {
            IO.println("Saque deve ser positivo.");
            return false;
        }
        if (valor > saldo) {
            IO.println("Saldo insuficiente na conta " + numero);
            return false;
        }
        saldo -= valor;
        return true;
    }

    public boolean transferir(ContaBancaria destino, double valor) {
        if (destino == null) {
            return false;
        }
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public String extratoResumido() {
        return "Conta " + numero + " | saldo: R$ " + saldo;
    }
}
