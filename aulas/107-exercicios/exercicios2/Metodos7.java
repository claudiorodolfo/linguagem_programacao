/*
Q7 — Questão Integradora
Considere a classe Conta:
class Conta {
    static int total = 0;
    String numero;
    double saldo;

    public Conta(String numero) {
        this(numero, 0.0);
    }
    public Conta(String numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
        total++;
    }
    public boolean sacar(double valor) {
        if (valor <= 0 || valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }
}
a) Depois de new Conta("001", 100); new Conta("002");, quanto vale
Conta.total? O que seria um erro conceitual: ler saldo pela classe
(Conta.saldo)?
b) Por que this(numero, 0.0) precisa ser a primeira instrução do
construtor de um argumento?
c) Escreva boolean transferir(Conta destino, double valor) que só
deposita no destino se o saque na origem funcionar. Assuma que
existe void depositar(double valor).
*/

class Conta {
    static int total = 0;
    String numero;
    double saldo;

    Conta(String numero) {
        this(numero, 0.0);
    }

    Conta(String numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
        total++;
    }

    boolean sacar(double valor) {
        if (valor <= 0 || valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }

    void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    boolean transferir(Conta destino, double valor) {
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }
}

void main() {
    var origem = new Conta("001", 100);
    var destino = new Conta("002");

    // a) Conta.total vale 2: cada new chama o construtor de dois
    //    argumentos (direto ou via this) e faz total++.
    //    Conta.saldo é erro conceitual: saldo é do OBJETO, não da
    //    classe. Qual das duas contas? Use origem.saldo.

    // b) this(...) encadeia o outro construtor e precisa ser a
    //    primeira instrução; caso contrário, o programa não compila.

    origem.transferir(destino, 40);

    IO.println("total: " + Conta.total);
    IO.println("001: " + origem.saldo);
    IO.println("002: " + destino.saldo);
}
