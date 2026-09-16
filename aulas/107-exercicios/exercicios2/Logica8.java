/*
Q8 — Primos até n
Leia n, sendo n ≥ 2, e imprima todos os números primos de 2 até n.
Extraia a verificação para o método boolean ehPrimo(int n).
*/
/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios2/"
javac Logica8.java -d bin
java -cp bin Logica8
*/


boolean ehPrimo(int n) {
    if (n < 2) {
        return false;
    }

    for (int divisor = 2; divisor < n; divisor++) {
        if (n % divisor == 0) {
            return false;
        }
    }

    return true;
}

void main() {
    int n = Integer.parseInt(IO.readln("Digite n: "));

    for (int i = 2; i <= n; i++) {
        if (ehPrimo(i)) {
            IO.println(i);
        }
    }
}