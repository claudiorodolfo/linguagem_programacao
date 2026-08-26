# Exercícios — Aula 05 (depuração)

Regra do laboratório: **não reescreva o programa do zero**. Encontre o defeito, explique em um comentário `// BUG:` / `// FIX:` e corrija.

## Laboratório

### Q1 — `MediaBugada`

Entrada fixa no código: notas 7, 8 e 9. A média deveria ser 8.0.  
Tarefas: (1) reproduzir; (2) breakpoint no laço; (3) listar *dois* defeitos distintos; (4) corrigir.

### Q2 — `TransferenciaBugada`

Ana tem 500, Bruno tem 100. Ana transfere 150 para Bruno. Saldos esperados: 350 e 250.  
O que acontece? Corrija sem mudar a assinatura de `transferir`.

### Q3 — `BuscaBugada`

O método deveria devolver o índice do nome no cadastro ou `-1`. Teste:

- buscar `"Ana"` em `{"Ana", "Bruno", "Caio"}` → 0  
- buscar `"Caio"` → 2  
- buscar `"Diana"` → -1  

Há mais de um defeito.

### Q4 — Relatório de caça

Para **um** dos bugs acima, preencha:

| Campo | Sua resposta |
| --- | --- |
| Sintoma (o que vi) | |
| Hipótese | |
| Evidência no depurador (variável = valor na linha X) | |
| Correção | |
| Como confirmei | |

## Casa

### Q5 — NPE de propósito

Escreva um `main` de 10 linhas que lance `NullPointerException`. Rode **sem** debugger, leia o stack trace, anote arquivo e linha. Depois rode **com** debugger (a IDE costuma parar na exceção). Compare o tempo das duas abordagens.

### Q6 — Breakpoint condicional

Crie um vetor de 100 inteiros (`v[i] = i`). Coloque um breakpoint que só dispare quando `i == 87` e `v[i] % 87 == 0`. Tire um print da tela de variáveis (ou descreva os valores). Entrega: a descrição, não o print obrigatório.

### Q7 — (desafio) Buffer de `Scanner` vs `IO.readln`

Escreva um programa que lê `int` com `Scanner.nextInt()` e em seguida um nome com `nextLine()`. Mostre por que o nome “pula”. A correção moderna da disciplina: `Integer.parseInt(IO.readln())` — não mistura buffer. (Isto não é falha da JVM; é o `Scanner`. O depurador ajuda a ver a `String` vazia.)
