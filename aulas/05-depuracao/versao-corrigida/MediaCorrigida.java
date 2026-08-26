/** Versão corrigida para o fechamento da aula. Não mostre antes do laboratório. */
public class MediaCorrigida {

    void main() {
        int[] notas = {7, 8, 9};
        IO.println("Média: " + media(notas));
    }

    static double media(int[] notas) {
        int soma = 0;
        for (int i = 0; i < notas.length; i++) {
            soma += notas[i];
        }
        return soma / (double) notas.length;
    }
}
