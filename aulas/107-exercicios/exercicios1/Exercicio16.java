/*
Exercício 16
Crie uma "porta escondida" no programa do programa do bichinho virtual que 
mostre os valores exatos dos atributos do objeto. Consiga isto mostrando o 
objeto quando uma opção secreta, não listada no menu, for informada na 
escolha do usuário.
Dica: acrescente um método especial toString() à classe Bichinho.

*/

/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios1/"
javac Exercicio16.java -d bin
java -cp bin Exercicio16
*/
class Bichinho {
    private String nome;
    private int fome;
    private int tedio;

    public Bichinho(String nome, int fome, int tedio) {
        this.nome = nome;
        this.fome = fome;
        this.tedio = tedio;
    }

    public void alimentar(int quantidade) {
        fome = Math.max(0, fome - quantidade);
    }

    public void brincar(int tempo) {
        tedio = Math.max(0, tedio - tempo);
    }

    public void ouvir() {
        IO.println("O bichinho está feliz!");
    }

    @Override
    public String toString() {
        return "Bichinho{" +
                "nome='" + nome + '\'' +
                ", fome=" + fome +
                ", tedio=" + tedio +
                '}';
    }
}

public class Exercicio16 {
    void main() {
        var bichinho = new Bichinho(
                "Totó",
                30,
                70
        );

        int opcao;

        do {
            IO.println("");
            IO.println("=== MENU ===");
            IO.println("1 - Alimentar");
            IO.println("2 - Brincar");
            IO.println("3 - Ouvir");
            IO.println("0 - Sair");

            opcao = Integer.parseInt(IO.readln("Opção: "));

            switch (opcao) {
                case 0 -> IO.println("Encerrando...");
                case 1 -> {
                    var quantidade = Integer.parseInt(IO.readln("Quantidade de comida: "));
                    bichinho.alimentar(quantidade);
                }
                case 2 -> {
                    var tempo = Integer.parseInt(IO.readln("Tempo de brincadeira: "));
                    bichinho.brincar(tempo);
                }
                case 3 -> bichinho.ouvir();
                case 42 -> IO.println(bichinho);
                default -> IO.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}