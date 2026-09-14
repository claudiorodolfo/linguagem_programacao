/*
Q7 — Questão Integradora
a) Os atributos de uma ContaBancaria devem ser public ou private?
Explique sua escolha relacionando-a ao conceito de invariante da
classe (pense em quem deve ter permissão para alterar diretamente
o saldo e em como a classe pode garantir que ele permaneça válido).
b) Por que não deve existir setSaldo(double s)? O que uma pessoa
mal intencionada poderia fazer se tivesse acesso a esse método?
c) A classe ContaBancaria está em
br.edu.ifba.conquista.lp1.aula04.modelo e a Demo em
br.edu.ifba.conquista.lp1.aula04. Cite duas consequências práticas
dessa organização, considerando aspectos como: organização das
pastas no disco; necessidade de import; compilação utilizando -d.
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
}

void main() {
    var conta = new ContaBancaria("001", 200);
    conta.depositar(50);
    conta.sacar(30);
    IO.println(conta.getNumero() + " | saldo: " + conta.getSaldo());

    // a) private. Invariante: saldo nunca negativo. Ninguém de
    //    fora deve alterar o saldo direto (conta.saldo = -10).
    //    Só depositar/sacar (e o construtor) mudam o estado, e
    //    só depois de validar. public entregaria o saldo a
    //    qualquer um e a classe não conseguiria garantir validade.

    // b) setSaldo(double s) é um furo: atribui sem regra. Uma
    //    pessoa mal intencionada faria setSaldo(1_000_000) ou
    //    setSaldo(-1) e inventaria ou destruiria dinheiro. Saldo
    //    só muda por operação de negócio (depósito, saque).

    // c) Duas consequências (vale qualquer par destas):
    //    1) Pastas no disco espelham o pacote:
    //       .../aula04/modelo/ContaBancaria.java e
    //       .../aula04/Demo.java (ou DemoEncapsulamento.java).
    //    2) A Demo está em outro pacote: precisa
    //       import br.edu.ifba.conquista.lp1.aula04.modelo.ContaBancaria;
    //    3) javac -d out gera out/br/edu/ifba/conquista/lp1/aula04/...
    //       e a execução usa o nome qualificado
    //       (java -cp out br.edu.ifba.conquista.lp1.aula04.Demo).
}
