# Gabarito — Herança

## Q1–Q2

```java
public class Funcionario {
    private String nome;
    private double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public double folha() {
        return salario;
    }

    @Override
    public String toString() {
        return nome + " salário=" + salario;
    }

    public double getSalario() {
        return salario;
    }
}

public class Gerente extends Funcionario {
    private double bonus;

    public Gerente(String nome, double salario, double bonus) {
        super(nome, salario);
        this.bonus = bonus;
    }

    @Override
    public double folha() {
        return getSalario() + bonus;
    }

    @Override
    public String toString() {
        return super.toString() + " bônus=" + bonus;
    }
}
```

## Q3

```java
@Override
public boolean sacar(double valor) {
    double total = valor + 2.0;
    return super.sacar(total);
}
```

Se `super.sacar` já valida saldo, a taxa entra no débito. Não chame `saldo -=` direto se o campo for private.

## Q4

O compilador insere `super()` (sem argumentos). Se esse construtor não existe, **erro de compilação**. A subclasse precisa chamar explicitamente `super(params)`.

No Java 25 a chamada **não** precisa ser a primeira linha: dá para validar no prólogo (`if (x < 0) throw ...; super(...)`). Ainda é obrigatório *chamar* `super` quando não há construtor padrão.

## Q5

`Midia[] estante = { new Livro(...), new Revista(...), new Video(...) };`  
`for (Midia m : estante) System.out.println(m);` já usa `toString` dinâmico — deixe a turma descobrir e nomeie na aula de polimorfismo.

## Q6

Sistema real: `private` + `protected void debitar`. Campo `protected` permite que qualquer subclasse (e o pacote) mexa no saldo sem regra.
