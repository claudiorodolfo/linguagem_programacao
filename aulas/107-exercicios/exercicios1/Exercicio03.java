/*
Exercício 03
Crie uma classe que modele um retângulo:
Atributos: LadoA, LadoB (ou Comprimento e Largura, ou Base e Altura, a escolher)
Métodos: Mudar valor dos lados, Retornar valor dos lados, calcular Área e calcular Perímetro;
Crie um programa que utilize esta classe. Ele deve pedir ao usuário que informe as medidas de um local. 
Depois, deve-se criar um objeto com as medidas e calcular a quantidade de pisos e de rodapés necessárias para o local.
*/

/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios1/"
javac Exercicio03.java -d bin
java -cp bin Exercicio03
*/
class Retangulo {
    private double comprimento;
    private double largura;

    public Retangulo(double comprimento, double largura) {
        this.comprimento = comprimento;
        this.largura = largura;
    }

    public void mudarLados(double comprimento, double largura) {
        this.comprimento = comprimento;
        this.largura = largura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public double getLargura() {
        return largura;
    }

    public double calcularArea() {
        return comprimento * largura;
    }

    public double calcularPerimetro() {
        return 2 * (comprimento + largura);
    }
}

public class Exercicio03 {
    void main() {
        var comprimento = Double.parseDouble(IO.readln("Comprimento do local (m): "));
        var largura = Double.parseDouble(IO.readln("Largura do local (m): "));

        var local = new Retangulo(comprimento, largura);

        IO.println("Área do local: " + local.calcularArea() + " m²");
        IO.println("Perímetro: " + local.calcularPerimetro() + " m");

        var comprimentoPiso = Double.parseDouble(IO.readln("Comprimento do piso (m): "));
        var larguraPiso = Double.parseDouble(IO.readln("Largura do piso (m): "));

        var areaPiso = comprimentoPiso * larguraPiso;
        var quantidadePisos = (int) Math.ceil(local.calcularArea() / areaPiso);

        IO.println("Quantidade de pisos: " + quantidadePisos);

        var comprimentoRodape = Double.parseDouble(IO.readln("Comprimento da peça de rodapé (m): "));
        var quantidadeRodapes = (int) Math.ceil(local.calcularPerimetro() / comprimentoRodape);

        IO.println("Quantidade de peças de rodapé: " + quantidadeRodapes);
    }
}