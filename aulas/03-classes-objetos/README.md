# Aula 03 — Classes e objetos

**Data:** 17/08  
**Unidade:** 1  
**Pré-requisito:** aula 02

## Objetivos

- Distinguir **classe** (molde) e **objeto** (instância).
- Declarar atributos, construtores e métodos de instância.
- Usar `new`, `this` e referências.
- Modelar um problema simples por abstração de dados.

## Roteiro

1. Do paradigma procedural ao OO (15 min): o `void main()` da aula 02 já roda **num objeto** (a JVM instancia a Demo). Agora o comportamento de negócio mora em *outros* objetos (`Livro`, `ContaBancaria`) criados com `new`.
2. Live coding: `Livro` e `ContaBancaria` no quadro, depois conferir `src/`.
3. Desenhe na lousa: caixa do objeto (identidade + estado) e a classe ao lado.
4. Laboratório: `exercicios.md`.

## 1. Abstração de dados

Abstrair é **escolher** o que importa para o problema e **esconder** o resto.

Para a biblioteca do campus, um livro *é* título, autor, ano e disponibilidade — não é o tipo de papel. Para o caixa, uma conta *é* número e saldo — não é o prédio do banco.

A **classe** descreve o conjunto de objetos com a mesma estrutura e o mesmo vocabulário de operações.

## 2. Classe, objeto, referência

```java
Livro a = new Livro("Clean Code", "Robert Martin", 2008);
Livro b = a;           // b aponta para o MESMO objeto
Livro c = new Livro("Clean Code", "Robert Martin", 2008); // outro objeto
```

| Conceito | Significado |
| --- | --- |
| Classe | Definição (`Livro.java`) |
| Objeto | Instância criada com `new` |
| Referência | Variável que aponta para o objeto (`a`, `b`) |
| Estado | Valores atuais dos atributos |
| Identidade | O objeto em si (mesmo que dois livros tenham o mesmo título) |

`a == b` compara **referências**. `a == c` é `false` mesmo com dados iguais. Igualdade de conteúdo entra depois (`equals`, aula 08).

## 3. Atributos e métodos de instância

```java
public class Livro {
    String titulo;
    String autor;
    int ano;
    boolean emprestado;

    void emprestar() {
        emprestado = true;
    }
}
```

Método de instância usa o estado **daquele** objeto. Não é `static`. Chamada:

```java
Livro livro = new Livro();
livro.titulo = "Clean Code";
livro.emprestar();
```

## 4. Construtores

O construtor tem o **nome da classe** e **não tem tipo de retorno** (nem `void`).

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

## 5. `this`

Três usos nesta disciplina:

1. Desambiguar atributo e parâmetro: `this.saldo = saldo;`
2. Encadear construtor: `this(numero, 0.0);`
3. Passar o próprio objeto: `historico.registrar(this);` (aula 04)

## 6. Encapsulamento? Ainda não (de propósito)

Nesta aula os atributos podem ficar **sem** `private` para a turma ver o estado no depurador e no `println`. Na aula 04 eles passam a `private` e o acesso vira método. Avise: “isso é didático e temporário”.

## 7. Null

```java
Livro livro = null;
livro.emprestar(); // NullPointerException
```

Uma referência pode não apontar para ninguém. Sempre mostre o NPE **antes** da aula de debug: é o erro mais comum do semestre.

## 8. Onde fica o `main`?

Classe de modelo (`ContaBancaria`, `Livro`) **não** deve ler teclado nem imprimir o menu. O `main` (ou uma classe `Demo`) **cria** objetos, **chama** métodos e **mostra** resultados.

Isso é o primeiro hábito de boa prática da disciplina.

## O que executar no projetor

```bash
javac aulas/03-classes-objetos/src/*.java
java -cp aulas/03-classes-objetos/src DemoClassesObjetos
```

Mostre duas contas independentes e, em seguida, duas referências para a **mesma** conta (`c2 = c1`) para o saque em `c2` alterar o saldo visto por `c1`.

## Ponte para a aula 04

“Qualquer um pode fazer `conta.saldo = -1000`. Como impedir?”
