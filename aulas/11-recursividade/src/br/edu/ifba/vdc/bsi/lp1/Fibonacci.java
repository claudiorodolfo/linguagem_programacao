package br.edu.ifba.vdc.bsi.lp1;

public class Fibonacci {

    /** Recursão ingênua: exponencial. Bom para n pequeno e para o depurador. */
    public static long ingenuo(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n >= 0");
        }
        if (n <= 1) {
            return n;
        }
        return ingenuo(n - 1) + ingenuo(n - 2);
    }

    /** Iterativo linear — o que você usaria de verdade. */
    public static long iterativo(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n >= 0");
        }
        if (n <= 1) {
            return n;
        }
        long a = 0;
        long b = 1;
        for (int i = 2; i <= n; i++) {
            long proximo = a + b;
            a = b;
            b = proximo;
        }
        return b;
    }
}
