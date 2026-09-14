/*
Q5 — Métodos
Implemente e teste, no void main(), os seguintes métodos:
int maximo(int a, int b, int c)
boolean ehBissexto(int ano)
ehBissexto: divisível por 400, ou divisível por 4 e não por 100.
String conceito(double media)
conceito: A (≥ 9), B (≥ 7), C (≥ 5), D (demais).
Recomendação: utilize uma expressão switch para conceito.
*/

int maximo(int a, int b, int c) {
    int maior = a;

    if (b > maior) {
        maior = b;
    }

    if (c > maior) {
        maior = c;
    }

    return maior;
}

boolean ehBissexto(int ano) {
    return ano % 400 == 0 ||
           (ano % 4 == 0 && ano % 100 != 0);
}

String conceito(double media) {
    return switch ((int) media) {
        case 9, 10 -> "A";
        case 7, 8 -> "B";
        case 5, 6 -> "C";
        default -> "D";
    };
}

void main() {
    IO.println(maximo(10, 25, 7));

    IO.println(ehBissexto(2024));
    IO.println(ehBissexto(2023));

    IO.println(conceito(9.5));
    IO.println(conceito(7.8));
    IO.println(conceito(6.0));
    IO.println(conceito(4.5));
}