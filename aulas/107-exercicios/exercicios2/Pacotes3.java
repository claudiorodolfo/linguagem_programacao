/*
Q3 — Modificadores
Para cada situação, escolha private, nada (package-private),
protected ou public e justifique em uma frase: o atributo saldo de
ContaBancaria; o método sacar; um auxiliar boolean valorPositivo(double v)
usado só dentro da classe; a classe DemoEncapsulamento.
*/
/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios2/"
javac Pacotes3.java -d bin
java -cp bin Pacotes3
*/


class ContaBancaria {
    // saldo → private: só a própria classe altera, para manter
    // Regras que devem continuar sendo verdadeiras durante toda a 
    // existência de um objeto (Invariante):  
    // (nunca negativo) fora do alcance de outros.
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
    // ninguém de fora precisa enxergar essa operação auxiliar.
    private boolean valorPositivo(double v) {
        return v > 0;
    }
}

// DemoEncapsulamento → public: é o ponto de entrada;
// o java precisa enxergar a classe pelo nome qualificado.
// Aqui o arquivo é compacto, então o main fica abaixo (o nome
// do arquivo não combinaria com public class DemoEncapsulamento).

void main() {
    var conta = new ContaBancaria(100);
    IO.println("Sacar 30? " + conta.sacar(30));
    IO.println("Saldo: " + conta.getSaldo());

    // protected não cabe em nenhum dos quatro: não há herança
    // protected aparece quando existe subclasse.
}
