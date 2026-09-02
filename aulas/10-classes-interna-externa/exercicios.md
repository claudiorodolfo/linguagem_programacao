# Exercícios — Classes internas e externas

## Q1 — Instanciação

Dado:

```java
public class Campus {
    public class Sala {
        public String codigo;
    }
}
```

Quais das linhas compilam no `main`? Justifique as que falham.

```java
Campus.Sala a = new Campus.Sala();
Campus c = new Campus();
Campus.Sala b = c.new Sala();
Sala d = new Sala();
```

## Q2 — Interna da biblioteca

`Usuario` tem `matricula` e `nome` **privados**. Crie a classe interna `Carteirinha` com um método `texto()` que devolva `matricula - nome` **sem** getters públicos extras. No `main`, instancie um usuário e a carteirinha ligada a ele.

## Q3 — Estática versus interna

`Biblioteca` tem um atributo de instância `String nomeDoCampus`.

1. `public static class Horario` com um método `expediente()` que devolve `"08:00–22:00"`.
2. Tente, dentro de `Horario`, ler `nomeDoCampus`. O que o compilador diz? Como você leria esse nome se precisasse (sem tirar o `static`)?

## Q4 — Dois objetos externos

Crie duas `Conta` (`2026-001` e `2026-002`). Em cada uma, `registrar` um movimento. Imprima o `texto()` dos dois movimentos. O número da conta em cada texto deve ser o da **própria** conta — não o da outra.

## Q5 — Anônima (reconhecer)

No `main`, crie uma `Conta` anônima que sobrescreva `toString()` para devolver `"conta de demonstração"`. Imprima o objeto. Não precisa de arquivo novo.
