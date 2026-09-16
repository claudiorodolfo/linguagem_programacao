/*
Q5 — Classe Lampada
Crie a classe Lampada com o atributo boolean ligada.
Implemente ligar(), desligar() e estaLigada(). Não use construtor:
instancie com new Lampada() e manipule o estado por meio dos métodos.
No void main(), ligue, imprima, desligue e imprima novamente.
*/
/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios2/"
javac Classes5.java -d bin
java -cp bin Classes5
*/


class Lampada {
    boolean ligada;

    void ligar() {
        ligada = true;
    }

    void desligar() {
        ligada = false;
    }

    boolean estaLigada() {
        return ligada;
    }
}

void main() {
    Lampada lampada = new Lampada();

    lampada.ligar();
    IO.println(lampada.estaLigada());

    lampada.desligar();
    IO.println(lampada.estaLigada());
}
