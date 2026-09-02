# Programação orientada a objetos: classes e objetos

**Pré-requisito:** revisão de lógica

## Objetivos

- Contrastar o paradigma **procedural** (a revisão) com a **orientação a objetos**.
- Distinguir **classe** (molde) e **objeto** (instância).
- Usar `new` e entender **referência**, **estado** e **identidade**.
- Modelar um problema simples por abstração de dados.

Construtores, sobrecarga, `this` e métodos com regra de negócio ficam na aula de **atributos, construtores e métodos**. Encapsulamento (`private`) fica na aula de **encapsulamento e pacotes**.

## Roteiro

1. Do paradigma procedural ao OO: o `void main()` da aula de revisão de lógica já roda **num objeto** (a JVM instancia a Demo). Agora o comportamento de negócio mora em *outros* objetos (`Livro`) criados com `new`.
2. Live coding: classe `Livro` no quadro — atributos visíveis, um método simples, **sem** construtor declarado.
3. Desenhe na lousa: caixa do objeto (identidade + estado) e a classe ao lado.

## 1. Do procedural ao orientado a objetos

Na revisão, o programa *era* o `main`: variáveis soltas, métodos que recebem tudo por parâmetro.

Em POO, o programa **cria objetos** e **pede** que eles façam o trabalho.

| Procedural (revisão de lógica) | Orientado a objetos |
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

`a == b` compara **referências**. `a == c` é `false` mesmo com dados iguais. Igualdade de conteúdo entra depois (`equals`, herança).

## 4. Atributos e um primeiro método

Nesta aula os atributos ficam **sem** `private` e **sem** construtor declarado. Encapsulamento e construtores vêm nas aulas seguintes.

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

O construtor **padrão** (sem argumentos) é gerado pelo compilador enquanto você não declara nenhum. Na aula de atributos, construtores e métodos vocês passam a escrever construtores.

Método de instância usa o estado **daquele** objeto. Não é `static`. Chamada: `livro.emprestar()`.

## 5. Null

```java
Livro livro = null;
livro.emprestar(); // NullPointerException
```

Uma referência pode não apontar para ninguém: `NullPointerException`. A aula de depuração volta a isso.

## 6. Onde fica o `main`?

Classe de modelo (`Livro`) **não** deve ler teclado nem imprimir o menu. O `main` (ou uma classe `Demo`) **cria** objetos, **chama** métodos e **mostra** resultados.

## O que executar no projetor

```bash
javac --release 25 -d aulas/02-poo-classes-objetos/bin \
  $(find aulas/02-poo-classes-objetos/src -name "*.java")
java -cp aulas/02-poo-classes-objetos/bin br.edu.ifba.vdc.bsi.lp1.DemoClassesObjetos
```

O `DemoClassesObjetos` cria dois livros independentes e, em seguida, duas referências para o **mesmo** livro (`b = a`): o empréstimo via `b` altera o estado visto por `a`.

## Ponte para atributos, construtores e métodos

“Criar o objeto e depois preencher campo a campo é frágil: alguém esquece o título. Como **obrigar** a inicialização e reunir o comportamento (depositar, sacar) no objeto?”
