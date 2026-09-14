/*
Q2 — Dois Objetos, Dois Estados
Utilize a classe Livro apresentada em aula. Crie dois objetos Livro.
Empreste somente o primeiro. Imprima descricao() dos dois objetos e
explique, em um comentário, por que o segundo continua disponível.
*/

class Livro {
    String titulo;
    String autor;
    boolean emprestado;

    void emprestar() {
        emprestado = true;
    }

    String descricao() {
        var status = emprestado ? "emprestado" : "disponível";
        return titulo + " (" + autor + ") — " + status;
    }
}

void main() {
    Livro livro1 = new Livro();
    livro1.titulo = "Clean Code";
    livro1.autor = "Robert Martin";

    Livro livro2 = new Livro();
    livro2.titulo = "Java Efetivo";
    livro2.autor = "Joshua Bloch";

    livro1.emprestar();

    IO.println(livro1.descricao());
    IO.println(livro2.descricao());

    // livro1 e livro2 apontam para objetos diferentes.
    // emprestar() muda só o estado do objeto de livro1;
    // o de livro2 continua com emprestado == false (disponível).
}
