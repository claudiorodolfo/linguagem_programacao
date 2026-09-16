/*
Q1 — Classe Turma (1–N)
Crie Turma com codigo (String) e até 40 Aluno, utilizando arranjo +
quantidade. Implemente matricular(Aluno a), mediaDaTurma() e listar().
Aluno possui nome e media encapsulados. O void main() não acessa
diretamente o arranjo interno.
*/
/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios2/"
javac Relacionamentos1.java -d bin
java -cp bin Relacionamentos1
*/


class Aluno {
    private String nome;
    private double media;

    Aluno(String nome, double media) {
        this.nome = nome;
        this.media = media;
    }

    String getNome() {
        return nome;
    }

    double getMedia() {
        return media;
    }
}

class Turma {
    private String codigo;
    private Aluno[] alunos;
    private int quantidade;

    Turma(String codigo) {
        this.codigo = codigo;
        this.alunos = new Aluno[40];
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

    void listar() {
        IO.println("Turma " + codigo + ":");
        for (int i = 0; i < quantidade; i++) {
            IO.println("  " + alunos[i].getNome()
                    + " | média: " + alunos[i].getMedia());
        }
    }
}

void main() {
    var turma = new Turma("LP1-T1");
    turma.matricular(new Aluno("Ana", 8.0));
    turma.matricular(new Aluno("Bruno", 6.5));
    turma.matricular(new Aluno("Carla", 9.0));

    turma.listar();
    IO.println("Média da turma: " + turma.mediaDaTurma());
    // turma.alunos[0] não compila: o arranjo é private.
}
