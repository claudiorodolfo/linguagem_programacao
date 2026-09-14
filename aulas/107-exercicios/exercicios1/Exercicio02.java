/*
Exercício 02
Crie uma classe que modele um quadrado:
Atributos: Tamanho do lado
Métodos: Mudar valor do Lado, Retornar valor do Lado e calcular Área;
*/

/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios1/"
javac Exercicio02.java -d bin
java -cp bin Exercicio02
*/

class Quadrado {
    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    public void mudarValorLado(double lado) {
        this.lado = lado;
    }

    public double retornarValorLado() {
        return lado;
    }

    public double calcularArea() {
        return lado * lado;
    }
}

public class Exercicio02 {
    void main() {
        var quadrado = new Quadrado(5);

        IO.println("Lado: " + quadrado.retornarValorLado());
        IO.println("Área: " + quadrado.calcularArea());

        quadrado.mudarValorLado(10);

        IO.println("Novo lado: " + quadrado.retornarValorLado());
        IO.println("Nova área: " + quadrado.calcularArea());
    }
}