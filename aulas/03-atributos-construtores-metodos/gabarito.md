# Gabarito — Atributos, construtores e métodos

## Q1

```java
public class Retangulo {
    double base;
    double altura;

    public Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double area() {
        return base * altura;
    }

    public double perimetro() {
        return 2 * (base + altura);
    }

    public boolean ehQuadrado() {
        return base == altura;
    }
}
```

Observação: comparação de `double` com `==` é aceitável aqui se os valores forem literais; mencione que em cálculo real se usa tolerância.

## Q2

Construtor guarda nome e matrícula; `n1` e `n2` ficam 0. `lancarNotas` atribui com `this.n1 = n1`. `media()` retorna `(n1 + n2) / 2.0`. `aprovado()` retorna `media() >= 7.0`.

## Q3

`transferir` saca na origem e, se der certo, deposita no destino. Campo estático:

```java
static int totalDeContas = 0;

public ContaBancaria(String numero, double saldoInicial) {
    this.numero = numero;
    this.saldo = saldoInicial;
    totalDeContas++;
}
```

`totalDeContas` é **um** valor compartilhado; `saldo` existe **por objeto**.

## Q4

`this(...)` precisa ser a primeira instrução — caso contrário o código não compila. Encadeamento pedido:

```java
public Livro(String titulo, String autor) {
    this(titulo, autor, 0);
}
```

## Q5

```java
public void tic() {
    minuto++;
    if (minuto == 60) {
        minuto = 0;
        hora++;
        if (hora == 24) {
            hora = 0;
        }
    }
}

public String texto() {
    return String.format("%02d:%02d", hora, minuto);
}
```

## Q6

Guarde `quantidade` (0–10). `adicionar` recusa se `quantidade == produtos.length`. `removerUltimo` decrementa se `quantidade > 0`. `listar` itera de 0 até `quantidade - 1`.
