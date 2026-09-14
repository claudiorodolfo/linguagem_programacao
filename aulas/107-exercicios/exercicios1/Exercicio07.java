/*
Exercício 07
Crie uma classe que modele um Tamagushi (Bichinho Eletrônico):
Atributos: Nome, Fome, Saúde e Idade.
Métodos: Alterar Nome, Fome, Saúde e Idade; Retornar Nome, Fome, Saúde e Idade
Obs: Existe mais uma informação que devemos levar em consideração, 
o Humor do nosso tamagushi, este humor é uma combinação entre os atributos 
Fome e Saúde, ou seja, um campo calculado, então não devemos criar 
um atributo para armazenar esta informação por que ela pode ser calculada 
a qualquer momento.
*/

/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios1/"
javac Exercicio07.java -d bin
java -cp bin Exercicio07
*/
class Tamagushi {
    private String nome;
    private int fome;
    private int saude;
    private int idade;

    public Tamagushi(
            String nome,
            int fome,
            int saude,
            int idade) {

        this.nome = nome;
        this.fome = fome;
        this.saude = saude;
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFome(int fome) {
        this.fome = limitar(fome);
    }

    public void setSaude(int saude) {
        this.saude = limitar(saude);
    }

    public void setIdade(int idade) {
        if (idade >= 0) {
            this.idade = idade;
        }
    }

    public String getNome() {
        return nome;
    }

    public int getFome() {
        return fome;
    }

    public int getSaude() {
        return saude;
    }

    public int getIdade() {
        return idade;
    }

    public int calcularHumor() {
        return (fome + saude) / 2;
    }

    private int limitar(int valor) {
        return Math.max(0, Math.min(100, valor));
    }
}

public class Exercicio07 {
    void main() {
        var bichinho = new Tamagushi(
                "Tamagushi",
                80,
                90,
                2
        );

        IO.println("Nome: " + bichinho.getNome());
        IO.println("Fome: " + bichinho.getFome());
        IO.println("Saúde: " + bichinho.getSaude());
        IO.println("Idade: " + bichinho.getIdade());
        IO.println("Humor: " + bichinho.calcularHumor());
    }
}