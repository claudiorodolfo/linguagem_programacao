/*
Q4 — Pacote
Mova Retangulo para br.edu.ifba.conquista.lp1.exercicio.modelo e o
programa principal para br.edu.ifba.conquista.lp1.exercicio.app.
Compile com -d bin e execute pelo nome qualificado.
*/

package br.edu.ifba.conquista.lp1.exercicio.modelo;

public class Retangulo {
    private double base;
    private double altura;

    public Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double area() {
        return base * altura;
    }
}
