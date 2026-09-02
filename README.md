# Linguagem de Programação 1

Material didático da disciplina **Linguagem de Programação 1**, ministrada em **Java** para o Curso de **Sistemas de Informação** do **IFBA — Campus Vitória da Conquista**.

O repositório acompanha o cronograma da turma: cada pasta em `aulas/` corresponde a um encontro (ou a um laboratório dirigido) e reúne texto de apoio, código-fonte, exercícios e gabarito.

## Ementa

Revisão de lógica de programação. Programação orientada a objetos: classes e objetos; atributos, construtores e métodos; encapsulamento, modificadores de acesso e pacotes; cardinalidade e relacionamento entre objetos; diagrama de classes UML. Recursividade. Herança. Polimorfismo. Interfaces e classes abstratas. Depuração de programas. Boxing e unboxing; classes wrapper. Boas práticas de programação.

## Como este repositório está organizado

| Pasta | Conteúdo |
| --- | --- |
| [`plano-de-ensino.md`](plano-de-ensino.md) | Objetivos, metodologia, avaliação e bibliografia |
| [`cronograma.md`](cronograma.md) | Ordem sugerida dos encontros e links para cada aula |
| [`aulas/`](aulas/) | Material de cada encontro, na ordem do cronograma |
| [`recursos/`](recursos/) | Ambiente, [Java 25](recursos/java25.md), convenções, referências e [guia do docente](recursos/guia-docente.md) |

Cada aula prática segue o mesmo padrão:

```
aulas/<assunto>/
  README.md        → objetivos, teoria e roteiro de aula
  exercicios.md    → lista para laboratório / casa
  gabarito.md      → resoluções (uso do docente)
  src/br/edu/ifba/vdc/bsi/lp1/  → Java + Demo (pacote `br.edu.ifba.vdc.bsi.lp1`)
```

O prefixo numérico nas pastas (quando houver) só ordena a listagem no disco. O identificador estável é o **assunto** (`recursividade`, `heranca`, `classes-interna-externa`…).

As pastas de prova trazem instrumento proposto e gabarito.

## Unidades

1. **Fundamentos de POO** — revisão de lógica, classes e objetos, atributos/construtores/métodos, encapsulamento, relacionamentos e diagrama de classes UML.
2. **Recursão, hierarquias e contratos** — recursividade, herança, polimorfismo, interfaces, classes abstratas e exercícios integradores de POO.
3. **Qualidade e tipos** — depuração, boxing/unboxing, wrappers, boas práticas e exercícios integradores.

## Como compilar e executar

Requisito: **JDK 25**. Instruções de instalação em [`recursos/ambiente.md`](recursos/ambiente.md). Sintaxe da linguagem em [`recursos/java25.md`](recursos/java25.md).

Cada aula é autocontida. Os fontes ficam em `src/br/edu/ifba/vdc/bsi/lp1/` (pacote `br.edu.ifba.vdc.bsi.lp1`). A partir da raiz do repositório:

```bash
# Exemplo: aula de classes e objetos
javac --release 25 -d aulas/02-poo-classes-objetos/out \
  $(find aulas/02-poo-classes-objetos/src -name "*.java")
java -cp aulas/02-poo-classes-objetos/out br.edu.ifba.vdc.bsi.lp1.DemoClassesObjetos
```

A aula de encapsulamento também usa o subpacote `br.edu.ifba.vdc.bsi.lp1.modelo`. O comando é o mesmo (`find` no `src/`).

Há um script na raiz:

```bash
./compilar.sh aulas/02-poo-classes-objetos DemoClassesObjetos
```

No Windows, troque `:` por `;` no classpath.

## Convenções de código

- Nomes de **classes** e **métodos** em português quando o domínio for didático (`ContaBancaria`, `sacar`, `depositar`).
- Palavras reservadas e API Java permanecem em inglês (`toString`, `equals`, `ArrayList`).
- Ponto de entrada: `void main()` e `IO.println` / `IO.readln` (Java 25). A forma `public static void main` aparece como legado.
- Comentários e Javadoc em português.
- Cada aula termina com uma classe `Demo...` que o docente pode executar no projetor.

## Público e uso

Material de apoio ao docente e aos estudantes da disciplina. Os gabaritos destinam-se ao professor: publique-os somente depois da atividade correspondente, se desejar.

## Docente e instituição

- **Disciplina:** Linguagem de Programação 1
- **Curso:** Sistemas de Informação
- **Instituição:** IFBA — Campus Vitória da Conquista
- **Linguagem:** Java 25 (LTS)
