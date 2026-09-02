# Gabarito — Classes internas e externas

## Q1

- `new Campus.Sala()` — **não** compila. `Sala` é interna de instância; falta o objeto `Campus`.
- `c.new Sala()` — **compila**.
- `new Sala()` — **não** compila no `main` (não há tipo `Sala` solto nem objeto externo).

## Q2

```java
public class Usuario {
    private String matricula;
    private String nome;

    public Usuario(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public class Carteirinha {
        public String texto() {
            return matricula + " - " + nome;
        }
    }
}

// no main:
Usuario u = new Usuario("2026001", "Ana");
Usuario.Carteirinha cartao = u.new Carteirinha();
IO.println(cartao.texto());
```

## Q3

1. `Horario` estática não usa objeto de `Biblioteca`; `expediente()` é independente.
2. `nomeDoCampus` é de instância: a estática **não** o enxerga. Para ler, receba uma `Biblioteca` (ou o `String`) por parâmetro, ou torne `Horario` interna de instância.

## Q4

```java
Conta a = new Conta("2026-001", 100);
Conta b = new Conta("2026-002", 200);
Conta.Movimento m1 = a.registrar("depósito", 10);
Conta.Movimento m2 = b.registrar("saque", 20);
IO.println(m1.texto()); // começa com 2026-001
IO.println(m2.texto()); // começa com 2026-002
```

Cada `Movimento` carrega a referência implícita da conta que o criou.

## Q5

```java
Conta demo = new Conta("000", 0) {
    @Override
    public String toString() {
        return "conta de demonstração";
    }
};
IO.println(demo);
```
