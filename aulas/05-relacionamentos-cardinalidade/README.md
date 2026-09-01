# Aula 05 — Cardinalidade e relacionamento entre objetos

**Data:** 14/09  
**Unidade:** 1  
**Pré-requisito:** aula 04

## Objetivos

- Identificar **associação**, **agregação** e **composição**.
- Expressar cardinalidade **1–1**, **1–N** e **N–N** (esta última via classe associativa).
- Implementar relacionamento como **referência** ou **arranjo de referências**.
- Aplicar uma versão leve da Lei de Demeter: não espalhar a estrutura interna.

Não há aula em 07/09 (feriado). Esta é a última aula de conteúdo da Unidade 1; a prova é em 21/09.

## Roteiro

1. Recapitule encapsulamento em 5 min: saldo `private`, sem `setSaldo`.
2. Desenhe UML simplificado: `Usuario` 1 — N `Emprestimo` N — 1 `Livro`; `Usuario` 1 — 1 `Endereco`.
3. Execute `DemoRelacionamentos` (usa pacotes).
4. Laboratório.

## 1. Relacionamentos

Fale em português antes de UML.

| Relacionamento | Ideia | Exemplo desta aula |
| --- | --- | --- |
| **Associação** | objetos se conhecem | `Emprestimo` conhece `Usuario` e `Livro` |
| **Agregação** | “tem um”, mas as partes vivem sozinhas | `Estante` tem `Livro`; o livro existe sem a estante |
| **Composição** | “parte de”, ciclo de vida acoplado | `Pedido` e `ItemPedido`: o item não faz sentido sem o pedido |

Na memória: relacionamento é **referência** (campo) ou **coleção de referências** (arranjo / lista). Nesta aula usamos arranjo com capacidade fixa para não exigir `ArrayList` ainda; na aula 11 a biblioteca passa a usar lista.

## 2. Cardinalidade

- **1–1:** `Usuario` tem um `Endereco`.
- **1–N:** `Usuario` tem vários `Emprestimo`.
- **N–N:** na implementação, vira duas listas ou uma classe associativa (`Emprestimo`).

O `Endereco` é um `record` (aula 04): dado imutável. Nasce com o usuário — composição.

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

Evite cadeias `usuario.getEndereco().getCidade().getUf()`. Prefira `usuario.cidadeFormatada()`. Não cobre isso em prova com o nome da lei; cobre o hábito: **não espalhe a estrutura interna**.

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

## Ponte para a prova (21/09)

A Unidade 1 cobra: revisão de lógica, classes e objetos, atributos/construtores/métodos, encapsulamento/pacotes e relacionamentos (tipos e cardinalidade). Instrumento em `aulas/06-prova-unidade-1`. Recursão e depuração vêm depois.
