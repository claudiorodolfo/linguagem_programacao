package br.edu.ifba.vdc.bsi.lp1;

/**
 * Conta com invariante: saldo só muda por operações nomeadas.
 */
public class ContaLimpa {

    public static final double TARIFA_TRANSFERENCIA = 0.0;

    private final String titular;
    private double saldo;

    /**
     * @param titular nome não vazio
     * @param saldoInicial deve ser ≥ 0
     */
    public ContaLimpa(String titular, double saldoInicial) {
        if (titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException("titular obrigatório");
        }
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("saldo inicial não pode ser negativo");
        }
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    /**
     * Credita valor estritamente positivo.
     */
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("depósito deve ser positivo");
        }
        saldo += valor;
    }

    /**
     * Debita se houver saldo. Recusa valor não positivo.
     * @return false se a operação não puder ser concluída
     */
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

    /**
     * Saque nesta conta e depósito na destino. Nada acontece se o saque falhar.
     */
    public boolean transferir(ContaLimpa destino, double valor) {
        if (destino == null || destino == this) {
            return false;
        }
        if (!sacar(valor + TARIFA_TRANSFERENCIA)) {
            return false;
        }
        destino.depositar(valor);
        return true;
    }

    public String extratoFormatado() {
        return titular + " | R$ " + saldo;
    }
}
