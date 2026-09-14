/*
Exercício 01
Crie uma classe que modele uma bola:
Atributos: cor, circunferência, material
Métodos: para troca cor e para mostra cor
*/

/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios1/"
javac Exercicio01.java -d bin
java -cp bin Exercicio01
*/
class Bola {
    private String cor;
    private double circunferencia;
    private String material;

    public Bola(String cor, double circunferencia, String material) {
        this.cor = cor;
        this.circunferencia = circunferencia;
        this.material = material;
    }

    public void trocarCor(String novaCor) {
        cor = novaCor;
    }

    public void mostrarCor() {
        IO.println("Cor: " + cor);
    }
}

public class Exercicio01 {
    void main() {
        var bola = new Bola(
            "Azul", 
            70.0, 
            "Borracha"
        );
        bola.mostrarCor();
        bola.trocarCor("Vermelha");
        bola.mostrarCor();
    }
}