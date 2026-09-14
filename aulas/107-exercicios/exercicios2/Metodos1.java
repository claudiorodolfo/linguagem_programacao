/*
Q1 — Classe Retangulo
Crie a classe Retangulo com double base e double altura. Crie um
construtor com os dois valores. Implemente area(), perimetro() e
ehQuadrado(). Teste dois retângulos no void main().
*/

class Retangulo {
    double base;
    double altura;

    Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    double area() {
        return base * altura;
    }

    double perimetro() {
        return 2 * (base + altura);
    }

    boolean ehQuadrado() {
        return base == altura;
    }
}

void main() {
    var sala = new Retangulo(8.0, 5.0);
    var piso = new Retangulo(4.0, 4.0);

    IO.println("Sala | área: " + sala.area()
            + " | perímetro: " + sala.perimetro()
            + " | quadrado: " + sala.ehQuadrado());

    IO.println("Piso | área: " + piso.area()
            + " | perímetro: " + piso.perimetro()
            + " | quadrado: " + piso.ehQuadrado());
}
