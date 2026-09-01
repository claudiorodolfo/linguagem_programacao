/** Cópia didática da hierarquia de contas da aula 09, para a aula ser autocontida. */
public class Conta {

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

    public boolean sacar(double valor) {
        if (valor <= 0 || valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + numero + " saldo=" + saldo;
    }
}
