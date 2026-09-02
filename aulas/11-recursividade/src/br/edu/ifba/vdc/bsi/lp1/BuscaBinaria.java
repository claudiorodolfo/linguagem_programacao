package br.edu.ifba.vdc.bsi.lp1;

public class BuscaBinaria {

    public static int buscar(int[] v, int alvo) {
        if (v == null) {
            return -1;
        }
        return buscar(v, alvo, 0, v.length - 1);
    }

    static int buscar(int[] v, int alvo, int inicio, int fim) {
        if (inicio > fim) {
            return -1;
        }
        int meio = inicio + (fim - inicio) / 2;
        if (v[meio] == alvo) {
            return meio;
        }
        if (alvo < v[meio]) {
            return buscar(v, alvo, inicio, meio - 1);
        }
        return buscar(v, alvo, meio + 1, fim);
    }
}
