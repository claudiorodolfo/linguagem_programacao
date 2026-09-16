/*
Q4 — Busca Linear
Leia 8 números inteiros para um vetor. Depois, leia um valor x.
Informe a primeira posição em que x aparece, considerando índice
inicial 0, ou uma mensagem informando que o valor não foi encontrado.
*/
/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios2/"
javac Logica4.java -d bin
java -cp bin Logica4
*/


void main() {
    int[] numeros = new int[8];

    for (int i = 0; i < numeros.length; i++) {
        numeros[i] = Integer.parseInt(
            IO.readln("Número " + i + ": ")
        );
    }

    int x = Integer.parseInt(IO.readln("Valor a buscar: "));
    int posicao = -1;

    for (int i = 0; i < numeros.length; i++) {
        if (numeros[i] == x) {
            posicao = i;
            break;
        }
    }

    if (posicao >= 0) {
        IO.println("Encontrado na posição " + posicao);
    } else {
        IO.println("Valor não encontrado");
    }
}