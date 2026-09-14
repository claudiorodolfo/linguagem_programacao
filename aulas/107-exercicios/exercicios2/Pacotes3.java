/*
Q3 — Modificadores
Para cada situação, escolha private, nada (package-private),
protected ou public e justifique em uma frase: o atributo saldo de
ContaBancaria; o método sacar; um auxiliar boolean valorPositivo(double v)
usado só dentro da classe; a classe DemoEncapsulamento.
*/

class ContaBancaria {
    // saldo → private: só a própria classe altera, para manter
    // a invariante (nunca negativo) fora do alcance de outros.
    private double saldo;

    ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    double getSaldo() {
        return saldo;
    }

    // sacar → public: faz parte do contrato da conta; clientes
    // de qualquer pacote precisam poder sacar.
    public boolean sacar(double valor) {
        if (!valorPositivo(valor) || valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }

    // valorPositivo → private: detalhe interno, usado só aqui;
    // ninguém de fora precisa enxergar o auxiliar.
    private boolean valorPositivo(double v) {
        return v > 0;
    }
}

// DemoEncapsulamento → public: é o ponto de entrada da aula;
// o java precisa enxergar a classe pelo nome qualificado.
// Aqui o arquivo é compacto, então o main fica abaixo (o nome
// do arquivo não combinaria com public class DemoEncapsulamento).

void main() {
    var conta = new ContaBancaria(100);
    IO.println("Sacar 30? " + conta.sacar(30));
    IO.println("Saldo: " + conta.getSaldo());

    // protected não cabe em nenhum dos quatro: não há herança
    // nesta aula; protected volta quando existir subclasse.
}
