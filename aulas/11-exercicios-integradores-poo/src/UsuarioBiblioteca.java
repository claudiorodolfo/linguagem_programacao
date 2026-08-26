public class UsuarioBiblioteca {

    private String nome;
    private String matricula;
    private int limite;
    private int quantidadeAtual;

    public UsuarioBiblioteca(String nome, String matricula, int limite) {
        this.nome = nome;
        this.matricula = matricula;
        this.limite = limite;
        this.quantidadeAtual = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public boolean podeEmprestarMais() {
        return quantidadeAtual < limite;
    }

    public void registrarEmprestimo() {
        quantidadeAtual++;
    }

    public void registrarDevolucao() {
        if (quantidadeAtual > 0) {
            quantidadeAtual--;
        }
    }

    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }
}
