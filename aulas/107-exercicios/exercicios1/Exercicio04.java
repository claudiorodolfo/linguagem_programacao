/*
Exercício 04
Crie uma classe que modele uma pessoa:
Atributos: nome, idade, peso e altura
Métodos: Envelhecer, engordar, emagrecer, crescer. 
Obs: Por padrão, a cada ano que nossa pessoa envelhece, 
sendo a idade dela menor que 21 anos, ela deve crescer 0,5 cm.
*/

/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios1/"
javac Exercicio04.java -d bin
java -cp bin Exercicio04
*/

class Pessoa {
    private String nome;
    private int idade;
    private double peso;
    private double altura;

    public Pessoa(String nome, int idade, double peso, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
    }

    public void envelhecer() {
        idade++;

        if (idade < 21) {
            altura += 0.005; // 0,5 cm = 0,005 m
        }
    }

    public void engordar(double quantidade) {
        peso += quantidade;
    }

    public void emagrecer(double quantidade) {
        engordar(-quantidade);
    }

    public void crescer(double quantidade) {
        altura += quantidade;
    }

    public void mostrarDados() {
        IO.println("Nome: " + nome);
        IO.println("Idade: " + idade);
        IO.println("Peso: " + peso + " kg");
        IO.println("Altura: " + altura + " m");
    }
}

public class Exercicio04 {
    void main() {
        var pessoa = new Pessoa(
                "João",
                18,
                70,
                1.70
        );

        pessoa.mostrarDados();

        pessoa.envelhecer();
        pessoa.engordar(2);

        IO.println("\nDepois das alterações:");

        pessoa.mostrarDados();
    }
}