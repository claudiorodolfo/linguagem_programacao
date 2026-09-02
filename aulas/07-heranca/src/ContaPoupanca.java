public class ContaPoupanca extends Conta {

    private double taxaJuros; // 0.01 = 1% ao período

    public ContaPoupanca(String numero, double saldoInicial, double taxaJuros) {
        // Java 25: prólogo antes de super(...) — valida sem usar this
        if (taxaJuros < 0) {
            throw new IllegalArgumentException("taxa de juros >= 0");
        }
        super(numero, saldoInicial);
        this.taxaJuros = taxaJuros;
    }

    public void render() {
        depositar(getSaldo() * taxaJuros);
    }

    @Override
    public String toString() {
        return super.toString() + " juros=" + taxaJuros;
    }
}
