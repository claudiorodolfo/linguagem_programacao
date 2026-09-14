/*
Q9 — Questão Integradora
O método abaixo deveria devolver a quantidade de pares no vetor.
Encontre os defeitos e reescreva-o corretamente.

static int contarPares(int[] v) {
    int q = 0;
    for (int i = 0; i <= v.length; i++) {
        if (v[i] % 2 == 1) {
            q++;
        }
    }
    return q;
}
*/

int contarPares(int[] v) {
    int q = 0;

    for (int i = 0; i < v.length; i++) {
        if (v[i] % 2 == 0) {
            q++;
        }
    }

    return q;
}