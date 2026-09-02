package br.edu.ifba.vdc.bsi.lp1;

public final class Revista extends ItemAcervo implements Emprestavel {

    private int edicao;
    private boolean disponivel = true;

    public Revista(String codigo, String titulo, int edicao) {
        super(codigo, titulo);
        this.edicao = edicao;
    }

    @Override
    public String resumo() {
        return "[" + getCodigo() + "] Revista: " + getTitulo() + " nº " + edicao
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
        return 7;
    }
}
