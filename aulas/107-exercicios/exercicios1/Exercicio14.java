/*
Exercício 14
Aprimore a classe do exercício anterior para adicionar o método aumentarSalario() (porcentualDeAumento) que aumente o salário do funcionário em uma certa porcentagem.
Exemplo de uso:
var harry = new Funcionario('Harry', 25000)
harry.aumentarSalario(10)
*/

/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios1/"
javac Exercicio14.java -d bin
java -cp bin Exercicio14
*/
class Funcionario {
    private final String nome;
    private double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public void aumentarSalario(double percentualDeAumento) {
        if (percentualDeAumento > 0) {
            salario += salario * percentualDeAumento / 100;
        }
    }
}

public class Exercicio14 {
    void main() {
        var harry = new Funcionario(
                "Harry",
                25000
        );

        IO.println("Salário antes: R$ %.2f%n".formatted(
                harry.getSalario())
        );

        harry.aumentarSalario(10);

        IO.println("Salário depois: R$ %.2f%n".formatted(
                harry.getSalario())
        );
    }
}