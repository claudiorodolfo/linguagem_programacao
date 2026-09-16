/*
Q3 — Completar ContaBancaria
Partindo da classe da aula, verifique se entende transferir e o
contador estático. Acrescente ContaBancaria(String numero) se
necessário, utilizando this(numero, 0.0). Crie 3 contas e imprima
totalDeContas. Explique em um comentário a diferença entre
totalDeContas (da classe) e saldo (do objeto).
*/
/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios2/"
javac Metodos3.java -d bin
java -cp bin Metodos3
*/


class ContaBancaria {
    static int totalDeContas = 0;

    String numero;
    double saldo;

    ContaBancaria(String numero) {
        this(numero, 0.0);
    }

    ContaBancaria(String numero, double saldoInicial) {
        this.numero = numero;
        this.saldo = saldoInicial;
        totalDeContas++;
    }

    void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    boolean sacar(double valor) {
        if (valor <= 0 || valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }

    boolean transferir(ContaBancaria destino, double valor) {
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }
}

void main() {
    var c1 = new ContaBancaria("001", 500);
    var c2 = new ContaBancaria("002", 200);
    var c3 = new ContaBancaria("003");

    c1.transferir(c3, 100);

    IO.println("Conta " + c1.numero + " | saldo: " + c1.saldo);
    IO.println("Conta " + c2.numero + " | saldo: " + c2.saldo);
    IO.println("Conta " + c3.numero + " | saldo: " + c3.saldo);
    IO.println("totalDeContas: " + ContaBancaria.totalDeContas);

    // totalDeContas é da CLASSE: um só valor, compartilhado.
    // ContaBancaria.totalDeContas faz sentido (aqui, 3).
    // saldo é do OBJETO: cada conta tem o seu.
    // ContaBancaria.saldo não faz sentido — saldo de qual conta?
}
