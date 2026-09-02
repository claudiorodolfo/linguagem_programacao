package br.edu.ifba.vdc.bsi.lp1;

// Acessar o diretório dos fontes:
// cd aulas/14-depuracao/versao-corrigida
// Compilar e enviar os .class para a pasta out:
// javac --release 25 -d out br/edu/ifba/vdc/bsi/lp1/*.java
// Executar a partir desta pasta, usando out no classpath:
// java -cp out br.edu.ifba.vdc.bsi.lp1.TransferenciaCorrigida

public class TransferenciaCorrigida {

    void main() {
        Conta ana = new Conta("Ana", 500);
        Conta bruno = new Conta("Bruno", 100);
        IO.println("Antes: " + ana + " | " + bruno);
        ana.transferir(bruno, 150);
        IO.println("Depois: " + ana + " | " + bruno);
    }
}

class Conta {

    private String titular;
    private double saldo;

    Conta(String titular, double saldo) {
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

    void transferir(Conta destino, double valor) {
        if (sacar(valor)) {
            destino.depositar(valor);
        }
    }

    @Override
    public String toString() {
        return titular + " R$ " + saldo;
    }
}
