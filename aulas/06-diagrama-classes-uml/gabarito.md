# Gabarito — Aula 06

## Q1

Caixa `ContaBancaria` com `− numero: String`, `− saldo: double`, `+ depositar(valor: double): void`, `+ sacar(valor: double): boolean`, `+ getSaldo(): double`. Sem `+ setSaldo`.

## Q2

a) Losango **preenchido** em `Pedido`, ponta do item `0..20` ou `1..*` (aceite se justificar “pedido vazio permitido” vs. não). `+ total(): double` em `Pedido`.

b)

```java
public boolean adicionarItem(String nome, int qtd, double preco) {
    if (quantidade >= itens.length) {
        return false;
    }
    itens[quantidade] = new ItemPedido(nome, qtd, preco); // nasce aqui
    quantidade++;
    return true;
}
```

## Q3

Usuario `1` — Emprestimo `0..5`. Emprestimo `0..*` — Livro `1`. Um empréstimo não compartilhado entre livros; o mesmo livro pode ter tido vários empréstimos em momentos diferentes (no modelo simplificado da aula 05, um livro só está emprestado para um usuário de cada vez — aceite `0..1` no lado empréstimo se a justificativa for “um empréstimo ativo”).

## Q4

a) Agregação: o aluno vive sem a turma.  
b) `private String codigo;` `private Aluno[] alunos;` `private int quantidade;`  
c) Não é obrigatório. Se existir, a associação é navegável nos dois sentidos; senão, só `Turma` enxerga `Aluno`.

## Q5

Linha Estudante–Disciplina com `Matricula` presa por tracejado (ou `Matricula` no meio com duas associações 1). Atributo `− nota: double`.

## Q6

Losango vazio está errado: ciclo de vida acoplado pede losango **cheio**. Redesenhar composição `Pedido *-- ItemPedido`.
