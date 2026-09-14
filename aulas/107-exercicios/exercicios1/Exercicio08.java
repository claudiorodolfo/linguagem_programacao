/*
Exercício 08
Desenvolva uma classe Macaco, que possua os atributos nome e 
bucho (estomago) e pelo menos os métodos comer(), verBucho() e digerir().
Faça um programa ou teste interativamente, criando pelo menos dois macacos, 
alimentando-os com pelo menos 3 alimentos diferentes e verificando o 
conteúdo do estômago a cada refeição. Experimente fazer com que um macaco 
coma o outro. É possível criar um macaco canibal?
*/

/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios1/"
javac Exercicio08.java -d bin
java -cp bin Exercicio08
*/
class Macaco {
    private String nome;
    private String[] bucho;
    private int quantidade;

    public Macaco(String nome) {
        bucho = new String[10];
        quantidade = 0;
        this.nome = nome;
    }

    public void comer(String alimento) {
        bucho[quantidade++] = alimento;
    }

    public void comer(Macaco outroMacaco) {
        bucho[quantidade++] = "Macaco " + outroMacaco.nome;
    }

    public void verBucho() {
        if (quantidade == 0) {
            IO.println(nome + " está com o bucho vazio.");
            return;
        }

        IO.print("Bucho de " + nome + ": ");
        for (var i = 0; i < quantidade; i++) {
            if (i > 0)  
                IO.print(", ");
            IO.print(bucho[i]);
        }
        IO.println("");
    }

    public void digerir() {
        bucho = new String[10];
        quantidade =0;
        IO.println(nome + " digeriu a comida.");
    }
}

public class Exercicio08 {
    void main() {
        var macaco1 = new Macaco("Chico");
        var macaco2 = new Macaco("Joca");

        macaco1.comer("Banana");
        macaco1.verBucho();

        macaco1.comer("Maçã");
        macaco1.verBucho();

        macaco1.comer("Melancia");
        macaco1.verBucho();

        macaco2.comer("Banana");
        macaco2.comer("Manga");
        macaco2.verBucho();

        IO.println("\nMacaco canibal:");

        macaco1.comer(macaco2);
        macaco1.verBucho();
    }
}