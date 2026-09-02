# Apresentação da disciplina e revisão de lógica

## Objetivos

- Apresentar ementa, cronograma, avaliação e o repositório da disciplina.
- Reativar tipos, operadores, decisões, laços, arranjos e métodos em Java.
- Compilar e executar com `void main()`, `IO` (Java 25) e o pacote `br.edu.ifba.vdc.bsi.lp1`.

## Roteiro

1. Leitura rápida do [`plano-de-ensino.md`](../../plano-de-ensino.md) e do [`cronograma.md`](../../cronograma.md).
2. Instalação conferida: `java -version` deve mostrar **25** ([`recursos/ambiente.md`](../../recursos/ambiente.md)).
3. Revisão guiada com `OlaIfba` e depois `DemoRevisao`.

## 1. O que esta disciplina não é

Não é “introdução à lógica do zero”. Espera-se que a turma já tenha visto variáveis, `if`, `for` e vetores. O que muda:

- a linguagem de trabalho é **Java 25**;
- o foco passa a ser **modelar com objetos**;
- a qualidade do código (nomes, visibilidade, depuração) entra na nota.

Quem estiver enferrujado usa esta aula como ponte.

## 2. Anatomia de um programa Java 25

Comece **sem** classe visível (arquivo compacto — JEP 512):

```java
void main() {
    IO.println("LP1 — IFBA Conquista");
}
```

```bash
java OlaIfba.java     # source-file mode: nem precisa javac no primeiro dia
```

Arquivo compacto **não** declara `package` (JEP 512). O `OlaIfba.java` do repositório é a forma nomeada abaixo.

O compilador declara uma classe implícita. Não é outro Java: é o mesmo programa, com a classe escondida.

Em seguida a forma que usaremos o semestre inteiro (classe nomeada no pacote da disciplina):

```java
package br.edu.ifba.vdc.bsi.lp1;

public class OlaIfba {
    void main() {
        IO.println("LP1 — IFBA Conquista");
    }
}
```

- O arquivo público tem o **mesmo nome** da classe (`OlaIfba.java`).
- `void main()` é o ponto de entrada. A JVM **instancia** a classe e chama o método — já é um objeto, mesmo sem `new` no texto.
- `IO.println` escreve uma linha (`java.lang.IO`, desde o 25). `System.out.println` continua válido; na disciplina preferimos `IO`.

Forma clássica (livros antigos, projetos corporativos):

```java
public static void main(String[] args) { ... }
```

Ainda existe; não é o ponto de entrada desta disciplina.

## 3. Tipos primitivos

| Tipo | Tamanho típico | Uso didático |
| --- | --- | --- |
| `boolean` | verdadeiro/falso | flags, condições |
| `char` | 16 bits (Unicode) | um caractere `'A'` |
| `byte`, `short`, `int`, `long` | inteiros | contadores, índices |
| `float`, `double` | ponto flutuante | dinheiro *nesta disciplina* use `double` com cuidado; em sistema real, `BigDecimal` |

```java
int quantidade = 3;
double media = 8.5;
boolean aprovado = media >= 7.0;
char conceito = 'B';
```

**String não é primitivo.** É uma classe: `String nome = "Ana";`

Tipos **explícitos**. `var` existe; não é o padrão desta disciplina.

## 4. Operadores

- Aritméticos: `+ - * / %`
- Relacionais: `== != < > <= >=`
- Lógicos: `&& || !`
- Atribuição: `= += -= ++ --`

Armadilha clássica: divisão inteira.

```java
int a = 5, b = 2;
IO.println(a / b);             // 2
IO.println(a / (double) b);    // 2.5
```

## 5. Decisão

```java
if (media >= 7.0) {
    IO.println("Aprovado");
} else if (media >= 5.0) {
    IO.println("Recuperação");
} else {
    IO.println("Reprovado");
}
```

`switch` **expressão** (forma da disciplina — sem `break`, sem fall-through):

```java
String msg = switch (conceito) {
    case 'A', 'B' -> "Bom desempenho";
    case 'C' -> "Regular";
    default -> "Verificar";
};
IO.println(msg);
```

A forma antiga com `:` e `break` ainda compila; o fall-through sem `break` é uma armadilha clássica. Os exercícios usam a forma expressão.

Bloco com `yield` quando o ramo tem mais de uma instrução:

```java
double resultado = switch (opcao) {
    case 4 -> {
        if (b == 0) {
            IO.println("Divisão por zero");
            yield 0.0;
        }
        yield a / b;
    }
    default -> 0.0;
};
```

## 6. Laços

```java
for (int i = 0; i < n; i++) { ... }
while (saldo < meta) { ... }
do {
    // ler opção
} while (opcao != 0);
```

`break` sai do laço; `continue` vai para a próxima iteração.

## 7. Arranjos (vetores)

```java
int[] notas = {7, 8, 9};
int[] vazias = new int[3]; // {0, 0, 0}

for (int i = 0; i < notas.length; i++) {
    IO.println(notas[i]);
}

for (int nota : notas) {
    IO.println(nota);
}
```

Índices de `0` a `length - 1`. `notas[3]` lança `ArrayIndexOutOfBoundsException`.

## 8. Métodos (ainda sem `new`)

Com `void main()` de instância, os métodos da Demo **também** podem ser de instância — não precisam de `static`. Na revisão isso é “função da classe”:

```java
double media(double a, double b) {
    return (a + b) / 2.0;
}
```

- `void` não devolve valor.
- `return` encerra o método.
- Parâmetros primitivos são cópia do valor; `String` é referência.

`static` continua existindo (algoritmos sem objeto, como na aula de recursividade). Não desaparece; só deixa de ser obrigatório no `main`.

## 9. Entrada com `IO.readln`

```java
String nome = IO.readln("Nome: ");
double nota = Double.parseDouble(IO.readln("Nota: "));
```

Tudo é **linha de texto**. Não há a armadilha clássica do `Scanner.nextInt()` + `nextLine()`. `NumberFormatException` se a conversão falhar.

`Scanner` ainda existe. Na disciplina: código legado / boas práticas (anti-padrão). Não misture `IO.readln` e `Scanner` no mesmo `System.in`.

## 10. Erros que a revisão deve mostrar ao vivo

| Sintoma | Causa típica |
| --- | --- |
| `cannot find symbol` | nome errado, arquivo não compilado, ou JDK &lt; 25 (`IO` / `void main`) |
| `class ... should be declared in a file named` | nome da classe ≠ nome do arquivo |
| divisão sempre zero ou inteira | `int / int` |
| laço infinito | condição que nunca muda |
| `NumberFormatException` | `parseInt` / `parseDouble` recebeu texto |

## O que executar no projetor

```bash
javac --release 25 -d aulas/01-revisao-logica/out \
  $(find aulas/01-revisao-logica/src -name "*.java")
java -cp aulas/01-revisao-logica/out br.edu.ifba.vdc.bsi.lp1.OlaIfba
java -cp aulas/01-revisao-logica/out br.edu.ifba.vdc.bsi.lp1.DemoRevisao
```

Percorra `DemoRevisao`. Depois a `CalculadoraConsole` (menu em *text block* + `switch` expressão).

## Para a aula de classes e objetos

Na aula de classes e objetos o `main` deixa de ser o “programa inteiro”: ele **cria** outros objetos com `new`.
