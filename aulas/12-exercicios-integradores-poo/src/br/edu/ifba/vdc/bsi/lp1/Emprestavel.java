package br.edu.ifba.vdc.bsi.lp1;

public interface Emprestavel {

    boolean emprestar(String matriculaUsuario);

    void devolver();

    boolean isDisponivel();

    int prazoDias();
}
