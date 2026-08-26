/**
 * Material de conferência do docente (não distribuir na prova).
 * Rastreio da questão 6: s(5) deve imprimir 9.
 */
public class ConferenciaProva1 {

    void main() {
        IO.println("s(5) = " + s(5));
        IO.println("somaDigitos(172) = " + somaDigitos(172));
        int[] v = {1, 2, 3, 4, 5};
        IO.println("pares = " + contarPares(v));
    }

    static int s(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + s(n - 2);
    }

    static int somaDigitos(int n) {
        if (n < 10) {
            return n;
        }
        return (n % 10) + somaDigitos(n / 10);
    }

    static int contarPares(int[] v) {
        int q = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] % 2 == 0) {
                q++;
            }
        }
        return q;
    }
}
