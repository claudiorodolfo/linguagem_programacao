# Exercícios — Diagrama de classes UML

Desenhe no papel (régua opcional). Depois, onde pedido, escreva o esqueleto Java.

## Laboratório

### Q1 — Completar a caixa

Desenhe a classe `ContaBancaria` da aula de encapsulamento e pacotes com visibilidade: `numero` e `saldo` privados; `depositar`, `sacar` e `getSaldo` públicos. Inclua tipos.

### Q2 — Pedido / ItemPedido

Do enunciado da aula de relacionamentos (composição, máx. 20 itens):

a) Diagrama com losango **correto**, multiplicidades e uma operação `total(): double` em `Pedido`.  
b) Esqueleto de `Pedido.adicionarItem(...)` que deixa claro que o item **nasce** no pedido.

### Q3 — Multiplicidade

Um `Usuario` tem no máximo um `Endereco` e de 0 a 5 `Emprestimo`. Um `Livro` pode aparecer em vários empréstimos ao longo do tempo, mas **um** empréstimo aponta para **um** livro.

Anote as multiplicidades em cada ponta de um esboço Usuario–Emprestimo–Livro. Justifique a ponta `Livro` em uma frase.

### Q4 — Traduzir o diagrama

Dado:

```
Turma 1  ◇──────── 0..40  Aluno
```

(losango **vazio** em `Turma`)

a) Agregação ou composição? Por quê?  
b) Campos em `Turma` (tipos e visibilidade).  
c) `Aluno` deve ter um campo `Turma turma`? O que muda na navegabilidade se tiver?

## Casa

### Q5 — Classe associativa

Desenhe `Estudante` N–N `Disciplina` via `Matricula` (nota: double). Três caixas + o traço da associação. Não use duas listas cruzadas no desenho.

### Q6 — (desafio) Achar o erro

O diagrama abaixo está errado. Circule o erro e redesenhe.

```
Pedido 1  ◇──────── 1..*  ItemPedido     (losango VAZIO em Pedido)
```

O enunciado diz: o item só existe dentro do pedido.
