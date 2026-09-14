/*
Exercício 17
Crie uma fazenda de bichinhos instanciando vários objetos do tipo bichinho 
e mantendo o controle deles através de uma lista. Imite o funcionamento do 
programa básico, mas ao invés de exigir que o usuário tome conta de um único 
bichinho, exija que ele tome conta da fazenda inteira. Cada opção do menu 
deveria permitir que o usuário executasse uma ação para todos os bichinhos 
(alimentar todos os bichinhos, brincar com todos os bichinhos, ou ouvir a 
todos os bichinhos).
Para tornar o programa mais interessante, dê para cada bichinho um nível 
inicial aleatório de fome e tédio.
*/

/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios1/"
javac Exercicio17.java -d bin
java -cp bin Exercicio17
*/
class Bichinho {
    private final String nome;
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
        IO.println(
                nome +
                " | fome: " + fome +
                " | tédio: " + tedio
        );
    }
}

class Fazenda {
    private final Bichinho[] bichinhos;
    private int quantidade;

    public Fazenda(int capacidade) {
        bichinhos = new Bichinho[capacidade];
        quantidade = 0;
    }

    public void adicionar(Bichinho bichinho) {
        bichinhos[quantidade++] = bichinho;
    }

    public void alimentarTodos(int comida) {
        for (var i = 0; i < quantidade; i++) {
            bichinhos[i].alimentar(comida);
        }
    }

    public void brincarComTodos(int tempo) {
        for (var i = 0; i < quantidade; i++) {
            bichinhos[i].brincar(tempo);
        }
    }

    public void ouvirTodos() {
        for (var i = 0; i < quantidade; i++) {
            bichinhos[i].ouvir();
        }
    }
}

public class Exercicio17 {
    void main() {
        var fazenda = new Fazenda(3);

        fazenda.adicionar(new Bichinho("Totó", sortear(), sortear()));
        fazenda.adicionar(new Bichinho("Mimi", sortear(), sortear()));
        fazenda.adicionar(new Bichinho("Rex", sortear(), sortear()));

        int opcao;

        do {
            IO.println("");
            IO.println("=== FAZENDA ===");
            IO.println("1 - Alimentar todos");
            IO.println("2 - Brincar com todos");
            IO.println("3 - Ouvir todos");
            IO.println("0 - Sair");

            opcao = Integer.parseInt(IO.readln("Opção: "));

            switch (opcao) {
                case 1 -> {
                    var comida = Integer.parseInt(IO.readln("Quantidade de comida: "));
                    fazenda.alimentarTodos(comida);
                }
                case 2 -> {
                    var tempo = Integer.parseInt(IO.readln("Tempo de brincadeira: "));
                    fazenda.brincarComTodos(tempo);
                }
                case 3 -> fazenda.ouvirTodos();
                case 0 -> IO.println("Encerrando...");
                default -> IO.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    static int sortear() {
        return (int) (Math.random() * 101);
    }
}
