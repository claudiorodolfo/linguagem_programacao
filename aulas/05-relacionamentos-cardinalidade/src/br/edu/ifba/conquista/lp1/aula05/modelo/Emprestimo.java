package br.edu.ifba.conquista.lp1.aula05.modelo;

/**
 * Classe associativa: relaciona Usuario e Livro (N–N na prática).
 */
public class Emprestimo {

    private Usuario usuario;
    private Livro livro;
    private String data; // String didática; em sistema real, LocalDate

    public Emprestimo(Usuario usuario, Livro livro, String data) {
        this.usuario = usuario;
        this.livro = livro;
        this.data = data;
    }

    /**
     * Tenta emprestar o livro e registrar o vínculo no usuário.
     * A regra de negócio permanece no Livro, não neste método "orquestrador".
     */
    public boolean efetivar() {
        if (!livro.emprestar()) {
            return false;
        }
        return usuario.registrar(this);
    }

    public String resumo() {
        return livro.getTitulo() + " em " + data;
    }
}
