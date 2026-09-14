/*
Q4 — this e sobrecarga
Na classe Livro da aula, o construtor sem argumentos chama this(...).
O que aconteceria se essa chamada não fosse a primeira instrução?
Depois, escreva Livro(String titulo, String autor) usando encadeamento
e fazendo ano = 0.
*/

class Livro {
    String titulo;
    String autor;
    int ano;
    boolean emprestado;

    Livro() {
        this("sem título", "desconhecido", 0);
    }

    Livro(String titulo, String autor) {
        this(titulo, autor, 0);
    }

    Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.emprestado = false;
    }

    String descricao() {
        var status = emprestado ? "emprestado" : "disponível";
        return titulo + " (" + autor + ", " + ano + ") — " + status;
    }
}

void main() {
    // this(...) precisa ser a PRIMEIRA instrução do construtor.
    // Se vier depois de qualquer outra linha, o código NÃO COMPILA.
    //
    // Livro() {
    //     IO.println("iniciando"); // erro de compilação
    //     this("sem título", "desconhecido", 0);
    // }

    var semDados = new Livro();
    var comTituloAutor = new Livro("Clean Code", "Robert Martin");
    var completo = new Livro("Java Efetivo", "Joshua Bloch", 2018);

    IO.println(semDados.descricao());
    IO.println(comTituloAutor.descricao());
    IO.println(completo.descricao());
}
