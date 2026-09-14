/*
Exercício 13
Implemente a classe Funcionário. Um empregado tem um nome (um string) e 
um salário(um float). Escreva um construtor com dois parâmetros 
(nome e salário) e métodos para devolver nome e salário. Escreva um pequeno 
programa que teste sua classe.
*/

/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios1/"
javac Exercicio13.java -d bin
java -cp bin Exercicio13
*/

import java.io.IOException;

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
}

public class Exercicio13 {
    void main() {
        var funcionario = new Funcionario(
                "Harry",
                25000
        );

        System.out.println("Nome: " + funcionario.getNome());

        IO.println("Salário: R$ %.2f%n".formatted(
                funcionario.getSalario())
        );
    }
}