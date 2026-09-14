/*
7. Desafio Final — Integração
Relacionamento escolhido: N:N (Usuario — Livro via Emprestimo).

Usuario 1 ── 0..5 Emprestimo  0..* ── 1 Livro

O diagrama correspondente está em Diagramas8.puml.
Critério: o código e o UML representam o mesmo modelo.
*/

class Livro {
    private String titulo;
    private boolean emprestado;

    Livro(String titulo) {
        this.titulo = titulo;
        this.emprestado = false;
    }

    String getTitulo() {
        return titulo;
    }

    boolean emprestar() {
        if (emprestado) {
            return false;
        }
        emprestado = true;
        return true;
    }

    void devolver() {
        emprestado = false;
    }
}

class Emprestimo {
    private String data;
    private Livro livro;

    Emprestimo(String data, Livro livro) {
        this.data = data;
        this.livro = livro;
    }

    String resumo() {
        return data + " → " + livro.getTitulo();
    }
}

class Usuario {
    private String nome;
    private Emprestimo[] emprestimos;
    private int quantidade;

    Usuario(String nome) {
        this.nome = nome;
        this.emprestimos = new Emprestimo[5];
        this.quantidade = 0;
    }

    String getNome() {
        return nome;
    }

    boolean registrar(Livro livro, String data) {
        if (livro == null || quantidade >= emprestimos.length) {
            return false;
        }
        if (!livro.emprestar()) {
            return false;
        }
        emprestimos[quantidade] = new Emprestimo(data, livro);
        quantidade++;
        return true;
    }

    void listarEmprestimos() {
        IO.println(nome + " (" + quantidade + "/" + emprestimos.length + "):");
        for (int i = 0; i < quantidade; i++) {
            IO.println("  " + emprestimos[i].resumo());
        }
    }
}

void main() {
    var ana = new Usuario("Ana");
    var clean = new Livro("Clean Code");
    var uml = new Livro("UML Distilled");
    var java = new Livro("Effective Java");

    IO.println("1º: " + ana.registrar(clean, "2026-03-10"));
    IO.println("2º: " + ana.registrar(uml, "2026-03-11"));
    IO.println("já emprestado: " + ana.registrar(clean, "2026-03-12"));
    IO.println("3º: " + ana.registrar(java, "2026-03-13"));

    ana.listarEmprestimos();
}
