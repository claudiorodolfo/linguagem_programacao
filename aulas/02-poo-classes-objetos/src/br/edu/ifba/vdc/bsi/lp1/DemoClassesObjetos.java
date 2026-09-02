package br.edu.ifba.vdc.bsi.lp1;

/**
 * Live coding: classe versus objeto, objetos independentes e alias de referência.
 */
public class DemoClassesObjetos {

    void main() {
        demonstrarDoisObjetos();
        IO.println();
        demonstrarAliasDeReferencia();
        IO.println();
        demonstrarNull();
    }

    static void demonstrarDoisObjetos() {
        Livro l1 = new Livro();
        l1.titulo = "Clean Code";
        l1.autor = "Robert C. Martin";

        Livro l2 = new Livro();
        l2.titulo = "Java efetivo";
        l2.autor = "Joshua Bloch";

        l1.emprestar();
        IO.println(l1.descricao());
        IO.println(l2.descricao());
        l1.emprestar(); // já emprestado — regra neste objeto, não no outro
    }

    static void demonstrarAliasDeReferencia() {
        Livro a = new Livro();
        a.titulo = "Use a cabeça! Java";
        a.autor = "Sierra";

        Livro b = a; // alias: mesmo objeto
        Livro c = new Livro();
        c.titulo = "Use a cabeça! Java";
        c.autor = "Sierra";

        b.emprestar();
        IO.println("a: " + a.descricao());
        IO.println("b: " + b.descricao());
        IO.println("c: " + c.descricao());
        IO.println("a == b? " + (a == b));
        IO.println("a == c? " + (a == c));
    }

    static void demonstrarNull() {
        Livro livro = null;
        IO.println("livro == null? " + (livro == null));
        // livro.emprestar(); // NullPointerException — descomente no projetor
    }
}
