/*
Q7 — Questão Integradora
Uma Disciplina possui vários Aluno (no máximo 50). Cada aluno tem
nome (String) e media (double). Cada aluno tem um Endereco.
a) Escreva o esqueleto de Disciplina com construtor que recebe o nome
da disciplina, boolean matricular(Aluno a) e double mediaDaTurma().
Você pode usar array. Atributos private.
b) Classifique Disciplina–Aluno e Aluno–Endereco (associação,
agregação ou composição) e a cardinalidade (1–1, 1–N). Justifique
com o ciclo de vida.
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

class Aluno {
    private String nome;
    private double media;
    private Endereco endereco;

    Aluno(String nome, double media, Endereco endereco) {
        this.nome = nome;
        this.media = media;
        this.endereco = endereco;
    }

    String getNome() {
        return nome;
    }

    double getMedia() {
        return media;
    }

    String cidade() {
        return endereco.cidade();
    }
}

class Disciplina {
    private String nome;
    private Aluno[] alunos;
    private int quantidade;

    Disciplina(String nome) {
        this.nome = nome;
        this.alunos = new Aluno[50];
        this.quantidade = 0;
    }

    boolean matricular(Aluno a) {
        if (a == null || quantidade >= alunos.length) {
            return false;
        }
        alunos[quantidade] = a;
        quantidade++;
        return true;
    }

    double mediaDaTurma() {
        if (quantidade == 0) {
            return 0.0;
        }
        double soma = 0;
        for (int i = 0; i < quantidade; i++) {
            soma += alunos[i].getMedia();
        }
        return soma / quantidade;
    }

    String getNome() {
        return nome;
    }
}

void main() {
    var lp1 = new Disciplina("LP1");
    lp1.matricular(new Aluno("Ana", 8.0, new Endereco("Conquista")));
    lp1.matricular(new Aluno("Bruno", 7.0, new Endereco("Itapetinga")));

    IO.println(lp1.getNome() + " | média: " + lp1.mediaDaTurma());

    // b) Disciplina–Aluno: AGREGAÇÃO, 1–N.
    //    Ciclo de vida: a disciplina possui até 50 alunos (arranjo),
    //    mas o aluno não nasce nem morre com ela. Pode cursar outra
    //    disciplina, trancar, existir antes da oferta. “Tem um”,
    //    partes independentes — não é composição.
    //
    //    Aluno–Endereco: COMPOSIÇÃO, 1–1.
    //    Ciclo de vida: o endereço é parte do aluno (campo criado
    //    para aquele aluno, sem lista global de endereços). Se o
    //    aluno some, o endereço some com ele. Um aluno, um endereço.
}
