# Gabarito — Aula 03

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

`media()` retorna `(n1 + n2) / 2.0`. `aprovado()` retorna `media() >= 7.0`.

## Q3

```java
public boolean transferir(ContaBancaria destino, double valor) {
    if (destino == null) {
        return false;
    }
    if (this.sacar(valor)) {
        destino.depositar(valor);
        return true;
    }
    return false;
}
```

Campo estático:

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

```
150.0
150.0
150.0
true
false
```

`a` e `b` são a mesma conta (100 + 50). `c` é outra (100 + 50).

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
    String h = (hora < 10 ? "0" : "") + hora;
    String m = (minuto < 10 ? "0" : "") + minuto;
    return h + ":" + m;
}
```

Alternativa com `String.format("%02d:%02d", hora, minuto)`.

## Q6

Guarde `quantidade` (0–10). `adicionar` recusa se `quantidade == produtos.length`. `removerUltimo` decrementa se `quantidade > 0`. `listar` itera de 0 até `quantidade - 1`.
