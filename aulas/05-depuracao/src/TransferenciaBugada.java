/**
 * Transferência que "parece" debitar, mas o dinheiro não chega ao destino.
 */
public class TransferenciaBugada {

    void main() {
        ContaDebug ana = new ContaDebug("Ana", 500);
        ContaDebug bruno = new ContaDebug("Bruno", 100);
        IO.println("Antes: " + ana + " | " + bruno);
        ana.transferir(bruno, 150);
        IO.println("Depois: " + ana + " | " + bruno);
    }
}

class ContaDebug {

    private String titular;
    private double saldo;

    ContaDebug(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    void depositar(double valor) {
        saldo += valor;
    }

    boolean sacar(double valor) {
        if (valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }

    void transferir(ContaDebug destino, double valor) {
        if (sacar(valor)) {
            // BUG: deposita na origem, não no destino.
            this.depositar(valor);
        }
    }

    @Override
    public String toString() {
        return titular + " R$ " + saldo;
    }
}
