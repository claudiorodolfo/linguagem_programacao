# Exercícios — Aula 10 (polimorfismo)

## Laboratório

### Q1 — Folha

Com `Funcionario` e `Gerente` da aula 09, escreva:

```java
static double totalFolha(Funcionario[] equipe)
```

Crie um vetor com 2 funcionários e 2 gerentes. Confira na mão o total.

### Q2 — Relatório polimórfico

`static void relatorio(Funcionario[] equipe)` imprime `toString()` e `folha()` de cada um **sem** `instanceof`.

### Q3 — Onde o instanceof aparece

Adicione `Estagiario extends Funcionario` com `valeTransporte`. Escreva `static double totalVale(Funcionario[] equipe)` somando o vale **só** dos estagiários. Depois responda: como você eliminaria esse `instanceof` no desenho da hierarquia? (não precisa recodificar)

### Q4 — Previsão

```java
Conta c = new ContaCorrente("x", 100, 50);
c.sacar(130);
System.out.println(c.getSaldo());
```

Qual o saldo impresso? Por quê?

## Casa

### Q5 — Sobrecarga vs sobrescrita

```java
static void mostra(Conta c) { System.out.println("conta"); }
static void mostra(ContaCorrente c) { System.out.println("corrente"); }

Conta x = new ContaCorrente("1", 0, 0);
mostra(x);
```

O que imprime? Relacione com “escolha em compilação”.

### Q6 — Biblioteca

`Midia[]` com livros e revistas. Método `static int contarLivros(Midia[] m)` com `instanceof`. Em seguida, proponha um método `boolean ehEmprestavelPorDias(int d)` nas subclasses para o `instanceof` sumir da contagem (mesmo que a pergunta original fosse “contar livros”).
