/**
 * Compila e executa, mas a média de 7, 8 e 9 não é 8.0.
 * Laboratório: não reescreva — depure.
 */
public class MediaBugada {

    void main() {
        int[] notas = {7, 8, 9};
        IO.println("Média: " + media(notas));
    }

    static double media(int[] notas) {
        int soma = 0;
        // BUG: começa em 1 (ignora notas[0]) e usa <= (estoura o índice).
        for (int i = 1; i <= notas.length; i++) {
            soma += notas[i];
        }
        // BUG: mesmo que o laço fosse corrigido, int/int perde a fração em outros exemplos.
        return soma / notas.length;
    }
}
