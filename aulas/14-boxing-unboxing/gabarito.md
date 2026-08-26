# Gabarito — Aula 14

## Q1

```java
Integer valor = null;
do {
    try {
        valor = Integer.parseInt(IO.readln("n: ").strip());
    } catch (NumberFormatException e) {
        IO.println("digite um número inteiro");
    }
} while (valor == null);
```

Ou `int` com flag `boolean ok`.

## Q2

```java
double soma = 0;
double maior = notas.get(0);
for (Double n : notas) {
    soma += n; // unboxing
    if (n > maior) maior = n;
}
```

Se a lista puder estar vazia, trate antes de `get(0)`.

## Q3

| Expressão | `==` típico | `equals` |
| --- | --- | --- |
| 127 e 127 autobox | true | true |
| 128 e 128 autobox | false | true |
| `Integer.valueOf(127)` duas vezes | true (cache) | true |
| 128 autobox duas vezes | false | true |

Não memorize o cache como “sempre true abaixo de 128 em qualquer JVM antiga” — a garantia da linguagem é o `valueOf` nesse intervalo. A lição é: use `equals`.

## Q4

```java
static String situacao(Integer media) {
    if (media == null) {
        return "sem média";
    }
    return media >= 7 ? "aprovado" : "reprovado"; // unboxing seguro
}
```

## Q5

```java
static int soma(Integer a, Integer b) {
    int x = a == null ? 0 : a;
    int y = b == null ? 0 : b;
    return x + y;
}
```

## Q6

`int[] freq = new int[10];` — primitivo basta; não há “ausência” por posição. `Integer[]` só introduziria `null` e NPE.

## Q7

Compare `size`; depois `i` de 0 até size-1; `Objects.equals(a.get(i), b.get(i))` ou teste de `null` manual + `equals`.
