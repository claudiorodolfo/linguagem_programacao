# Exercícios — Aula 04

## Laboratório

### Q1 — Encapsular `Retangulo`

Pegue o `Retangulo` da aula 03. Atributos `private`. Construtor rejeita base ou altura ≤ 0 (imprima erro e use 1.0 como fallback, ou recuse criar — documente a escolha). Sem `setBase` que aceite negativo.

### Q2 — Classe `Turma` (1–N)

`Turma` tem `codigo` (`String`) e até 40 `Aluno` (arranjo + `quantidade`). Métodos `matricular(Aluno a)`, `mediaDaTurma()`, `listar()`. `Aluno` com `nome` e `media` encapsulados. O `main` não acessa o arranjo interno.

### Q3 — Composição `Pedido` / `ItemPedido`

`ItemPedido`: nome do produto, quantidade, preço unitário; método `subtotal()`.  
`Pedido`: número, arranjo de itens (máx. 20), `adicionarItem(...)`, `total()`.  
O item só existe dentro do pedido (não há lista global de itens).

### Q4 — Invariante

Na `ContaBancaria` encapsulada desta aula, tente (em comentário) explicar por que **não** deve existir `setSaldo`. O que um atacante faria com ele?

## Casa

### Q5 — Pacote

Mova `Turma` e `Aluno` para `br.edu.ifba.conquista.lp1.exercicio.modelo` e o `main` para `...exercicio.app`. Compile com `-d out` e execute pelo nome qualificado.

### Q6 — (desafio) N–N via classe associativa

`Disciplina` e `Estudante`. Um estudante cursa várias disciplinas; uma disciplina tem vários estudantes. Não use duas listas cruzadas soltas: crie `Matricula` (estudante + disciplina + nota). Liste alunos de uma disciplina percorrendo as matrículas.
