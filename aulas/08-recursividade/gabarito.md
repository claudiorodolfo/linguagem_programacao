# Gabarito — Recursividade

## Q1

```java
static int somaAte(int n) {
    if (n <= 1) {
        return n;
    }
    return n + somaAte(n - 1);
}
```

## Q2

```java
static long potencia(int base, int exp) {
    if (exp == 0) {
        return 1;
    }
    return base * potencia(base, exp - 1);
}
```

## Q3 (com índices)

```java
static boolean palindromo(String s) {
    if (s == null) {
        return false;
    }
    return palindromo(s, 0, s.length() - 1);
}

static boolean palindromo(String s, int i, int j) {
    if (i >= j) {
        return true;
    }
    if (s.charAt(i) != s.charAt(j)) {
        return false;
    }
    return palindromo(s, i + 1, j - 1);
}
```

## Q4

```java
static int busca(int[] v, int alvo, int inicio, int fim) {
    if (inicio > fim) {
        return -1;
    }
    int meio = inicio + (fim - inicio) / 2; // evita overflow de (inicio+fim)/2
    if (v[meio] == alvo) {
        return meio;
    }
    if (alvo < v[meio]) {
        return busca(v, alvo, inicio, meio - 1);
    }
    return busca(v, alvo, meio + 1, fim);
}
```

Erro comum: `meio + 1` / `meio - 1` esquecidos → laço infinito de recursão (na prática, stack overflow).

## Q5

```
fatorial(3) = 3 * fatorial(2)
fatorial(2) = 2 * fatorial(1)
fatorial(1) = 1
volta: 2 * 1 = 2
volta: 3 * 2 = 6
```

## Q6

```java
static int maximo(int[] v, int i) {
    if (i == v.length - 1) {
        return v[i];
    }
    int resto = maximo(v, i + 1);
    return v[i] > resto ? v[i] : resto;
}
```

Trate vetor vazio na fachada `maximo(v)` (exceção ou sentinela).

## Q7

```java
static int somaDigitos(int n) {
    if (n < 10) {
        return n;
    }
    return (n % 10) + somaDigitos(n / 10);
}
```

## Q8

```java
static long potenciaLog(int base, int exp) {
    if (exp == 0) {
        return 1;
    }
    if (exp % 2 == 0) {
        long metade = potenciaLog(base, exp / 2);
        return metade * metade;
    }
    return base * potenciaLog(base, exp - 1);
}
```

Para \(2^{16}\), a versão linear faz 16 multiplicações recursivas; a logarítmica faz da ordem de \(\log_2 16 = 4\) ramificações (conte no depurador).

## Q9

```java
static void mover(int n, char origem, char destino, char auxiliar) {
    if (n == 1) {
        System.out.println(origem + " -> " + destino);
        return;
    }
    mover(n - 1, origem, auxiliar, destino);
    System.out.println(origem + " -> " + destino);
    mover(n - 1, auxiliar, destino, origem);
}
```
