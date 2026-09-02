# Cardinalidade e relacionamento entre objetos

**Pré-requisito:** encapsulamento e pacotes

## Objetivos

- Identificar **associação**, **agregação** e **composição**.
- Expressar cardinalidade **1–1**, **1–N** e **N–N** (esta última via classe associativa).
- Implementar relacionamento como **referência** ou **arranjo de referências**.
- Aplicar uma versão leve da Lei de Demeter: não espalhar a estrutura interna.

A aula de diagrama de classes UML formaliza o desenho.

## Roteiro

1. Recapitule encapsulamento: saldo `private`, sem `setSaldo`.
2. Esboce no quadro: `Usuario` 1 — N `Emprestimo` N — 1 `Livro`; `Usuario` 1 — 1 `Endereco`. A grafia UML (losango, `0..5`) fica na aula de diagrama de classes UML.
3. Execute `DemoRelacionamentos` (usa pacotes).

## 1. Relacionamentos

Fale em português antes de UML.

| Relacionamento | Ideia | Exemplo desta aula |
| --- | --- | --- |
| **Associação** | objetos se conhecem | `Emprestimo` conhece `Usuario` e `Livro` |
| **Agregação** | “tem um”, mas as partes vivem sozinhas | `Estante` tem `Livro`; o livro existe sem a estante |
| **Composição** | “parte de”, ciclo de vida acoplado | `Pedido` e `ItemPedido`: o item não faz sentido sem o pedido |

Na memória: relacionamento é **referência** (campo) ou **coleção de referências** (arranjo / lista). Nesta aula usamos arranjo com capacidade fixa para não exigir `ArrayList` ainda; na aula de integradores de POO a biblioteca passa a usar lista.

## 2. Cardinalidade

- **1–1:** `Usuario` tem um `Endereco`.
- **1–N:** `Usuario` tem vários `Emprestimo`.
- **N–N:** na implementação, vira duas listas ou uma classe associativa (`Emprestimo`).

O `Endereco` é um `record` (encapsulamento e pacotes): dado imutável. Nasce com o usuário — composição.

## 3. Diagrama no quadro

```
┌─────────┐       1     N  ┌────────────┐     N     1  ┌───────┐
│ Usuario │───────────────▶│ Emprestimo │─────────────▶│ Livro │
└─────────┘                └────────────┘              └───────┘
      │ 1
      │
      ▼ 1
┌──────────┐
│ Endereco │     (composição: o endereço “nasce” com o usuário)
└──────────┘
```

## 4. Lei de Demeter (versão leve)

Evite cadeias `usuario.getEndereco().getCidade().getUf()`. Prefira `usuario.cidadeFormatada()`: **não espalhe a estrutura interna**.

## 5. Pacotes desta aula

```java
package br.edu.ifba.conquista.lp1.aula05.modelo;
```

```bash
javac --release 25 -d aulas/05-relacionamentos-cardinalidade/out \
  $(find aulas/05-relacionamentos-cardinalidade/src -name "*.java")
java -cp aulas/05-relacionamentos-cardinalidade/out \
  br.edu.ifba.conquista.lp1.aula05.DemoRelacionamentos
```

## O que executar no projetor

O `DemoRelacionamentos` cria dois usuários, três livros, registra empréstimos e tenta emprestar um livro já emprestado (a regra está em `Livro.emprestar()`, não no `main`).

## Ponte para diagrama de classes UML

Vocês já falam associação, agregação, composição e 1–N. Na aula de diagrama de classes UML isso vira **diagrama de classes**: caixa com visibilidade, losango vazio/cheio e multiplicidade. A prova da Unidade 1 cobra o desenho e a tradução para Java.
