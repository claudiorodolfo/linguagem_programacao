package br.edu.ifba.conquista.lp1.aula04.modelo;

/**
 * Usuario 1–1 Endereco (composição) e 1–N Emprestimo (associação).
 */
public class Usuario {

    private static final int MAX_EMPRESTIMOS = 5;

    private String nome;
    private String matricula;
    private Endereco endereco;
    private Emprestimo[] emprestimos;
    private int quantidadeEmprestimos;

    public Usuario(String nome, String matricula, Endereco endereco) {
        this.nome = nome;
        this.matricula = matricula;
        this.endereco = endereco;
        this.emprestimos = new Emprestimo[MAX_EMPRESTIMOS];
        this.quantidadeEmprestimos = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String cidadeFormatada() {
        return endereco.formatado();
    }

    public boolean registrar(Emprestimo emprestimo) {
        if (emprestimo == null || quantidadeEmprestimos >= emprestimos.length) {
            return false;
        }
        emprestimos[quantidadeEmprestimos] = emprestimo;
        quantidadeEmprestimos++;
        return true;
    }

    public void listarEmprestimos() {
        IO.println("Empréstimos de " + nome + ":");
        if (quantidadeEmprestimos == 0) {
            IO.println("  (nenhum)");
            return;
        }
        for (int i = 0; i < quantidadeEmprestimos; i++) {
            IO.println("  - " + emprestimos[i].resumo());
        }
    }
}
