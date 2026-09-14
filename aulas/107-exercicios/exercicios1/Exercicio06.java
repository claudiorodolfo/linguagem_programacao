/*
Exercício 06
Faça um programa que simule um televisor criando-o como um objeto. 
O usuário deve ser capaz de informar o número do canal e 
aumentar ou diminuir o volume. Certifique-se de que o número do canal e 
o nível do volume permanecem dentro de faixas válidas.
*/

/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios1/"
javac Exercicio06.java -d bin
java -cp bin Exercicio06
*/

class Televisor {
    private int canal;
    private int volume;

    public Televisor() {
        canal = 1;
        volume = 10;
    }

    public void alterarCanal(int canal) {
        if (canal >= 1 && canal <= 999) {
            this.canal = canal;
        }
    }

    public void aumentarVolume() {
        if (volume < 100) {
            volume++;
        }
    }

    public void diminuirVolume() {
        if (volume > 0) {
            volume--;
        }
    }

    public int getCanal() {
        return canal;
    }

    public int getVolume() {
        return volume;
    }
}

public class Exercicio06 {
    void main() {
        var tv = new Televisor();

        tv.alterarCanal(42);

        for (int i = 0; i < 5; i++) {
            tv.aumentarVolume();
        }

        IO.println("Canal: " + tv.getCanal());
        IO.println("Volume: " + tv.getVolume());
    }
}