# Gabarito — Integradores de POO

## Q1

1. Não existe “item genérico” instanciável; há código comum (código, título) e `resumo()` específico.
2. `ObraConsulta` é item mas não se empresta. O contrato de empréstimo é `Emprestavel`.
3. Mentiria o domínio e permitiria `emprestar` em obra rara. Quebra Liskov / o modelo.

## Q2

Espelhe `Livro` com `prazoDias()` = 3 e campo duração. `resumo()` inclui minutos.

## Q3

Na interface:

```java
double valorMultaPorDia();
int prazoDias();
```

`Emprestimo.multa(int atraso)` = `atraso * item.valorMultaPorDia()` (se atraso < 0, 0).

Livro 1.0, revista 2.0, DVD 3.0 (sugestão).

## Q4

```java
for (int i = 0; i < quantidadeItens; i++) {
    ItemAcervo item = itens[i];
    if (item instanceof Emprestavel e && e.isDisponivel()) {
        IO.println(item.resumo());
    }
}
```

## Q5

```java
public abstract class UsuarioBiblioteca {
    public abstract int limiteEmprestimos();
    public boolean podeEmprestarMais() {
        return quantidadeAtual < limiteEmprestimos();
    }
}
```

`AlunoGraduacao` retorna 3; `Docente` retorna 8. Construtor da superclasse não recebe limite.

## Q6

`Biblioteca` com `Emprestavel[] equipamentos` à parte, ou um único `Emprestavel[]` para tudo que se empresta (livros também entram aí **e** em `ItemAcervo[]` — dois registros do mesmo objeto, composição de visões). Mais limpo: um `Emprestavel[] acervoEmprestavel` preenchido no cadastro se `item instanceof Emprestavel`.

## Q7

```java
static int contar(ItemAcervo[] v, int i) {
    if (v == null || i >= v.length) return 0;
    int agora = v[i] == null ? 0 : 1;
    return agora + contar(v, i + 1);
}
```

## Q8

Interface `PoliticaPrazo { int dias(); double multaDia(); }` injetada no construtor de `Livro`. Fora do escopo mínimo da prova.
