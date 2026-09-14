/*
Exercício 05
Crie uma classe para implementar uma conta corrente. 
A classe deve possuir os seguintes atributos: número da conta, 
nome do correntista e saldo. Os métodos são os seguintes: alterarNome, 
depósito e saque; No construtor, saldo é opcional, com valor default zero e 
os demais atributos são obrigatórios.
*/

/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios1/"
javac Exercicio05.java -d bin
java -cp bin Exercicio05
*/

class ContaCorrente {
    private String numero;
    private String nomeCorrentista;
    private double saldo;

    public ContaCorrente(String numero, String nomeCorrentista) {
        this(numero, nomeCorrentista, 0);
    }

    public ContaCorrente(
            String numero,
            String nomeCorrentista,
            double saldo) {

        this.numero = numero;
        this.nomeCorrentista = nomeCorrentista;
        this.saldo = saldo;
    }

    public void alterarNome(String novoNome) {
        nomeCorrentista = novoNome;
    }

    public void deposito(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean saque(double valor) {
        if (valor <= 0 || valor > saldo) {
            return false;
        }

        saldo -= valor;
        return true;
    }

    public double getSaldo() {
        return saldo;
    }
}

public class Exercicio05 {
    void main() {
        var conta = new ContaCorrente(
            "12345-6",
             "Maria"
        );

        conta.deposito(1000);

        IO.println("Saldo: R$ " + conta.getSaldo());

        conta.saque(300);

        IO.println("Saldo após saque: R$ " + conta.getSaldo());

        conta.alterarNome("Maria Silva");
    }
}