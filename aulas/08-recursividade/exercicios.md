# Exercícios — Aula 08 (recursividade)

Em todas as questões: **caso-base explícito**. Teste o caso-base no `main` antes do caso grande.

## Laboratório

### Q1 — Soma de 1 até n

`static int somaAte(int n)` com `n >= 1`. Iterativa vale como conferência, mas a entrega é recursiva.

### Q2 — Potência

`static long potencia(int base, int exp)` com `exp >= 0`. `potencia(2, 10)` = 1024. Não use `Math.pow`.

### Q3 — Palíndromo

`static boolean palindromo(String s)`. Ignore diferenças só se quiser (opcional: minúsculas). Strings com 0 ou 1 caractere são palíndromo. Use `charAt` e `substring` **ou** uma sobrecarga com índices (`palindromo(s, i, j)`) — a segunda é melhor.

### Q4 — Busca binária recursiva

`static int buscaBinaria(int[] v, int alvo)` devolvendo índice ou -1. Pré-condição: `v` ordenado crescente. Implemente um auxiliar `busca(v, alvo, inicio, fim)`.

### Q5 — Rastrear na mão

Sem executar, escreva os retornos de `fatorial(3)` quadro a quadro (como na lousa). Depois confira no depurador.

## Casa

### Q6 — Máximo no vetor

`static int maximo(int[] v)` recursivo. Não percorra com `for`. Dica: máximo de `v[i..fim]` = max(`v[i]`, máximo de `v[i+1..fim]`).

### Q7 — Digits

`static int somaDigitos(int n)` para `n >= 0`. `somaDigitos(172)` = 1+7+2 = 10.

### Q8 — (desafio) Potência logarítmica

Se `exp` é par, `potencia(base, exp) = quadrado(potencia(base, exp/2))`. Se ímpar, `base * potencia(base, exp - 1)`. Conte chamadas para `potencia(2, 16)` e compare com a versão linear da Q2.

### Q9 — (desafio) Hanói

`mover(n, origem, destino, auxiliar)` imprimindo cada movimento. Rode só com `n <= 4` no laboratório.
