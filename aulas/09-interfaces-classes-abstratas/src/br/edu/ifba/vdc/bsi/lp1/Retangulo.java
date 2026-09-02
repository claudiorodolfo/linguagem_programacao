package br.edu.ifba.vdc.bsi.lp1;

public non-sealed class Retangulo extends Forma {

    private double base;
    private double altura;

    public Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double area() {
        return base * altura;
    }

    @Override
    public double perimetro() {
        return 2 * (base + altura);
    }

    @Override
    public String nome() {
        return "Retângulo";
    }
}
