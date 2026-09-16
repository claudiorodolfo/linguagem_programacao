/*
Q2 — Variável
Na ContaBancaria encapsulada, explique por que não deve existir
setSaldo(double saldo). Relacione a resposta ao conceito de 
Regras que devem continuar sendo verdadeiras durante toda a 
existência de um objeto (Invariante): e ao risco de permitir 
alterações arbitrárias no estado.
*/
/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios2/"
javac Pacotes2.java -d bin
java -cp bin Pacotes2
*/


class ContaBancaria {
    private String numero;
    private double saldo;

    ContaBancaria(String numero, double saldoInicial) {
        this.numero = numero;
        this.saldo = saldoInicial < 0 ? 0 : saldoInicial;
    }

    String getNumero() {
        return numero;
    }

    double getSaldo() {
        return saldo;
    }

    // Não existe setSaldo(double saldo).
    // Regras que devem continuar sendo verdadeiras durante toda a 
    // existência de um objeto (Invariante): 
    // saldo nunca fica negativo; só muda por depósito
    // ou saque, que validam o valor. Um setter cego aceitaria
    // conta.setSaldo(-999) ou setSaldo(1_000_000) e quebraria a
    // regra — alteração arbitrária do estado, sem operação de
    // negócio. Encapsular é proteger essa variável, não gerar
    // get/set para cada atributo.

    void depositar(double valor) {
        if (valor <= 0) {
            IO.println("Depósito deve ser positivo.");
            return;
        }
        saldo += valor;
    }

    boolean sacar(double valor) {
        if (valor <= 0 || valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }
}

void main() {
    var conta = new ContaBancaria("001", 200);
    conta.depositar(50);
    IO.println("Saque 300? " + conta.sacar(300));
    IO.println("Saldo: " + conta.getSaldo());
    // conta.saldo = -10;           // não compila: private
    // conta.setSaldo(-10);         // não existe — de propósito
}
