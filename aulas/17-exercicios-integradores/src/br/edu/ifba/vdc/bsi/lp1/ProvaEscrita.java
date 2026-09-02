package br.edu.ifba.vdc.bsi.lp1;

public class ProvaEscrita extends Atividade {

    private Integer notaLancada;

    public ProvaEscrita(String titulo, double peso) {
        super(titulo, peso);
        this.notaLancada = null;
    }

    public void lancar(int nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("nota de 0 a 10");
        }
        this.notaLancada = Integer.valueOf(nota);
    }

    @Override
    public Integer nota() {
        return notaLancada;
    }
}
