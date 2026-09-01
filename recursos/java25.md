# Java 25 nesta disciplina

A linguagem-alvo é **Java 25** (LTS, setembro de 2025). Não usamos recursos em *preview* (`--enable-preview`). O que entra no quadro está abaixo; o restante (virtual threads, AOT, JFR…) fica para outras disciplinas.

## Rampa de entrada (JEP 512)

Três formas equivalentes de um “olá”:

```java
// 1. Arquivo compacto (aula 01, primeiros minutos)
void main() {
    IO.println("LP1 — IFBA Conquista");
}

// 2. Classe com main de instância (padrão das Demos daqui para frente)
public class OlaIfba {
    void main() {
        IO.println("LP1 — IFBA Conquista");
    }
}

// 3. Forma clássica (ainda aparece em livros e sistemas antigos)
public class OlaIfba {
    public static void main(String[] args) {
        System.out.println("LP1 — IFBA Conquista");
    }
}
```

A JVM, na forma 2, **cria um objeto** e chama `main()`. Isso antecipa a aula 02 sem exigir `new` no primeiro dia.

`java.lang.IO` (desde 25): `IO.println`, `IO.print`, `IO.readln()`, `IO.readln("prompt: ")`. Preferimos `IO` a `Scanner` + `System.out` para I/O de console. `Scanner` entra só como código legado (e no anti-padrão da aula 15).

Arquivos compactos importam o módulo `java.base` automaticamente (`List`, `ArrayList`, `BigDecimal`… sem `import`). Classes nomeadas continuam precisando de `import` — ou de `import module java.base;` (JEP 511), que mostramos na aula 04.

## Sintaxe que o material assume

| Recurso | Desde | Onde aparece |
| --- | --- | --- |
| Text blocks `"""` | 15 | menus, relatórios |
| `switch` expressão (`->`) | 14 | aula 01, calculadora |
| `record` | 16 | `Endereco` (aula 05); aula 15 |
| `instanceof Tipo x` | 16 | aula 09 em diante |
| Classes `sealed` | 17 | `Conta` na aula 10 |
| `switch` em hierarquia selada | 21 | aula 09/10 |
| Variável não usada `_` | 22 | `case ContaCorrente _` |
| `void main()` / arquivo compacto / `IO` | 25 | todas as Demos |
| Corpo flexível de construtor (código **antes** de `super(...)`) | 25 | aula 08 |

## O que **não** cobrimos (ainda preview ou fora da ementa)

- Padrões em tipos primitivos (JEP 507, preview no 25)
- Virtual threads, scoped values, structured concurrency
- `var` no quadro: evite no primeiro mês; tipos explícitos ensinam mais

## Remoções que quebram código antigo

Os construtores `new Integer(n)`, `new Double(n)` etc. foram **removidos**. Use `Integer.valueOf(n)` ou autoboxing. A aula 14 trata disso.

## Compilar na versão certa

```bash
java -version    # deve mostrar 25
javac --release 25 aulas/02-poo-classes-objetos/src/*.java
```
