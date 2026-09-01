# Gabarito — Polimorfismo

## Q1

```java
static double totalFolha(Funcionario[] equipe) {
    double s = 0;
    for (Funcionario f : equipe) {
        s += f.folha();
    }
    return s;
}
```

O ponto: `folha()` do gerente já inclui bônus.

## Q2

```java
for (Funcionario f : equipe) {
    System.out.println(f + " → " + f.folha());
}
```

## Q3

`instanceof Estagiario` + getter do vale. Eliminação: `double beneficioTransporte()` na superclasse retornando 0, sobrescrito no estagiário. `totalVale` vira soma polimórfica.

## Q4

`100 - 130 = -30` (limite 50 cobre). Ligação dinâmica chama `ContaCorrente.sacar`.

## Q5

Imprime `conta`. A sobrecarga usa o tipo da **referência** (`Conta`). Não há sobrescrita aqui.

## Q6

Contar livros com `instanceof Livro` é aceitável no exercício. Alternativa: `boolean ehLivro()` é um cheiro ruim. Melhor: não contar por tipo, e sim por capacidade (`emprestavel()`, `getClass()` só em infraestrutura). Aceite discussão.
