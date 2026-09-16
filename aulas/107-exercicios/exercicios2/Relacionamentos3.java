/*
Q3 — Classificar o Vínculo
Para cada par, diga se é associação, agregação ou composição e
informe a cardinalidade (1–1, 1–N, N–N). Justifique pelo ciclo de
vida: Usuario e Endereco; Turma e Aluno; Emprestimo como ligação
entre Usuario e Livro.
*/
/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios2/"
javac Relacionamentos3.java -d bin
java -cp bin Relacionamentos3
*/


class Endereco {
    private String cidade;

    Endereco(String cidade) {
        this.cidade = cidade;
    }

    String cidade() {
        return cidade;
    }
}

class Usuario {
    private String nome;
    private Endereco endereco;

    // O endereço nasce com o usuário — não há cadastro solto.
    Usuario(String nome, String cidade) {
        this.nome = nome;
        this.endereco = new Endereco(cidade);
    }

    String getNome() {
        return nome;
    }

    String cidade() {
        return endereco.cidade();
    }
}

class Aluno {
    private String nome;

    Aluno(String nome) {
        this.nome = nome;
    }

    String getNome() {
        return nome;
    }
}

class Turma {
    private Aluno[] alunos;
    private int quantidade;

    Turma() {
        this.alunos = new Aluno[40];
        this.quantidade = 0;
    }

    void matricular(Aluno a) {
        if (quantidade < alunos.length) {
            alunos[quantidade++] = a;
        }
    }
}

class Livro {
    private String titulo;

    Livro(String titulo) {
        this.titulo = titulo;
    }

    String getTitulo() {
        return titulo;
    }
}

class Emprestimo {
    private Usuario usuario;
    private Livro livro;

    Emprestimo(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
    }

    String resumo() {
        return usuario.getNome() + " → " + livro.getTitulo();
    }
}

void main() {
    var ana = new Usuario("Ana", "Conquista");
    var turma = new Turma();
    var aluno = new Aluno("Bruno");
    turma.matricular(aluno);
    var emprestimo = new Emprestimo(ana, new Livro("Clean Code"));

    IO.println(ana.getNome() + " mora em " + ana.cidade());
    IO.println(emprestimo.resumo());

    // Usuario e Endereco — COMPOSIÇÃO, 1–1.
    // Ciclo de vida: o Endereco é criado no construtor do Usuario
    // (new Endereco dentro da classe). Não vive sozinho nem entra
    // numa lista global. Some com o usuário. Um usuário, um endereço.

    // Turma e Aluno — AGREGAÇÃO, 1–N.
    // Ciclo de vida: a turma TEM alunos (arranjo), mas o Aluno
    // existe sem a turma — nasce antes, pode trocar de turma, segue
    // depois que a turma acaba. “Tem um”, partes independentes.

    // Emprestimo como ligação Usuario–Livro — ASSOCIAÇÃO N–N
    // (classe associativa). Cardinalidades do vínculo:
    //   Emprestimo — Usuario  (N–1 / cada empréstimo, 1 usuário)
    //   Emprestimo — Livro    (N–1 / cada empréstimo, 1 livro)
    //   Usuario — Livro       (N–N via Emprestimo)
    // Ciclo de vida: Usuario e Livro vivem sozinhos. O empréstimo
    // só os conhece (referências). Quando o empréstimo acaba, os
    // dois continuam. Não é composição: o livro não é “parte” do
    // empréstimo.
}
