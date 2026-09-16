/*
Q3 — Referências
Sem executar, escreva o que será impresso e depois confira:
Livro a = new Livro();
a.titulo = "Clean Code";
Livro b = a;
Livro c = new Livro();
c.titulo = "Clean Code";
b.emprestar();
IO.println(a.emprestado);
IO.println(b.emprestado);
IO.println(c.emprestado);
IO.println(a == b);
IO.println(a == c);
*/
/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios2/"
javac Classes3.java -d bin
java -cp bin Classes3
*/


class Livro {
    String titulo;
    boolean emprestado;

    Livro() {
        titulo = "";
        emprestado = false;
    }

    void emprestar() {
        emprestado = true;
    }
}

void main() {
    Livro a = new Livro();
    a.titulo = "Clean Code";
    Livro b = a;
    Livro c = new Livro();
    c.titulo = "Clean Code";
    b.emprestar();

    // Esperado (sem executar):
    // a.emprestado -> true   (b é a mesma referência que a)
    // b.emprestado -> true
    // c.emprestado -> false  (c é outro objeto)
    // a == b       -> true
    // a == c       -> false

    IO.println(a.emprestado);
    IO.println(b.emprestado);
    IO.println(c.emprestado);
    IO.println(a == b);
    IO.println(a == c);
}
