# Java 25 nesta disciplina

A linguagem-alvo é **Java 25** (LTS, setembro de 2025). Não usamos recursos em *preview* (`--enable-preview`). O que entra no quadro está abaixo; o restante (virtual threads, AOT, JFR…) fica para outras disciplinas.

## Rampa de entrada (JEP 512)

Três formas equivalentes de um “olá”:

```java
// 1. Arquivo compacto (revisão de lógica, primeiro contato)
void main() {
    IO.println("LP1 — IFBA Conquista");
}

// 2. Classe com main de instância no pacote da disciplina
package br.edu.ifba.vdc.bsi.lp1;

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

A JVM, na forma 2, **cria um objeto** e chama `main()`. Isso antecipa a aula de classes e objetos sem exigir `new` no primeiro dia.

`java.lang.IO` (desde 25): `IO.println`, `IO.print`, `IO.readln()`, `IO.readln("prompt: ")`. Preferimos `IO` a `Scanner` + `System.out` para I/O de console. `Scanner` entra só como código legado (e no anti-padrão da aula de boas práticas).

Arquivos compactos importam o módulo `java.base` automaticamente (`List`, `ArrayList`, `BigDecimal`… sem `import`). Classes nomeadas continuam precisando de `import` — ou de `import module java.base;` (JEP 511), que mostramos na aula de encapsulamento e pacotes.

## Sintaxe que o material assume

| Recurso | Desde | Onde aparece |
| --- | --- | --- |
| Text blocks `"""` | 15 | menus, relatórios |
| `switch` expressão (`->`) | 14 | revisão de lógica, calculadora |
| `record` | 16 | `Endereco` (relacionamentos); boas práticas |
| `instanceof Tipo x` | 16 | polimorfismo em diante |
| Classes `sealed` | 17 | `Conta` na aula de interfaces e classes abstratas |
| `switch` em hierarquia selada | 21 | polimorfismo e interfaces |
| Variável não usada `_` | 22 | `case ContaCorrente _` |
| `void main()` / arquivo compacto / `IO` | 25 | todas as Demos |
| Corpo flexível de construtor (código **antes** de `super(...)`) | 25 | herança |

## O que **não** cobrimos (ainda preview ou fora da ementa)

- Padrões em tipos primitivos (JEP 507, preview no 25)
- Virtual threads, scoped values, structured concurrency
- `var`: fora do padrão desta disciplina; tipos explícitos

## Remoções que quebram código antigo

Os construtores `new Integer(n)`, `new Double(n)` etc. foram **removidos**. Use `Integer.valueOf(n)` ou autoboxing. A aula de boxing e wrappers trata disso.

## Compilar na versão certa

```bash
java -version    # deve mostrar 25
javac --release 25 -d aulas/02-poo-classes-objetos/bin \
  $(find aulas/02-poo-classes-objetos/src -name "*.java")
```
