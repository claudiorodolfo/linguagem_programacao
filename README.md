# Linguagem de Programação 1

Material didático da disciplina **Linguagem de Programação 1**, ministrada em **Java** para o Curso de **Sistemas de Informação** do **IFBA — Campus Vitória da Conquista**.

O repositório acompanha o cronograma da turma: cada pasta em `aulas/` corresponde a um encontro e reúne texto de apoio, código-fonte, exercícios e gabarito.

## Ementa

Recursividade. Programação orientada a objetos: abstração de dados; classes e objetos; herança; e polimorfismo. Interfaces e classes abstratas. Depuração de programas. Box e Unboxing. Boas práticas de programação.

## Como este repositório está organizado

| Pasta | Conteúdo |
| --- | --- |
| [`plano-de-ensino.md`](plano-de-ensino.md) | Objetivos, metodologia, avaliação e bibliografia |
| [`cronograma.md`](cronograma.md) | Encontros, datas e links para cada aula |
| [`aulas/`](aulas/) | Material de cada encontro, na ordem do cronograma |
| [`recursos/`](recursos/) | Ambiente, [Java 25](recursos/java25.md), convenções, referências e [guia do docente](recursos/guia-docente.md) |

Cada aula prática segue o mesmo padrão:

```
aulas/NN-tema/
  README.md        → objetivos, teoria e roteiro de aula
  exercicios.md    → lista para laboratório / casa
  gabarito.md      → resoluções (uso do docente)
  src/             → implementação Java comentada + classe Demo
```

As pastas de prova trazem instrumento proposto e gabarito.

## Unidades

1. **Fundamentos de POO e recursão** — revisão de lógica, classes e objetos, encapsulamento, relacionamentos, depuração e recursividade.
2. **Hierarquias e contratos** — herança, polimorfismo, interfaces, classes abstratas e exercícios integradores.
3. **Qualidade e tipos** — boas práticas, boxing/unboxing, classes wrapper e exercícios integradores.

## Como compilar e executar

Requisito: **JDK 25**. Instruções de instalação em [`recursos/ambiente.md`](recursos/ambiente.md). Sintaxe da linguagem em [`recursos/java25.md`](recursos/java25.md).

Cada aula é autocontida. A partir da raiz do repositório:

```bash
# Exemplo: aula de classes e objetos
javac --release 25 aulas/03-classes-objetos/src/*.java
java -cp aulas/03-classes-objetos/src DemoClassesObjetos
```

Quando a aula usa pacotes (`package ...`), compile a partir de `src/` e informe o pacote da classe principal:

```bash
# Exemplo: aula de encapsulamento
javac --release 25 -d aulas/04-encapsulamento-relacionamentos/out \
  $(find aulas/04-encapsulamento-relacionamentos/src -name "*.java")
java -cp aulas/04-encapsulamento-relacionamentos/out \
  br.edu.ifba.conquista.lp1.aula04.DemoRelacionamentos
```

Há um script na raiz para o caso simples (arquivos no mesmo diretório, sem pacote):

```bash
./compilar.sh aulas/03-classes-objetos DemoClassesObjetos
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
