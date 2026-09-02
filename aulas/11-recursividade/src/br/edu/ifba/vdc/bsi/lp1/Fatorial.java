package br.edu.ifba.vdc.bsi.lp1;

public class Fatorial {

    public static long calcular(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n deve ser >= 0");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * calcular(n - 1);
    }
}
