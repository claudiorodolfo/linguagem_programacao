package br.edu.ifba.conquista.lp1.aula05.exercicio.app;

import br.edu.ifba.conquista.lp1.aula05.exercicio.modelo.Aluno;
import br.edu.ifba.conquista.lp1.aula05.exercicio.modelo.Turma;

public class Principal {

    void main() {
        var turma = new Turma("LP1-T1");
        turma.matricular(new Aluno("Ana", 8.0));
        turma.matricular(new Aluno("Bruno", 7.0));
        turma.listar();
        IO.println("média: " + turma.mediaDaTurma());
    }
}
