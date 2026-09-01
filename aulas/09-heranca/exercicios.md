# Exercícios — Aula 09 (herança)

## Laboratório

### Q1 — Hierarquia `Funcionario`

`Funcionario`: `nome`, `salario` (`private`), construtor, `getSalario()`, `folha()` que devolve o salário.  
`Gerente extends Funcionario`: `bonus`. Construtor chama `super`. Sobrescreva `folha()` = salário + bônus.  
Crie 1 funcionário e 1 gerente no `main` e imprima a folha de cada um.

### Q2 — `toString`

Implemente `toString` nas duas classes. O gerente deve reutilizar informação do funcionário (`super.toString()`).

### Q3 — Conta corrente

A partir do código da aula, adicione `ContaSalario extends Conta` que **não** permite saldo negativo e cobra taxa fixa de R$ 2,00 em todo saque (débito extra). Se não houver saldo para valor+taxa, recusa.

### Q4 — Construtor

Explique por escrito (5–8 linhas) o que acontece se a subclasse **não** chama `super(...)` e a superclasse só tem construtor com parâmetros.

## Casa

### Q5 — `Midia` da biblioteca

`Midia`: `titulo`, `ano`.  
`Livro extends Midia`: `autor`, `paginas`.  
`Revista extends Midia`: `edicao`.  
`Video extends Midia`: `duracaoMinutos`.  
Todos com `toString` incluindo o tipo. Array `Midia[]` no `main` (mesmo sem polimorfismo de método ainda: você vai chamar `toString`, que já é polimórfico — spoiler controlado da aula 10).

### Q6 — (desafio) Proteção

Mude `saldo` para `private` na `Conta` e faça `ContaCorrente.sacar` funcionar só com métodos `protected` da superclasse (`getSaldo()`, `debitar(double)`). Compare com a versão `protected double saldo`. Qual você usaria num sistema real?
