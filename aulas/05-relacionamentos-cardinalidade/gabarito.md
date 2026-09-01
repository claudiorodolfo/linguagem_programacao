# Gabarito — Relacionamentos e cardinalidade

## Q1

```java
public boolean matricular(Aluno aluno) {
    if (aluno == null || quantidade >= alunos.length) {
        return false;
    }
    alunos[quantidade] = aluno;
    quantidade++;
    return true;
}

public double mediaDaTurma() {
    if (quantidade == 0) {
        return 0.0;
    }
    double soma = 0;
    for (int i = 0; i < quantidade; i++) {
        soma += alunos[i].getMedia();
    }
    return soma / quantidade;
}
```

Erro comum: iterar `alunos.length` em vez de `quantidade` (posições `null` → NPE).

## Q2

`Pedido.adicionarItem(String nome, int qtd, double preco)` instancia `new ItemPedido(...)` **dentro** do pedido. Isso é composição: o `main` não guarda os itens.

`total()` soma `itens[i].subtotal()` até `quantidade`.

## Q3

1. Composição 1–1: o endereço nasce (e some) com o usuário neste modelo.
2. Agregação (ou associação) 1–N: o aluno existe sem a turma.
3. Associação N–N resolvida por classe associativa `Emprestimo` (1 empréstimo liga 1 usuário a 1 livro; no conjunto vira N–N).

Aceite “associação” em (2) se o ciclo de vida estiver correto. Zere “composição” em (2) sem ressalva.

## Q4

```java
public String cidade() {
    return endereco.cidade();
}
```

O `main` não depende da forma interna do endereço. Se surgir `bairro`, só `Usuario` (ou `Endereco.formatado()`) muda.

## Q5

```java
public class Matricula {
    private final Estudante estudante;
    private final Disciplina disciplina;
    private double nota;
    // getters, setNota com validação 0–10
}
```

`Instituto` (ou `Secretaria`) guarda `Matricula[]`. Consultas filtram pelo objeto disciplina/estudante (`==` de referência nesta etapa).

## Q6

Árvore análoga à aula de encapsulamento e pacotes. `Principal` importa o pacote `modelo`.
