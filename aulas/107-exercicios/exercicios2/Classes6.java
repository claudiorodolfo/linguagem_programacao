/*
Q6 — Várias Referências, Um Objeto
Crie um Livro e atribua três variáveis (a, b, d) à mesma instância.
Atribua uma quarta variável (c) a outra instância. Empreste via d.
Antes de executar, diga o que espera em a.emprestado, b.emprestado,
c.emprestado e d.emprestado; depois confira.
*/

class Livro {
    String titulo;
    boolean emprestado;

    void emprestar() {
        emprestado = true;
    }
}

void main() {
    Livro a = new Livro();
    a.titulo = "Clean Code";
    Livro b = a;
    Livro d = a;

    Livro c = new Livro();
    c.titulo = "Java Efetivo";

    d.emprestar();

    // Esperado (sem executar):
    // a.emprestado -> true   (a, b e d apontam para o mesmo objeto)
    // b.emprestado -> true
    // c.emprestado -> false  (c aponta para outro objeto)
    // d.emprestado -> true

    IO.println(a.emprestado);
    IO.println(b.emprestado);
    IO.println(c.emprestado);
    IO.println(d.emprestado);
}
