/*
Q1 — Classe Pessoa
Crie a classe Pessoa com os atributos String nome e int idade.
Não declare construtor. Implemente String apresentar(), retornando
algo como “Ana (20 anos)”. No void main(), crie duas pessoas e
imprima as apresentações.
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
