/*
Q6 — Pacote da aula
Mova Turma e Aluno para br.edu.ifba.conquista.lp1.aula05.exercicio.modelo
e o programa principal para br.edu.ifba.conquista.lp1.aula05.exercicio.app.
Compile com -d out e execute pelo nome qualificado.
*/

// Fontes nos pacotes (pastas = pacotes):
//   br/edu/ifba/conquista/lp1/aula05/exercicio/modelo/Aluno.java
//   br/edu/ifba/conquista/lp1/aula05/exercicio/modelo/Turma.java
//   br/edu/ifba/conquista/lp1/aula05/exercicio/app/Principal.java
//
// O app importa Aluno e Turma porque está em outro pacote.
// Construtores e métodos usados de fora são public.
// Compilar e executar (nesta pasta, exercicios2):
//
//   javac --release 25 -d out \
//     br/edu/ifba/conquista/lp1/aula05/exercicio/modelo/Aluno.java \
//     br/edu/ifba/conquista/lp1/aula05/exercicio/modelo/Turma.java \
//     br/edu/ifba/conquista/lp1/aula05/exercicio/app/Principal.java
//   java -cp out br.edu.ifba.conquista.lp1.aula05.exercicio.app.Principal
//
// -d out grava os .class em out/br/edu/ifba/... (espelho do pacote).
// A execução usa o nome qualificado, não o nome do arquivo.

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
    turma.matricular(new Aluno("Bruno", 7.0));
    turma.listar();
    IO.println("média: " + turma.mediaDaTurma());
}
