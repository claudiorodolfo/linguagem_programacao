package br.edu.ifba.vdc.bsi.lp1;

public abstract sealed class Forma permits Retangulo, Circulo {

    public abstract double area();

    public abstract double perimetro();

    public abstract String nome();

    @Override
    public String toString() {
        return "%s área=%s perímetro=%s".formatted(nome(), area(), perimetro());
    }
}
