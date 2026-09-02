package br.edu.ifba.vdc.bsi.lp1;

/**
 * Modelo simplificado de livro da biblioteca do campus.
 * Sem construtor declarado (o padrão entra em cena) e sem private —
 * construtores na aula de atributos, construtores e métodos, encapsulamento na aula de encapsulamento e pacotes.
 */
public class Livro {

    String titulo;
    String autor;
    boolean emprestado;

    public void emprestar() {
        if (emprestado) {
            IO.println("O livro \"" + titulo + "\" já está emprestado.");
            return;
        }
        emprestado = true;
    }

    public void devolver() {
        emprestado = false;
    }

    public String descricao() {
        String status = emprestado ? "emprestado" : "disponível";
        return titulo + " (" + autor + ") — " + status;
    }
}
