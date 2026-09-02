package br.edu.ifba.vdc.bsi.lp1;

public class Notebook implements Emprestavel {

    private String patrimonio;
    private boolean disponivel = true;

    public Notebook(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    @Override
    public boolean emprestar(String usuario) {
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
    public String toString() {
        return "Notebook " + patrimonio + " (" + status() + ")";
    }
}
