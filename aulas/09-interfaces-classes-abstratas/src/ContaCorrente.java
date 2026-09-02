public final class ContaCorrente extends Conta {

    private double limite;
    private double tarifaMensal;

    public ContaCorrente(String numero, double saldoInicial, double limite, double tarifaMensal) {
        if (limite < 0 || tarifaMensal < 0) {
            throw new IllegalArgumentException("limite e tarifa >= 0");
        }
        super(numero, saldoInicial);
        this.limite = limite;
        this.tarifaMensal = tarifaMensal;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= 0 || valor > saldo + limite) {
            return false;
        }
        saldo -= valor;
        return true;
    }

    @Override
    public void aplicarTaxasMensais() {
        saldo -= tarifaMensal; // pode ficar negativa até o limite, de propósito
    }
}
