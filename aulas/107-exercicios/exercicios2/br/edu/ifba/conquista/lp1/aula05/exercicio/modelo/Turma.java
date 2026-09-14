package br.edu.ifba.conquista.lp1.aula05.exercicio.modelo;

public class Turma {
    private String codigo;
    private Aluno[] alunos;
    private int quantidade;

    public Turma(String codigo) {
        this.codigo = codigo;
        this.alunos = new Aluno[40];
        this.quantidade = 0;
    }

    public boolean matricular(Aluno a) {
        if (a == null || quantidade >= alunos.length) {
            return false;
        }
        alunos[quantidade] = a;
        quantidade++;
        return true;
    }

    public double mediaDaTurma() {
        if (quantidade == 0) {
            return 0.0;
        }
        double soma = 0;
        for (int i = 0; i < quantidade; i++) {
            soma += alunos[i].getMedia();
        }
        return soma / quantidade;
    }

    public void listar() {
        IO.println("Turma " + codigo + ":");
        for (int i = 0; i < quantidade; i++) {
            IO.println("  " + alunos[i].getNome()
                    + " | média: " + alunos[i].getMedia());
        }
    }
}
