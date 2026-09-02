# Boxing, unboxing e classes wrapper

**Pré-requisito:** tipos primitivos (revisão de lógica), objetos (classes e objetos) e depuração

## Objetivos

- Relacionar cada primitivo ao seu **wrapper**.
- Explicar **boxing** (primitivo → objeto) e **unboxing** (objeto → primitivo), inclusive o automático.
- Usar `parse*`, `valueOf`, `compare` e constantes (`MAX_VALUE`).
- Entender o cache de `Integer` (−128 a 127) e por que `==` mente.
- Prever `NullPointerException` no unboxing de referência `null`.
- Saber por que coleções (`ArrayList`) guardam wrappers, não `int`.

## Roteiro

1. No quadro: `int n = 7;` versus `Integer n = Integer.valueOf(7);`.
2. Live coding de `DemoWrappers`: autoboxing em atribuição e em `ArrayList<Integer>`.
3. A armadilha `Integer a = 127; Integer b = 127; a == b` versus 128.
4. `Integer x = null; int y = x;` no depurador (aula de depuração).
5. Laboratório.

## 1. Tabela de correspondência

| Primitivo | Wrapper |
| --- | --- |
| `boolean` | `Boolean` |
| `char` | `Character` |
| `byte` | `Byte` |
| `short` | `Short` |
| `int` | `Integer` |
| `long` | `Long` |
| `float` | `Float` |
| `double` | `Double` |
| `void` | `Void` (raro; só cite) |

Wrappers estão em `java.lang` (não precisam de `import`). São **imutáveis**: “mudar” um `Integer` é criar outro.

## 2. Para que existem

1. **Coleções e genéricos** só trabalham com objetos: `ArrayList<int>` não compila; `ArrayList<Integer>` sim.
2. **Ausência de valor:** um `int` sempre tem bit pattern; `Integer` pode ser `null` (“não informado”).
3. **Métodos de serviço:** `Integer.parseInt("42")`, `Double.isNaN`, `Character.isDigit`.
4. **Uso em APIs** que pedem `Object` (chaves de mapa, reflexão).

## 3. Boxing e unboxing

**Boxing:** empacotar o primitivo no objeto.

```java
Integer caixa = Integer.valueOf(10); // explícito — new Integer(n) foi REMOVIDO da API
Integer auto = 10;                   // autoboxing: o compilador chama valueOf
```

**Unboxing:** extrair o primitivo.

```java
int n = caixa.intValue();
int autoN = caixa; // unboxing automático
```

Aritmética desempacota, calcula, (às vezes) reempacota:

```java
Integer a = 3;
Integer b = 4;
Integer c = a + b; // unbox, soma, box
```

Isso cria objetos e, com `null`, explode.

## 4. `parse` versus `valueOf`

| Método | Devolve | Uso |
| --- | --- | --- |
| `Integer.parseInt("12")` | `int` | converter texto → primitivo |
| `Integer.valueOf("12")` | `Integer` | texto → wrapper |
| `Integer.valueOf(12)` | `Integer` | primitivo → wrapper (com cache) |
| `String.valueOf(12)` | `String` | o inverso mais comum para imprimir |

`parseInt` lança `NumberFormatException` se o texto for `"doze"` ou vazio. Não capture vazia: avise o usuário.

`new Integer(12)` **não existe mais** (removido após anos de depreciação). Use `valueOf` ou autoboxing. Código de livro antigo com `new Integer` **não compila** no JDK 25.

## 5. O cache (−128 … 127)

A JLS garante que `valueOf` (e portanto o autoboxing) **reutiliza** instâncias de `Integer` nesse intervalo.

```java
Integer a = 127;
Integer b = 127;
System.out.println(a == b);      // true (mesma instância)
Integer c = 128;
Integer d = 128;
System.out.println(c == d);      // false (objetos distintos)
System.out.println(c.equals(d)); // true
```

**Regra da disciplina:** compare wrappers com `equals` (ou `intValue()` dos dois lados). Nunca `==` para saber se o **número** é o mesmo.

O mesmo vale, com detalhes diferentes, para `Boolean`, `Byte`, `Short`, `Character` e `Long` no intervalo cacheado.

## 6. NPE de unboxing

```java
Integer idade = null; // “não informado”
int x = idade;        // NullPointerException
```

O compilador gera `idade.intValue()`. No depurador o NPE aparece nessa chamada.

Cuidado em expressões:

```java
Integer a = null;
Integer b = 2;
Integer s = a + b; // NPE
```

E em comparadores: `a < 3` unboxa `a`.

Quando a nota pode faltar, **mantenha** `Integer` e teste `== null` antes de unboxar. Não use `int` se o domínio precisa de “desconhecido”.

## 7. `ArrayList` (o suficiente para wrappers)

```java
import java.util.ArrayList;

ArrayList<Integer> notas = new ArrayList<Integer>();
notas.add(7);           // boxing
int primeira = notas.get(0); // unboxing
```

Não é aula de estruturas de dados. É o **motivo** pelo qual wrappers existem na ementa.

`int` em arranjo `int[]` **não** usa wrapper. Escolha: sequência fixa e primitiva → vetor; lista variável de objetos → `ArrayList`.

## 8. Outros métodos que caem em exercício

```java
Integer.compare(3, 10);          // negativo se o primeiro for menor
Math.max(3, 10);                 // primitivos
Double.parseDouble("3.14");
Boolean.parseBoolean("true");    // true só para a string "true" (ignore case)
Character.isLetter('A');
Character.isDigit('8');
Integer.MAX_VALUE;               // 2^31 - 1
Integer.MIN_VALUE;
```

Overflow de `int` (revisão de lógica) continua existindo com wrapper: `Integer.MAX_VALUE + 1` unboxa, estoura, reboxa.

## O que executar no projetor

```bash
javac --release 25 -d aulas/15-boxing-unboxing/out \
  $(find aulas/15-boxing-unboxing/src -name "*.java")
java -cp aulas/15-boxing-unboxing/out br.edu.ifba.vdc.bsi.lp1.DemoWrappers
```

Comente/descomente o bloco `explodirNpe()` na hora. Não deixe a JVM morrer no começo da demo.

## Ponte para boas práticas

Código que “funciona” ainda pode ser hostil: nomes ruins, `catch` vazio, `setSaldo`. A aula de boas práticas fecha a ementa de conteúdo novo. O laboratório integrador (aula de integradores da disciplina) e a prova da Unidade 3 vêm na sequência.
