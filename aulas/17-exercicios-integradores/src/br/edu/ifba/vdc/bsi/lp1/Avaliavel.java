package br.edu.ifba.vdc.bsi.lp1;

public interface Avaliavel {

    String nome();

    /** {@code null} se a nota ainda não foi lançada. */
    Integer nota();

    double peso();
}
