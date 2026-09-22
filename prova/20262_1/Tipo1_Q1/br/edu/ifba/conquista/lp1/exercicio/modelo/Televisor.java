package br.edu.ifba.conquista.lp1.exercicio.modelo;

public class Televisor {

    private int canal;
    private int volume;

    public Televisor() {
        this(1, 0);
    }

    public Televisor(int canal, int volume) {
        if (canal < 1 || canal > 999) {
            throw new IllegalArgumentException(
                "O canal deve estar entre 1 e 999."
            );
        }

        if (volume < 0 || volume > 99) {
            throw new IllegalArgumentException(
                "O volume deve estar entre 0 e 99."
            );
        }

        this.canal = canal;
        this.volume = volume;
    }

    public void alterarCanal(int canal) {
        if (canal < 1 || canal > 999) {
            throw new IllegalArgumentException(
                "O canal deve estar entre 1 e 999."
            );
        }

        this.canal = canal;
    }

    public void aumentarVolume() {
        if (volume < 99) {
            volume++;
        }
    }

    public void diminuirVolume() {
        if (volume > 0) {
            volume--;
        }
    }

    public int consultarCanal() {
        return canal;
    }

    public int consultarVolume() {
        return volume;
    }
}