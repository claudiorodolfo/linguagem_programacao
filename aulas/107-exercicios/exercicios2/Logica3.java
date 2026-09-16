/*
Q3 — Tabuada
Leia um número inteiro k, entre 1 e 10. Imprima a tabuada de k,
de 1 a 10, no formato k x i = resultado.
*/
/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios2/"
javac Logica3.java -d bin
java -cp bin Logica3
*/


void main() {
    int k = Integer.parseInt(IO.readln("Digite k (1 a 10): "));

    for (int i = 1; i <= 10; i++) {
        IO.println(k + " x " + i + " = " + (k * i));
    }
}