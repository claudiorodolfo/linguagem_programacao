# Exercícios — Atributos, construtores e métodos

## Laboratório

### Q1 — Classe `Retangulo`

Atributos: `base` e `altura` (`double`). Construtor com os dois. Métodos `area()`, `perimetro()` e `ehQuadrado()`. Teste dois retângulos no `main`.

### Q2 — Classe `Aluno`

Atributos: `nome`, `matricula` (`String`), `n1`, `n2` (`double`). Construtor com nome e matrícula (notas começam em 0). Métodos `lancarNotas(double n1, double n2)`, `media()` e `aprovado()` (média ≥ 7). Crie três alunos e imprima um relatório.

### Q3 — Completar `ContaBancaria`

A partir do código da aula, confira se você entende `transferir` e o contador estático. Depois:

- acrescente um construtor `ContaBancaria(String numero)` se ainda não estiver no seu arquivo (deve encadear `this(numero, 0.0)`);
- imprima `totalDeContas` após criar 3 contas.

Explique no comentário a diferença entre `totalDeContas` (da classe) e `saldo` (do objeto).

### Q4 — `this` e sobrecarga

Na classe `Livro` da aula, o construtor sem argumentos chama `this(...)`. O que aconteceria se essa chamada **não** fosse a primeira instrução? Escreva um construtor extra `Livro(String titulo, String autor)` que defina `ano` como 0 usando encadeamento.

## Casa

### Q5 — Classe `Relogio`

Atributos `hora` (0–23), `minuto` (0–59). Construtor. Métodos `tic()` (avança 1 minuto, virando a hora se preciso) e `texto()` no formato `HH:MM`. Simule 70 tics a partir de 23:50.

### Q6 — (desafio) Classe `Carrinho`

Um carrinho tem até 10 nomes de produto (`String[]`) e um `quantidade` de itens efetivos. Construtor sem argumentos inicializa o arranjo. Métodos `adicionar(String produto)`, `removerUltimo()`, `listar()`. Não use `ArrayList` ainda — só arranjo.
