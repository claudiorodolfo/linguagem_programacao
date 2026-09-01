# Gabarito — Revisão de lógica

Uso docente. Não publique antes do laboratório.

## Q1

```java
int n = Integer.parseInt(IO.readln("n: ").strip());
if (n % 2 == 0) {
    IO.println("Par");
} else {
    IO.println("Ímpar");
}
```

## Q2

Acumule `soma` e `acima`. Cuidado com `n == 0` (peça n > 0). Média = `soma / n` com `n` promovido a `double`.

```java
double soma = 0;
int acima = 0;
for (int i = 0; i < n; i++) {
    double nota = Double.parseDouble(IO.readln("nota: ").strip());
    soma += nota;
    if (nota >= 7.0) {
        acima++;
    }
}
IO.println("Média: " + (soma / n));
IO.println("Acima ou igual a 7: " + acima);
```

## Q3

```java
for (int i = 1; i <= 10; i++) {
    IO.println("%d x %d = %d".formatted(k, i, k * i));
}
```

## Q4

```java
int pos = -1;
for (int i = 0; i < vetor.length; i++) {
    if (vetor[i] == x) {
        pos = i;
        break;
    }
}
if (pos >= 0) {
    IO.println("Encontrado no índice " + pos);
} else {
    IO.println("Não encontrado");
}
```

## Q5

`int maximo(...)` — `static` opcional nesta aula.

```java
String conceito(double media) {
    return switch ((int) media) { // ou if encadeado se a média não for inteira: use if (media >= 9)
        case 10, 9 -> "A";
        case 8, 7 -> "B";
        case 6, 5 -> "C";
        default -> "D";
    };
}
```

Com `double` quebrado (6.5), o `switch` em `(int) media` arredonda para baixo (6 → C, correto para ≥ 5). Prefira `if (media >= 9.0)` se quiser o enunciado literal.

## Q6

`do { ... } while (opcao != 0);` com `switch` **expressão** ou `->`. Menu em text block `"""`. No `default`, mensagem de opção inválida. Use `double` nas fórmulas e `IO.readln`.

## Q7

```java
int i = 0;
int j = v.length - 1;
while (i < j) {
    int tmp = v[i];
    v[i] = v[j];
    v[j] = tmp;
    i++;
    j--;
}
```

Erro comum: criar `int[] outro = new int[6]` — aceite só se o enunciado for relaxado; o pedido é in-place.

## Q8

```java
static boolean ehPrimo(int n) {
    if (n < 2) return false;
    for (int d = 2; d * d <= n; d++) {
        if (n % d == 0) return false;
    }
    return true;
}
```

Laço `for (int i = 2; i <= n; i++)` imprimindo quando `ehPrimo(i)`.
