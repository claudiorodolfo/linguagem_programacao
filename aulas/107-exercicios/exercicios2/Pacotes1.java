/*
Q1 — Encapsular Retangulo
Pegue o Retangulo da aula de atributos, construtores e métodos. Torne
os atributos private. O construtor deve rejeitar base ou altura ≤ 0:
informe o erro e use 1.0 como fallback, ou recuse criar. Documente a
escolha. Não crie setBase que aceite negativo.
*/

class Retangulo {
    private double base;
    private double altura;

    // Escolha: informar o erro e cair para 1.0.
    // Assim o objeto sempre nasce válido (invariante: base > 0 e
    // altura > 0) sem exigir try/catch no main nesta etapa.
    // Recusar com IllegalArgumentException também seria correto.
    Retangulo(double base, double altura) {
        if (base <= 0) {
            IO.println("base inválida (" + base + ") — usando 1.0");
            base = 1.0;
        }
        if (altura <= 0) {
            IO.println("altura inválida (" + altura + ") — usando 1.0");
            altura = 1.0;
        }
        this.base = base;
        this.altura = altura;
    }

    double getBase() {
        return base;
    }

    double getAltura() {
        return altura;
    }

    // Não há atribuição cega: valor ≤ 0 é recusado e o estado fica.
    void setBase(double base) {
        if (base <= 0) {
            IO.println("setBase recusado: base deve ser > 0");
            return;
        }
        this.base = base;
    }

    void setAltura(double altura) {
        if (altura <= 0) {
            IO.println("setAltura recusado: altura deve ser > 0");
            return;
        }
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
    var invalido = new Retangulo(-3.0, 0.0);

    IO.println("Sala | base: " + sala.getBase()
            + " | altura: " + sala.getAltura()
            + " | área: " + sala.area());

    IO.println("Inválido | base: " + invalido.getBase()
            + " | altura: " + invalido.getAltura()
            + " | área: " + invalido.area());

    sala.setBase(-10);
    IO.println("Após setBase(-10): " + sala.getBase());
}
