# Gabarito — Aula 11

## Q1

```java
public abstract class Forma {
    public abstract double area();
    public abstract double perimetro();
    public abstract String nome();
}
```

`Circulo`: `Math.PI * r * r` e `2 * Math.PI * r`.  
`Quadrado extends Retangulo`: construtor `super(lado, lado)`. Cuidado com Liskov se `Retangulo` tiver `setBase` independente de `setAltura` — neste exercício não tenha setters.

## Q2

```java
static boolean entrar(Autenticavel a, String senha) {
    return a.autenticar(senha);
}
```

Cada classe compara com o campo `senha` encapsulado (`equals`).

## Q3

Poupança: `render()`. Corrente: `sacar(tarifa)` ou debitar tarifa se houver saldo. Não instanciar `Conta`.

## Q4

```java
Relatorio r = new Relatorio("Notas");
Imprimivel i = r;
Persistivel p = r;
i.imprimir();
p.salvar();
```

Mesmo objeto, dois contratos.

## Q5

Livro é mídia; notebook é patrimônio. Forçar `extends ItemEmprestavel` mistura modelos. `implements Emprestavel` descreve **capacidade**, não família.

## Q6

Método `default` na interface; chamadas `item.registrarLog("ok")` compilam nas implementações antigas.
