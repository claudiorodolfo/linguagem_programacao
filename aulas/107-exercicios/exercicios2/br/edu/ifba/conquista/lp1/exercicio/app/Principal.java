package br.edu.ifba.conquista.lp1.exercicio.app;

import br.edu.ifba.conquista.lp1.exercicio.modelo.Retangulo;

public class Principal {

    void main() {
        var sala = new Retangulo(8.0, 5.0);
        IO.println("área: " + sala.area());
    }
}
