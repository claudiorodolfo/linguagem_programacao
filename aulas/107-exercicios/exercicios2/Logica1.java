/*
Q1 — Par ou Ímpar
Leia um número inteiro e informe se ele é par ou ímpar.
Requisito: utilize o operador %.
*/
/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios2/"
javac Logica1.java -d bin
java -cp bin Logica1
*/


void main() {
    int numero = Integer.parseInt(IO.readln("Digite um número: "));

    if (numero % 2 == 0) {
        IO.println("Par");
    } else {
        IO.println("Ímpar");
    }
}