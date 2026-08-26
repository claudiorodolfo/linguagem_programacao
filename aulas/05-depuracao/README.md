# Aula 05 — Depuração de programas

**Data:** 31/08  
**Unidade:** 1  
**Pré-requisito:** aulas 03 e 04

## Objetivos

- Distinguir erro de compilação, erro de execução e erro de lógica.
- Usar breakpoints, passo a passo, inspeção de variáveis e pilha de chamadas.
- Corrigir falhas com evidência (não “achando” o bug).
- Reconhecer NPE, índice inválido, off-by-one e estado inconsistente.

## Roteiro

1. Mostre um programa que **compila e roda** mas dá resultado errado (`MediaBugada`). Pergunte: “onde está o erro?”
2. `println` de emergência: funciona, mas suja o código e não mostra o caminho.
3. Abra a IDE, coloque breakpoint, rode em debug. Atalhos em [`recursos/ambiente.md`](../../recursos/ambiente.md).
4. Laboratório: os arquivos `*Bug.java` compilam; a tarefa é **achar e corrigir** sem olhar o gabarito.

## 1. Três famílias de erro

| Família | Quando aparece | Exemplo |
| --- | --- | --- |
| Compilação | `javac` recusa | `;` faltando, tipo errado |
| Execução (exceção) | a JVM interrompe | `NullPointerException`, divisão por zero em inteiro |
| Lógica | “funciona”, mas o resultado é falso | média com `n` errado, `=` no lugar de `==` |

Depurar é sobretudo a terceira família — e a segunda, quando a mensagem da exceção não for óbvia.

## 2. Leia a pilha (stack trace)

```
Exception in thread "main" java.lang.NullPointerException:
    Cannot invoke "String.length()" because "s" is null
    at Turma.mediaDaTurma(Turma.java:28)
    at Demo.main(Demo.java:12)
```

Desde o Java 14 a mensagem **diz qual referência é null**. Leia **de cima para baixo**: o problema estourou na linha 28 de `Turma.java`.

## 3. Ferramentas do depurador

| Ferramenta | Para que serve |
| --- | --- |
| **Breakpoint** | Pausar **antes** de executar aquela linha |
| **Step over** | Executa a linha inteira (não entra no método) |
| **Step into** | Entra no método chamado |
| **Step out** | Termina o método atual e volta ao chamador |
| **Resume** | Segue até o próximo breakpoint |
| **Variables / Watches** | Ver valores vivos |
| **Call stack** | Quem chamou quem |
| **Breakpoint condicional** | Só para quando `i == 39` (útil em laços) |

Ritual no quadro:

1. Reproduza o erro (sempre).
2. Formule uma hipótese (“a média usa `length` em vez de `quantidade`”).
3. Coloque um breakpoint **antes** do sintoma.
4. Confirme ou refute olhando variáveis.
5. Corrija **uma** coisa e rode de novo.

## 4. `println` versus depurador

`IO.println("x=" + x)` ou `System.out.println` são válidos em exercício rápido. Limitações: não mostram o caminho, não permitem mudar o próximo passo, e os prints ficam no código. Combine: hipótese no papel + debugger na dúvida.

## 5. Bugs clássicos desta disciplina

1. **NPE** — referência `null` (objeto não criado, arranjo com buraco).
2. **Off-by-one** — `i <= v.length` ou `i < quantidade - 1` no lugar errado.
3. **`==` em String** — compara referência; use `equals`.
4. **Atributo não inicializado** — `int` vira 0 e “parece” que funcionou.
5. **Método que não devolve o que você pensa** — `return` no lugar errado dentro do `for`.
6. **Alias** — duas variáveis, um objeto (aula 03); o “outro” saldo também muda.

## 6. Código desta aula

| Arquivo | Intenção |
| --- | --- |
| `MediaBugada.java` | Erro de lógica na média (divisão inteira + índice) |
| `TransferenciaBugada.java` | Saque ok, depósito no objeto errado |
| `BuscaBugada.java` | `return` dentro do laço no lugar errado / `==` em String |
| `DemoDebug.java` | Menu para escolher o cenário no projetor |

**Não “consertem” os arquivos no Git antes da aula.** O ponto é a turma quebrar a cabeça. Depois da prática, compare com `gabarito.md`.

Há também `versao-corrigida/` com as mesmas classes já revisadas, para o docente projetar no fechamento.

## Sessão ao vivo (sugestão)

1. Rode `MediaBugada` com notas 7, 8, 9. Peça o valor esperado (8.0) e o obtido.
2. Breakpoint na linha da soma. Observe `i` e `soma`.
3. Step into em `TransferenciaBugada.transferir`. Veja `destino` versus `this`.
4. Mostre a call stack: `main` → `transferir` → `sacar`.

## Ponte para a aula 06

A pilha de chamadas do depurador é a **mesma ideia** da recursão: cada chamada empilha um quadro. Na próxima aula essa pilha vira o mecanismo do algoritmo.
