/*
Exercício 09
Faça um programa completo utilizando funções e classes que:
Possua uma classe chamada Ponto, com os atributos x e y.
Possua uma classe chamada Retangulo, com os atributos largura e altura.
Possua uma função para imprimir os valores da classe Ponto
Possua uma função para encontrar o centro de um Retângulo.
Você deve criar alguns objetos da classe Retangulo.
Cada objeto deve ter um vértice de partida, por exemplo, o vértice inferior esquerdo do retângulo, que deve ser um objeto da classe Ponto.
A função para encontrar o centro do retângulo deve retornar o valor para um objeto do tipo ponto que indique os valores de x e y para o centro do objeto.
O valor do centro do objeto deve ser mostrado na tela
Crie um menu para alterar os valores do retângulo e imprimir o centro deste retângulo.

*/

/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios1/"
javac Exercicio09.java -d bin
java -cp bin Exercicio09
*/
class Ponto {
    private double x;
    private double y;

    public Ponto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}

class Retangulo {
    private double largura;
    private double altura;
    private Ponto verticeInicial;

    public Retangulo(
            double largura,
            double altura,
            Ponto verticeInicial) {

        this.largura = largura;
        this.altura = altura;
        this.verticeInicial = verticeInicial;
    }

    public void alterarValores(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public Ponto encontrarCentro() {
        var centroX = verticeInicial.getX() + largura / 2;
        var centroY = verticeInicial.getY() + altura / 2;

        return new Ponto(centroX, centroY);
    }
}

public class Exercicio09 {
    static void imprimirPonto(Ponto ponto) {
        IO.println(
                "X = " + ponto.getX()
                + ", Y = " + ponto.getY()
        );
    }

    void main() {
        var retangulo = new Retangulo(
                10,
                6,
                new Ponto(2, 3)
        );

        int opcao;

        do {
            IO.println("");
            IO.println("=== MENU ===");
            IO.println("1 - Alterar retângulo");
            IO.println("2 - Imprimir centro");
            IO.println("0 - Sair");

            opcao = Integer.parseInt(IO.readln("Opção: "));

            switch (opcao) {
                case 1 -> {
                    var largura = Double.parseDouble(IO.readln("Nova largura: "));
                    var altura = Double.parseDouble(IO.readln("Nova altura: "));
                    retangulo.alterarValores(largura, altura);
                }

                case 2 -> {
                    var centro = retangulo.encontrarCentro();
                    IO.print("Centro: ");
                    imprimirPonto(centro);
                }

                case 0 -> IO.println("Encerrando...");

                default -> IO.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}