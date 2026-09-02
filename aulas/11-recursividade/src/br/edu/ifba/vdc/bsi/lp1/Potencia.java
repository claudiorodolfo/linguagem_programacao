package br.edu.ifba.vdc.bsi.lp1;

public class Potencia {

    public static long linear(int base, int exp) {
        if (exp < 0) {
            throw new IllegalArgumentException("exp >= 0 neste exemplo");
        }
        if (exp == 0) {
            return 1;
        }
        return base * linear(base, exp - 1);
    }

    public static long logaritmica(int base, int exp) {
        if (exp < 0) {
            throw new IllegalArgumentException("exp >= 0 neste exemplo");
        }
        if (exp == 0) {
            return 1;
        }
        if (exp % 2 == 0) {
            long metade = logaritmica(base, exp / 2);
            return metade * metade;
        }
        return base * logaritmica(base, exp - 1);
    }
}
