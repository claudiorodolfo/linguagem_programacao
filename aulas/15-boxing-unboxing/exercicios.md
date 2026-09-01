# Exercícios — Aula 15 (wrappers)

## Laboratório

### Q1 — Conversão

Leia um inteiro com `IO.readln` + `Integer.parseInt`. Trate `NumberFormatException` com mensagem “digite um número inteiro” e peça de novo (`do-while`).

### Q2 — Lista de notas

`ArrayList<Double>` com 4 notas. Calcule a média. Use unboxing natural no `for-each`. Imprima também a maior nota com um laço (não use `Collections.max`, a menos que queira mostrar no final).

### Q3 — Cache

Escreva um `main` que imprime `==` e `equals` para os pares 127/127, 128/128 e `Integer.valueOf(127)` duas vezes versus duas autoboxings de 128. Anote a tabela no caderno **antes** de rodar; depois confira.

Não use `new Integer(...)` — esses construtores foram removidos.

### Q4 — Nota opcional

`Integer mediaFinal = null` significa “não lançada”. Método `static String situacao(Integer media)`:

- `null` → `"sem média"`
- unbox se não nulo: ≥ 7 aprovado, senão reprovado  

Não pode lançar NPE. Teste os três caminhos.

## Casa

### Q5 — Soma segura

`static int soma(Integer a, Integer b)` devolve a soma dos valores, tratando `null` como 0. Teste `(null, 3)`, `(2, null)`, `(null, null)`, `(2, 3)`.

### Q6 — Frequência de dígitos

Leia um `int` positivo. Use `Integer.toString` (ou divisões) e um `int[10]` para contar dígitos 0–9. Wrappers: explique em comentário se o vetor **precisa** ser `Integer[]` (spoiler: não).

### Q7 — (desafio) Comparar listas

Dadas duas `ArrayList<Integer>`, diga se têm os mesmos números **na mesma ordem** sem `equals` da lista (implemente o laço). Cuidado com `null` dentro da lista e com `==`.
