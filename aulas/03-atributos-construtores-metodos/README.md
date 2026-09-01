# Aula 03 — Atributos, construtores e métodos

**Data:** 24/08  
**Unidade:** 1  
**Pré-requisito:** aula 02

## Objetivos

- Declarar **atributos** de instância e de classe (`static`).
- Escrever **construtores**, sobrecarregá-los e encadeá-los com `this(...)`.
- Usar `this` para desambiguar atributo e parâmetro.
- Definir **métodos** de instância com parâmetros, retorno e regra de negócio.
- Separar classe de modelo e classe `Demo` / `main`.

## Roteiro

1. Reabra o `Livro` da aula 02: “e se alguém esquecer `titulo`?” Passe a exigir inicialização no construtor.
2. Live coding: `ContaBancaria` no quadro — dois construtores, `depositar` / `sacar` / `transferir`, contador estático.
3. Mostre `this` nos três usos da disciplina.
4. Laboratório: `exercicios.md`.

## 1. Atributos de instância versus de classe

Cada objeto tem a **própria** cópia dos atributos de instância (`saldo`, `titulo`).

Um atributo `static` pertence à **classe**: há um só, compartilhado por todas as instâncias.

```java
static int totalDeContas = 0; // da classe
String numero;                // do objeto
double saldo;                 // do objeto
```

`ContaBancaria.totalDeContas` faz sentido. `ContaBancaria.saldo` não — saldo de *qual* conta?

## 2. Construtores

O construtor tem o **nome da classe** e **não tem tipo de retorno** (nem `void`). Roda no `new`.

```java
public Livro(String titulo, String autor, int ano) {
    this.titulo = titulo;
    this.autor = autor;
    this.ano = ano;
    this.emprestado = false;
}
```

- `this.titulo` é o atributo; `titulo` é o parâmetro.
- Se você declara qualquer construtor, o construtor **padrão** (sem argumentos) deixa de ser gerado. Se precisar dos dois, escreva os dois (**sobrecarga**).

```java
public Livro() {
    this("sem título", "desconhecido", 0); // encadeia outro construtor
}
```

`this(...)` deve ser a **primeira** instrução do construtor.

## 3. `this`

Três usos nesta disciplina:

1. Desambiguar atributo e parâmetro: `this.saldo = saldo;`
2. Encadear construtor: `this(numero, 0.0);`
3. Passar o próprio objeto: `historico.registrar(this);` (aula 05)

## 4. Métodos

Método de instância usa o estado **daquele** objeto. Não é `static` (salvo contadores/utilitários da classe).

```java
public boolean sacar(double valor) {
    if (valor <= 0 || valor > saldo) {
        return false;
    }
    saldo -= valor;
    return true;
}
```

- `void` não devolve valor.
- `return` encerra o método.
- Parâmetros primitivos são cópia do valor; objetos são cópia da **referência** (por isso `transferir` altera o destino).

`static` continua existindo para algoritmos sem objeto (aula 07, recursão). Não desaparece; só deixa de ser o jeito padrão de organizar o negócio.

## 5. Encapsulamento? Ainda não (de propósito)

Nesta aula os atributos podem ficar **sem** `private` para a turma ver o estado no `println`. Na aula 04 eles passam a `private` e o acesso vira método. Avise: “isso é didático e temporário”.

## 6. Onde fica o `main`?

Classe de modelo (`ContaBancaria`, `Livro`) **não** deve ler teclado nem imprimir o menu. O `main` (ou uma classe `Demo`) **cria** objetos, **chama** métodos e **mostra** resultados.

## O que executar no projetor

```bash
javac --release 25 aulas/03-atributos-construtores-metodos/src/*.java
java -cp aulas/03-atributos-construtores-metodos/src DemoAtributosMetodos
```

Mostre duas contas independentes, a transferência e o contador estático. Em seguida, duas referências para a **mesma** conta (`c2 = c1`) para o saque em `c2` alterar o saldo visto por `c1`.

## Ponte para a aula 04

“Qualquer um pode fazer `conta.saldo = -1000`. Como impedir?”
