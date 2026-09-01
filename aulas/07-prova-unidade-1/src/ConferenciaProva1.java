/**
 * Material de conferência do docente (não distribuir na prova).
 */
public class ConferenciaProva1 {

    void main() {
        int[] v = {1, 2, 3, 4, 5};
        IO.println("pares = " + contarPares(v));
        IO.println("total após 2 contas: conferir no papel (esperado 2)");
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
