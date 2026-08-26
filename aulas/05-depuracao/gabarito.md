# Gabarito — Aula 05

## Q1 — `MediaBugada`

Dois defeitos (pelo menos):

1. **Divisão inteira:** `soma / notas.length` com `soma` int. `24/3` até funciona neste exemplo; mude as notas para 1, 2, 2 e a média vira `1` em vez de `1.666...`. No código da aula, `soma` é `int` e ainda há o item 2, que já quebra 7, 8, 9.
2. **Off-by-one / índice:** o laço usa `i <= notas.length` ou começa em 1 e ignora o primeiro elemento. No arquivo: laço `for (int i = 1; i <= notas.length; i++)` — estoura índice **e** pula `notas[0]`.

Correção: `for (int i = 0; i < notas.length; i++)` e `soma / (double) notas.length`.

Há ainda um terceiro, mais sutil, se alguém “corrigir” só o `<=` e deixar `i = 1`: média de 8 e 9 = 8.5, não 8.0.

## Q2 — `TransferenciaBugada`

O depósito é feito em `this` (origem) depois de um saque bem-sucedido, ou o destino é ignorado (`destino = this` por acidente). No código: `this.depositar(valor)` após `sacar`, em vez de `destino.depositar(valor)`. Ana fica com o mesmo saldo; Bruno não recebe.

FIX: `destino.depositar(valor)` somente se `sacar(valor)` for verdadeiro.

## Q3 — `BuscaBugada`

1. Comparação `cadastro[i] == nome` (referência). Literais internados *às vezes* passam no teste com `"Ana"` escrito no código; falha com `new String("Ana")` ou leitura do teclado. Sempre `equals`.
2. `return -1` **dentro** do `for` (na primeira diferença), então só o índice 0 tem chance. O `-1` deve ficar **depois** do laço.

## Q4

Aceite qualquer relatório que ligue hipótese → valor observado → correção. Recuse “mudei até funcionar” sem evidência.

## Q5

```java
String s = null;
System.out.println(s.length());
```

Stack trace aponta a linha do `.length()`.

## Q6

No IntelliJ: botão direito no breakpoint → *Condition* → `i == 87`. O restante é conferir `v[87]`.

## Q7

`nextInt()` não consome a quebra de linha. `nextLine()` seguinte lê string vazia. FIX: `nextLine()` extra, ou ler tudo com `nextLine()` + `Integer.parseInt`.
