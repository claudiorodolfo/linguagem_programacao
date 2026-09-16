/*
Q2 — Média da Turma
Leia a quantidade n de estudantes (n > 0). Em seguida, leia n notas
do tipo double. Ao final, informe a média da turma e quantos
estudantes obtiveram nota maior ou igual a 7.0.
*/
/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios2/"
javac Logica2.java -d bin
java -cp bin Logica2
*/


void main() {
    int n = Integer.parseInt(IO.readln("Quantidade de estudantes: "));

    double soma = 0;
    int aprovados = 0;

    for (int i = 0; i < n; i++) {
        double nota = Double.parseDouble(
            IO.readln("Nota do estudante " + (i + 1) + ": ")
        );

        soma += nota;

        if (nota >= 7.0) {
            aprovados++;
        }
    }

    double media = soma / n;

    IO.println("Média da turma: " + media);
    IO.println("Estudantes com nota >= 7: " + aprovados);
}