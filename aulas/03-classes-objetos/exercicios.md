# Exercícios — Aula 03 (classes e objetos)

## Laboratório

### Q1 — Classe `Retangulo`

Atributos: `base` e `altura` (`double`). Construtor com os dois. Métodos `area()`, `perimetro()` e `ehQuadrado()`. Teste dois retângulos no `main`.

### Q2 — Classe `Aluno`

Atributos: `nome`, `matricula` (`String`), `n1`, `n2` (`double`). Método `media()` e `aprovado()` (média ≥ 7). Crie três alunos e imprima um relatório.

### Q3 — Completar `ContaBancaria`

A partir do código da aula, adicione:

- `boolean transferir(ContaBancaria destino, double valor)` — só transfere se o saque na origem funcionar;
- um contador **estático** `int totalDeContas` incrementado no construtor. Imprima o total após criar 3 contas.

Explique no comentário a diferença entre `totalDeContas` (da classe) e `saldo` (do objeto).

### Q4 — Referências

Sem executar de cabeça, escreva o que será impresso e depois confira:

```java
ContaBancaria a = new ContaBancaria("001", 100);
ContaBancaria b = a;
ContaBancaria c = new ContaBancaria("002", 100);
b.depositar(50);
c.depositar(50);
System.out.println(a.consultarSaldo());
System.out.println(b.consultarSaldo());
System.out.println(c.consultarSaldo());
System.out.println(a == b);
System.out.println(a == c);
```

## Casa

### Q5 — Classe `Relogio`

Atributos `hora` (0–23), `minuto` (0–59). Construtor. Métodos `tic()` (avança 1 minuto, virando a hora se preciso) e `texto()` no formato `HH:MM`. Simule 70 tics a partir de 23:50.

### Q6 — (desafio) Classe `Carrinho`

Um carrinho tem até 10 nomes de produto (`String[]`) e um `quantidade` de itens efetivos. Métodos `adicionar(String produto)`, `removerUltimo()`, `listar()`. Não use `ArrayList` ainda — só arranjo.
