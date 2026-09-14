/*
Exercício 15
Melhore o programa do bichinho virtual, permitindo que o usuário 
especifique quanto de comida ele fornece ao bichinho e por quanto tempo 
ele brinca com o bichinho. Faça com que estes valores afetem quão 
rapidamente os níveis de fome e tédio caem.
*/

/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios1/"
javac Exercicio15.java -d bin
java -cp bin Exercicio15
*/
class Bichinho {
    private String nome;
    private int fome;
    private int tedio;

    public Bichinho(String nome) {
        this.nome = nome;
        this.fome = 50;
        this.tedio = 50;
    }

    public void alimentar(int quantidade) {
        if (quantidade > 0) {
            fome -= quantidade;
            fome = Math.max(0, fome);
        }
    }

    public void brincar(int tempo) {
        if (tempo > 0) {
            tedio -= tempo;
            tedio = Math.max(0, tedio);
        }
    }

    public void ouvir() {
        IO.println("Nome: " + nome);
        IO.println("Fome: " + fome);
        IO.println("Tédio: " + tedio);
    }
}

public class Exercicio15 {
    void main() {
        var bichinho = new Bichinho("Totó");

        bichinho.ouvir();

        bichinho.alimentar(20);

        IO.println("\nDepois de alimentar:");

        bichinho.ouvir();

        bichinho.brincar(15);

        IO.println("\nDepois de brincar:");

        bichinho.ouvir();
    }
}