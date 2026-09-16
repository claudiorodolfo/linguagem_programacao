/*
Q2 — Classe Aluno
Crie a classe Aluno com String nome, String matricula, double n1 e
double n2. O construtor recebe nome e matrícula; as notas começam
em 0. Implemente lancarNotas(double n1, double n2), media() e
aprovado() (média ≥ 7). Crie três alunos e imprima um relatório.
*/
/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios2/"
javac Metodos2.java -d bin
java -cp bin Metodos2
*/


class Aluno {
    String nome;
    String matricula;
    double n1;
    double n2;

    Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.n1 = 0;
        this.n2 = 0;
    }

    void lancarNotas(double n1, double n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    double media() {
        return (n1 + n2) / 2;
    }

    boolean aprovado() {
        return media() >= 7;
    }
}

void main() {
    var a1 = new Aluno("Ana", "20261001");
    var a2 = new Aluno("Bruno", "20261002");
    var a3 = new Aluno("Carla", "20261003");

    a1.lancarNotas(8.0, 7.5);
    a2.lancarNotas(5.0, 6.0);
    a3.lancarNotas(9.0, 8.5);

    imprimir(a1);
    imprimir(a2);
    imprimir(a3);
}

void imprimir(Aluno aluno) {
    var situacao = aluno.aprovado() ? "aprovado" : "reprovado";
    IO.println(aluno.nome
            + " | " + aluno.matricula
            + " | média: " + aluno.media()
            + " | " + situacao);
}
