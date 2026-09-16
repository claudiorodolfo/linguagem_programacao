/*
Q5 — N–N via classe associativa
Disciplina e Estudante: um estudante cursa várias disciplinas e uma
disciplina possui vários estudantes. Não use duas listas cruzadas
soltas: crie Matricula (estudante + disciplina + nota). Liste alunos
de uma disciplina percorrendo as matrículas.
*/
/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios2/"
javac Relacionamentos5.java -d bin
java -cp bin Relacionamentos5
*/


class Estudante {
    private String nome;

    Estudante(String nome) {
        this.nome = nome;
    }

    String getNome() {
        return nome;
    }
}

class Disciplina {
    private String nome;

    Disciplina(String nome) {
        this.nome = nome;
    }

    String getNome() {
        return nome;
    }
}

class Matricula {
    private Estudante estudante;
    private Disciplina disciplina;
    private double nota;

    Matricula(Estudante estudante, Disciplina disciplina, double nota) {
        this.estudante = estudante;
        this.disciplina = disciplina;
        this.nota = nota;
    }

    Estudante getEstudante() {
        return estudante;
    }

    Disciplina getDisciplina() {
        return disciplina;
    }

    double getNota() {
        return nota;
    }
}

class RegistroDeMatriculas {
    private Matricula[] matriculas;
    private int quantidade;

    RegistroDeMatriculas() {
        this.matriculas = new Matricula[100];
        this.quantidade = 0;
    }

    boolean registrar(Estudante estudante, Disciplina disciplina, double nota) {
        if (estudante == null || disciplina == null
                || quantidade >= matriculas.length) {
            return false;
        }
        matriculas[quantidade] = new Matricula(estudante, disciplina, nota);
        quantidade++;
        return true;
    }

    void listarAlunos(Disciplina disciplina) {
        IO.println("Alunos de " + disciplina.getNome() + ":");
        for (int i = 0; i < quantidade; i++) {
            if (matriculas[i].getDisciplina() == disciplina) {
                IO.println("  " + matriculas[i].getEstudante().getNome()
                        + " | nota: " + matriculas[i].getNota());
            }
        }
    }
}

void main() {
    var ana = new Estudante("Ana");
    var bruno = new Estudante("Bruno");
    var carla = new Estudante("Carla");

    var lp1 = new Disciplina("LP1");
    var calc = new Disciplina("Cálculo");

    var registro = new RegistroDeMatriculas();
    registro.registrar(ana, lp1, 8.0);
    registro.registrar(ana, calc, 7.0);
    registro.registrar(bruno, lp1, 6.5);
    registro.registrar(carla, calc, 9.0);

    registro.listarAlunos(lp1);
    registro.listarAlunos(calc);
    // Sem Estudante[] em Disciplina nem Disciplina[] em Estudante:
    // a N–N está nas matrículas.
}
