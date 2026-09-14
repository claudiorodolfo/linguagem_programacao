/*
Q7 — Inverter Vetor
Leia 6 números inteiros para um vetor. Depois, inverta o vetor
no próprio arranjo, sem criar um segundo vetor, e imprima o resultado.
*/

void main() {
    int[] numeros = new int[6];

    for (int i = 0; i < numeros.length; i++) {
        numeros[i] = Integer.parseInt(
            IO.readln("Número " + i + ": ")
        );
    }

    for (int inicio = 0, fim = numeros.length - 1;
         inicio < fim;
         inicio++, fim--) {

        int temp = numeros[inicio];
        numeros[inicio] = numeros[fim];
        numeros[fim] = temp;
    }

    for (int numero : numeros) {
        IO.println(numero);
    }
}