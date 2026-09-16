/*
Q7 — Questão Integradora
Considere:
class Ponto {
    int x;
    int y;
}

void main() {
    Ponto a = new Ponto();
    a.x = 1;
    a.y = 2;
    Ponto b = a;
    Ponto c = new Ponto();
    c.x = 1;
    c.y = 2;
    b.x = 9;
}

Quais os valores de a.x, b.x e c.x? Justifique com as palavras
objeto e referência.
O que imprime a == b? E a == c?
c) Por que a e c podem ter o mesmo estado e mesmo assim a == c ser false?
*/
/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios2/"
javac Classes7.java -d bin
java -cp bin Classes7
*/


class Ponto {
    int x;
    int y;
}

void main() {
    Ponto a = new Ponto();
    a.x = 1;
    a.y = 2;
    Ponto b = a;
    Ponto c = new Ponto();
    c.x = 1;
    c.y = 2;
    b.x = 9;

    // a.x = 9, b.x = 9, c.x = 1
    // a e b são referências para o MESMO objeto; b.x = 9 altera esse objeto.
    // c é referência para OUTRO objeto, que continua com x = 1.

    // a == b imprime true (mesma referência / mesmo objeto).
    // a == c imprime false (objetos diferentes).

    // Mesmo estado não é a mesma identidade: a e c podem ter x e y iguais
    // e ainda assim serem dois objetos. == compara referência, não campos.

    IO.println(a.x);
    IO.println(b.x);
    IO.println(c.x);
    IO.println(a == b);
    IO.println(a == c);
}
