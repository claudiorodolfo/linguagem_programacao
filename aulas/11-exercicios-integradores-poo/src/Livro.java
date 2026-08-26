public final class Livro extends ItemAcervo implements Emprestavel {

    private String autor;
    private boolean disponivel = true;

    public Livro(String codigo, String titulo, String autor) {
        super(codigo, titulo);
        this.autor = autor;
    }

    @Override
    public String resumo() {
        return "[" + getCodigo() + "] Livro: " + getTitulo() + " — " + autor
                + (disponivel ? " (livre)" : " (emprestado)");
    }

    @Override
    public boolean emprestar(String matriculaUsuario) {
        if (!disponivel) {
            return false;
        }
        disponivel = false;
        return true;
    }

    @Override
    public void devolver() {
        disponivel = true;
    }

    @Override
    public boolean isDisponivel() {
        return disponivel;
    }

    @Override
    public int prazoDias() {
        return 14;
    }
}
