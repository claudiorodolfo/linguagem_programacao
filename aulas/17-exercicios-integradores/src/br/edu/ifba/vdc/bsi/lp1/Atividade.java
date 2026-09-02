package br.edu.ifba.vdc.bsi.lp1;

public abstract class Atividade implements Avaliavel {

    private final String titulo;
    private final double peso;

    public Atividade(String titulo, double peso) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("título obrigatório");
        }
        if (peso <= 0) {
            throw new IllegalArgumentException("peso deve ser positivo");
        }
        this.titulo = titulo;
        this.peso = peso;
    }

    @Override
    public String nome() {
        return titulo;
    }

    @Override
    public double peso() {
        return peso;
    }
}
