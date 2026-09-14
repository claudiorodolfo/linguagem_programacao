/*
Exercício 12
Faça uma classe ContaInvestimento que seja semelhante a classe ContaBancaria, 
com a diferença de que se adicione um atributo taxaJuros. Forneça um 
inicializador que configure tanto o saldo inicial como a taxa de juros. 
Forneça um método adicioneJuros() (sem parâmetro explícito) que adicione 
juros à conta.

Escreva um programa que construa uma poupança com um saldo inicial de 
R$1000,00 e uma taxa de juros de 10%. Depois aplique o método 
adicioneJuros() cinco vezes e imprime o saldo resultante.
*/

/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios1/"
javac Exercicio11.java -d bin
java -cp bin Exercicio11
*/
class ContaInvestimento {
    private double saldo;
    private final double taxaJuros;

    public ContaInvestimento(double saldoInicial, double taxaJuros) {
        this.saldo = saldoInicial;
        this.taxaJuros = taxaJuros;
    }

    public void adicioneJuros() {
        saldo += saldo * taxaJuros;
    }

    public double getSaldo() {
        return saldo;
    }
}

public class Exercicio12 {
    void main() {
        var poupanca = new ContaInvestimento(
                1000,
                0.10
        );

        for (int i = 0; i < 5; i++) {
            poupanca.adicioneJuros();
        }

        IO.println("Saldo final: R$ %.2f%n".formatted(
            poupanca.getSaldo())
        );
    }
}