public class ContaCorrente extends Conta {

    private double limite;

    public ContaCorrente(String numero, double saldoInicial, double limite) {
        if (limite < 0) {
            throw new IllegalArgumentException("limite >= 0");
        }
        super(numero, saldoInicial);
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= 0 || valor > saldo + limite) {
            return false;
        }
        saldo -= valor;
        return true;
    }
}
