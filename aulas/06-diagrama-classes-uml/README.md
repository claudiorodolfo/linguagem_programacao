# Diagrama de classes UML

**Unidade:** 1  
**Pré-requisito:** relacionamentos

## Objetivos

- Ler e desenhar um **diagrama de classes** UML no nível desta disciplina.
- Representar classe, atributos, métodos e visibilidade (`+` `-` `#` `~`).
- Desenhar **associação**, **agregação**, **composição** e **multiplicidade** (cardinalidade).
- Usar **classe associativa** para N–N.
- Traduzir o diagrama para Java (campo, arranjo, `new` interno) e o Java de volta para o diagrama.

Generalização (`extends`) aparece como **spoiler de uma linha**: o triângulo vazio volta na aula de herança. Interfaces (`«interface»`) voltam na aula de interfaces e classes abstratas.

## Roteiro

1. Reabra o desenho da aula de relacionamentos (caixas `Usuario`, `Emprestimo`, `Livro`, `Endereco`). Diga: “hoje isso vira UML de verdade, a língua em que vocês vão documentar o projeto o resto da graduação.”
2. Notação da caixa (nome / atributos / métodos) e visibilidade no quadro.
3. Losango vazio vs. preenchido; números `1`, `0..1`, `1..*`.
4. Live coding: `DemoUml` — cada linha do diagrama vira um campo Java.
5. Laboratório: `exercicios.md` (papel + código).

A prova da Unidade 1 cobra este diagrama.

## 1. Para que serve

O diagrama de classes mostra **a estrutura**: que tipos existem, o que guardam, o que fazem e como se relacionam. Não mostra o `if` do saque nem o laço do `main`.

Nesta disciplina ele é o mapa da biblioteca e da conta — o mesmo vocabulário da aula de relacionamentos, com uma grafia padronizada.

## 2. A caixa da classe

Três compartimentos:

```
┌─────────────────────┐
│      Usuario        │  ← nome (substantivo, PascalCase)
├─────────────────────┤
│ − nome: String      │  ← atributos
│ − matricula: String │
│ − endereco: Endereco│
├─────────────────────┤
│ + registrar(e): boolean │  ← métodos
│ + cidadeFormatada(): String │
└─────────────────────┘
```

Visibilidade (bate com a aula de encapsulamento e pacotes):

| UML | Java |
| --- | --- |
| `+` | `public` |
| `−` | `private` |
| `#` | `protected` (herança) |
| `~` | package-private (nenhum modificador) |

Tipos depois de `:` — como no Java, só na ordem invertida: `nome: String` ≡ `String nome`.

Construtor pode aparecer como `+ Usuario(nome: String, …)` ou ficar implícito no laboratório. `static` (da classe) sublinha-se: `totalDeContas`.

`record` (`Endereco`): desenhe como classe com estereótipo `«record»` ou como classe normal imutável. Não invente notação extra.

## 3. Relacionamentos no diagrama

| Ideia (relacionamentos) | Traço UML | Lembrete |
| --- | --- | --- |
| Associação | linha (seta opcional = navegabilidade) | “conhece” |
| Agregação | losango **vazio** na parte que “tem” | todo–parte frouxo |
| Composição | losango **preenchido** na parte que “tem” | ciclo de vida acoplado |
| Classe associativa | classe ligada por linha tracejada ao traço | `Emprestimo`, `Matricula` |

Multiplicidade (cardinalidade) em **cada ponta**:

| UML | Leitura |
| --- | --- |
| `1` | exatamente um |
| `0..1` | no máximo um |
| `0..*` ou `*` | zero ou mais |
| `1..*` | um ou mais |
| `0..5` | no máximo cinco (o `MAX_EMPRESTIMOS` da aula de relacionamentos) |

## 4. O diagrama da biblioteca (quadro)

```
                    1          0..5
┌─────────┐  ◇────────────────────────────┐
│ Usuario │                               │
└─────────┘                               ▼
      │ 1                          ┌────────────┐          1     1  ┌───────┐
      │                            │ Emprestimo │─────────────────▶│ Livro │
      │ composição                 └────────────┘                  └───────┘
      │ losango cheio
      ▼ 1
┌──────────┐
│ Endereco │  «record»
└──────────┘
```

Leitura: um usuário **compõe** um endereço; um usuário **associa-se** a até cinco empréstimos; cada empréstimo **associa-se** a um livro. O livro não morre se o empréstimo acaba — por isso não há losango cheio em `Livro`.

`Emprestimo` como classe no meio do traço Usuario–Livro (classe associativa) é a forma “de livro”; a implementação da aula de relacionamentos (objeto `Emprestimo` com duas referências) é a mesma ideia.

## 5. Do diagrama para o Java

| No diagrama | No código |
| --- | --- |
| `Usuario 1 — 1 Endereco` (composição) | campo `private Endereco endereco` criado no construtor do usuário (`new Endereco(...)`) |
| `Usuario 1 — 0..5 Emprestimo` | `Emprestimo[]` + `quantidade` (ou lista, depois) |
| `Emprestimo — 1 Livro` | campo `private Livro livro` |
| atributo `− saldo: double` | `private double saldo;` |
| `+ sacar(valor: double): boolean` | `public boolean sacar(double valor)` |

Navegabilidade: se a seta aponta só para `Livro`, `Emprestimo` tem o campo; `Livro` **não** precisa da lista de empréstimos. A aula de relacionamentos fez exatamente isso.

Lei de Demeter no desenho: não exponha `Endereco` no `main` se o diagrama já tem `cidadeFormatada()` em `Usuario`.

## 6. O que ainda não desenhar (de propósito)

- Generalização (triângulo vazio, `extends`) — herança.
- `«interface»` e `«abstract»` — interfaces e classes abstratas.
- Sequência, casos de uso, pacotes UML completos — fora desta ementa. Pacote Java continua sendo pasta + `package`.

Se alguém perguntar “é UML 2.5?”: usamos o **subconjunto** que cabe no quadro e cai em prova. Não cobramos ferramenta CASE.

## O que executar no projetor

```bash
javac --release 25 aulas/06-diagrama-classes-uml/src/*.java
java -cp aulas/06-diagrama-classes-uml/src DemoUml
```

Percorra `DemoUml` com o diagrama da seção 4 aberto. O arquivo `biblioteca.puml` é opcional (PlantUML) para quem quiser gerar a figura em casa; a prova é no **papel**.

## Ponte para a prova da Unidade 1

A Unidade 1 cobra a revisão até o diagrama de classes UML: revisão, classes, atributos/métodos, encapsulamento/pacotes, relacionamentos **e** o diagrama de classes (ler, completar, traduzir para Java). Instrumento na pasta `prova-unidade-1`.
