public abstract sealed class Conta permits ContaPoupanca, ContaCorrente {

    private String numero;
    protected double saldo;

    public Conta(String numero, double saldoInicial) {
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

    /** Cada tipo de conta aplica sua política mensal. */
    public abstract void aplicarTaxasMensais();

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + numero + " saldo=" + saldo;
    }
}
