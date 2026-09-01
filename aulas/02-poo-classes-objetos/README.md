# Aula 02 — Programação orientada a objetos: classes e objetos

**Data:** 17/08  
**Unidade:** 1  
**Pré-requisito:** aula 01

## Objetivos

- Contrastar o paradigma **procedural** (a revisão) com a **orientação a objetos**.
- Distinguir **classe** (molde) e **objeto** (instância).
- Usar `new` e entender **referência**, **estado** e **identidade**.
- Modelar um problema simples por abstração de dados.

Construtores, sobrecarga, `this` e métodos com regra de negócio ficam na **aula 03**. Encapsulamento (`private`) fica na **aula 04**.

## Roteiro

1. Do paradigma procedural ao OO (15 min): o `void main()` da aula 01 já roda **num objeto** (a JVM instancia a Demo). Agora o comportamento de negócio mora em *outros* objetos (`Livro`) criados com `new`.
2. Live coding: classe `Livro` no quadro — atributos visíveis, um método simples, **sem** construtor declarado.
3. Desenhe na lousa: caixa do objeto (identidade + estado) e a classe ao lado.
4. Laboratório: `exercicios.md`.

## 1. Do procedural ao orientado a objetos

Na revisão, o programa *era* o `main`: variáveis soltas, métodos que recebem tudo por parâmetro.

Em POO, o programa **cria objetos** e **pede** que eles façam o trabalho.

| Procedural (aula 01) | Orientado a objetos |
| --- | --- |
| `emprestarLivro(titulo, emprestado)` | `livro.emprestar()` |
| dados e regras espalhados no `main` | dados e regras no próprio objeto |
| um vetor de títulos + um vetor de flags | vários objetos `Livro`, cada um com seu estado |

A **classe** descreve o conjunto de objetos com a mesma estrutura e o mesmo vocabulário de operações.

## 2. Abstração de dados

Abstrair é **escolher** o que importa para o problema e **esconder** o resto.

Para a biblioteca do campus, um livro *é* título, autor e disponibilidade — não é o tipo de papel. Para o caixa, uma conta *é* número e saldo — não é o prédio do banco.

## 3. Classe, objeto, referência

```java
Livro a = new Livro();
a.titulo = "Clean Code";
a.autor = "Robert Martin";

Livro b = a;           // b aponta para o MESMO objeto
Livro c = new Livro(); // outro objeto
c.titulo = "Clean Code";
c.autor = "Robert Martin";
```

| Conceito | Significado |
| --- | --- |
| Classe | Definição (`Livro.java`) |
| Objeto | Instância criada com `new` |
| Referência | Variável que aponta para o objeto (`a`, `b`) |
| Estado | Valores atuais dos atributos |
| Identidade | O objeto em si (mesmo que dois livros tenham o mesmo título) |

`a == b` compara **referências**. `a == c` é `false` mesmo com dados iguais. Igualdade de conteúdo entra depois (`equals`, aula 08).

## 4. Atributos e um primeiro método

Nesta aula os atributos ficam **sem** `private` e **sem** construtor declarado — para a turma ver o estado nascer com `new` e ser preenchido campo a campo. Isso é didático e temporário.

```java
public class Livro {
    String titulo;
    String autor;
    boolean emprestado;

    void emprestar() {
        emprestado = true;
    }
}
```

```java
Livro livro = new Livro();
livro.titulo = "Clean Code";
livro.emprestar();
```

O construtor **padrão** (sem argumentos) é gerado pelo compilador enquanto você não declara nenhum. Na aula 03 vocês passam a escrever construtores.

Método de instância usa o estado **daquele** objeto. Não é `static`. Chamada: `livro.emprestar()`.

## 5. Null

```java
Livro livro = null;
livro.emprestar(); // NullPointerException
```

Uma referência pode não apontar para ninguém. Mostre o NPE **cedo**: é o erro mais comum do semestre. A aula 13 (depuração) volta a ele com o depurador.

## 6. Onde fica o `main`?

Classe de modelo (`Livro`) **não** deve ler teclado nem imprimir o menu. O `main` (ou uma classe `Demo`) **cria** objetos, **chama** métodos e **mostra** resultados.

Isso é o primeiro hábito de boa prática da disciplina.

## O que executar no projetor

```bash
javac --release 25 aulas/02-poo-classes-objetos/src/*.java
java -cp aulas/02-poo-classes-objetos/src DemoClassesObjetos
```

Mostre dois livros independentes e, em seguida, duas referências para o **mesmo** livro (`b = a`) para o empréstimo via `b` alterar o estado visto por `a`.

## Ponte para a aula 03

“Criar o objeto e depois preencher campo a campo é frágil: alguém esquece o título. Como **obrigar** a inicialização e reunir o comportamento (depositar, sacar) no objeto?”
