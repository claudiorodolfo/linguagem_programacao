# Exercícios — Aula 05 (relacionamentos e cardinalidade)

## Laboratório

### Q1 — Classe `Turma` (1–N)

`Turma` tem `codigo` (`String`) e até 40 `Aluno` (arranjo + `quantidade`). Métodos `matricular(Aluno a)`, `mediaDaTurma()`, `listar()`. `Aluno` com `nome` e `media` encapsulados. O `main` não acessa o arranjo interno.

### Q2 — Composição `Pedido` / `ItemPedido`

`ItemPedido`: nome do produto, quantidade, preço unitário; método `subtotal()`.  
`Pedido`: número, arranjo de itens (máx. 20), `adicionarItem(...)`, `total()`.  
O item só existe dentro do pedido (não há lista global de itens).

### Q3 — Classificar o vínculo

Para cada par, diga associação, agregação ou composição **e** a cardinalidade (1–1, 1–N, N–N). Justifique com ciclo de vida:

1. `Usuario` e `Endereco` (como nesta aula).
2. `Turma` e `Aluno`.
3. `Emprestimo` como ligação entre `Usuario` e `Livro`.

### Q4 — Lei de Demeter (leve)

Dado `usuario.getEndereco().cidade()`, reescreva um método em `Usuario` que devolva a cidade **sem** o `main` conhecer `Endereco`. Por que isso ajuda quando o endereço ganhar um campo `bairro`?

## Casa

### Q5 — (desafio) N–N via classe associativa

`Disciplina` e `Estudante`. Um estudante cursa várias disciplinas; uma disciplina tem vários estudantes. Não use duas listas cruzadas soltas: crie `Matricula` (estudante + disciplina + nota). Liste alunos de uma disciplina percorrendo as matrículas.

### Q6 — Pacote da aula

Mova `Turma` e `Aluno` para `br.edu.ifba.conquista.lp1.aula05.exercicio.modelo` e o `main` para `...exercicio.app`. Compile com `-d out` e execute pelo nome qualificado.
