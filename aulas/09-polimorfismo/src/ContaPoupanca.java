public class ContaPoupanca extends Conta {

    private double taxaJuros;

    public ContaPoupanca(String numero, double saldoInicial, double taxaJuros) {
        if (taxaJuros < 0) {
            throw new IllegalArgumentException("taxa de juros >= 0");
        }
        super(numero, saldoInicial);
        this.taxaJuros = taxaJuros;
    }

    public void render() {
        depositar(getSaldo() * taxaJuros);
    }
}
