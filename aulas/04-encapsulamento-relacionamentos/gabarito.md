# Gabarito — Aula 04

## Q1

Construtor:

```java
public Retangulo(double base, double altura) {
    if (base <= 0 || altura <= 0) {
        throw new IllegalArgumentException("base e altura devem ser positivas");
    }
    this.base = base;
    this.altura = altura;
}
```

Se a turma ainda não viu exceções, o fallback `base = 1.0` com `System.err.println` é aceitável. Exceções voltam com mais calma na aula 13.

Sem setter aberto. Se houver `redimensionar(double b, double a)`, valide de novo.

## Q2

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

## Q3

`Pedido.adicionarItem(String nome, int qtd, double preco)` instancia `new ItemPedido(...)` **dentro** do pedido. Isso é composição: o `main` não guarda os itens.

`total()` soma `itens[i].subtotal()` até `quantidade`.

## Q4

`setSaldo` permite `conta.setSaldo(1_000_000)` ou `setSaldo(-1)` sem depósito, saque, auditoria ou cheque especial. O saldo só muda por operações de negócio.

## Q5

Árvore:

```
src/br/edu/ifba/conquista/lp1/exercicio/modelo/Aluno.java
src/br/edu/ifba/conquista/lp1/exercicio/modelo/Turma.java
src/br/edu/ifba/conquista/lp1/exercicio/app/Principal.java
```

`Principal` faz `import br.edu.ifba.conquista.lp1.exercicio.modelo.*;`

## Q6

```java
public class Matricula {
    private final Estudante estudante;
    private final Disciplina disciplina;
    private double nota;
    // getters, setNota com validação 0–10
}
```

`Instituto` (ou `Secretaria`) guarda `Matricula[]`. Consultas filtram pelo objeto disciplina/estudante (`==` de referência nesta etapa).
