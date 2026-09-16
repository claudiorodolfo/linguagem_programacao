/*
Q1 — Classe Pessoa
Crie a classe Pessoa com os atributos String nome e int idade.
Não declare construtor. Implemente String apresentar(), retornando
algo como “Ana (20 anos)”. No void main(), crie duas pessoas e
imprima as apresentações.
*/
/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios2/"
javac Classes1.java -d bin
java -cp bin Classes1
*/


class Pessoa {
    String nome;
    int idade;

    String apresentar() {
        return nome + " (" + idade + " anos)";
    }
}

void main() {
    Pessoa p1 = new Pessoa();
    p1.nome = "Ana";
    p1.idade = 20;

    Pessoa p2 = new Pessoa();
    p2.nome = "Carlos";
    p2.idade = 22;

    IO.println(p1.apresentar());
    IO.println(p2.apresentar());
}
