# Gabarito — Classes e objetos

## Q1

```java
public class Pessoa {
    String nome;
    int idade;

    public String apresentar() {
        return nome + " (" + idade + " anos)";
    }
}
```

No `main`: `new Pessoa()`, preencher `nome` e `idade`, chamar `apresentar()`.

## Q2

Dois `new Livro()` produzem **dois** objetos. `emprestar()` altera só o estado da instância receptora. O segundo livro não foi alvo da chamada.

## Q3

```
true
true
false
true
false
```

`a` e `b` são a mesma instância (emprestada). `c` é outro objeto, ainda disponível. `==` compara referências.

## Q4

```java
Livro x = new Livro();
x.titulo = "Clean Code";
x.autor = "Martin";
Livro y = new Livro();
y.titulo = "Clean Code";
y.autor = "Martin";
IO.println(x == y);                 // false: identidades diferentes
IO.println(x.titulo.equals(y.titulo)); // true: estado parecido
```

## Q5

`ligar` faz `ligada = true`; `desligar` faz `false`; `estaLigada` devolve o atributo. O `main` só cria, chama e imprime.

## Q6

`a`, `b` e `d` veem `emprestado == true`. `c` permanece `false`. Três nomes, um objeto — o quarto nome aponta para outro.
