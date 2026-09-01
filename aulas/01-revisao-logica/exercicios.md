# Exercícios — Aula 01 (revisão)

Resolva no laboratório. Entrega sugerida: um arquivo por questão, todos compilando.

## Laboratório (durante a aula)

### Q1 — Par ou ímpar

Leia um inteiro e informe se é par ou ímpar. Use o operador `%`.

### Q2 — Média da turma

Leia a quantidade `n` de estudantes (`n > 0`). Em seguida leia `n` notas (`double`). Imprima a média e quantos ficaram com nota maior ou igual a 7.0.

### Q3 — Tabuada

Leia um inteiro `k` entre 1 e 10. Imprima a tabuada de `k` (de 1 a 10) no formato `k x i = resultado`.

### Q4 — Busca linear

Leia 8 inteiros para um vetor. Depois leia um valor `x`. Informe a **primeira** posição em que `x` aparece (índice 0) ou uma mensagem se não existir.

### Q5 — Métodos

Implemente e teste em `void main()` (métodos de instância; `static` só se quiser):

- `int maximo(int a, int b, int c)`
- `boolean ehBissexto(int ano)` — ano bissexto: divisível por 400, ou divisível por 4 e não por 100
- `String conceito(double media)` — preferível `switch` expressão: A (≥ 9), B (≥ 7), C (≥ 5), D (demais)

Leitura: `IO.readln("prompt: ")` e `Integer.parseInt` / `Double.parseDouble`. Não use `Scanner` nesta lista.

## Casa

### Q6 — Menu com `do-while`

Menu:

1. Celsius → Fahrenheit (`F = C * 9/5 + 32`)
2. Fahrenheit → Celsius (`C = (F - 32) * 5/9`)
0. Sair

Valide opção inválida.

### Q7 — Inverter vetor

Leia 6 inteiros, inverta o vetor **no próprio arranjo** (sem criar outro) e imprima.

### Q8 — (desafio) Primos até n

Leia `n ≥ 2`. Imprima todos os primos de 2 até `n`. Extraia `static boolean ehPrimo(int n)`.
