# Exercícios integradores

**Unidade:** 3  
**Pré-requisito:** toda a ementa  
**Próximo encontro:** prova da Unidade 3

## Objetivos

- Resolver um problema que exige **vários** tópicos da disciplina ao mesmo tempo.
- Revisar, de forma ativa, recursão, POO, contratos, wrappers e um hábito de qualidade.
- Chegar à prova da Unidade 3 sem assunto inédito.

Não há capítulo novo. Há um mini-sistema (`src/`) e uma lista longa para a semana da aula de boas práticas. Escolha: **trilha A** (obrigatória) e **trilha B** (desafio).

## O sistema: boletim do campus

Modelo:

- `Avaliavel` — interface: `Integer nota()` (null = não lançada) e `String nome()`.
- `Atividade` — classe abstrata (título, peso).
- `ProvaEscrita` e `Trabalho` — subclasses; o trabalho pode ter nota extra encapsulada.
- `Estudante` — nome, matrícula, lista de atividades (`ArrayList<Avaliavel>`).
- `Boletim` — média ponderada **ignorando** atividades sem nota; situação do estudante.
- `DemoBoletim` — cenário com um nulo no meio (wrapper).

Regras já no código:

1. Peso ≤ 0 é inválido no construtor (`IllegalArgumentException`).
2. `nota()` devolve `Integer` de propósito.
3. Média: soma(`nota * peso`) / soma(pesos das atividades **com** nota).
4. Sem nenhuma nota lançada, média é `null` (não 0.0 — 0 mentiria).

## Roteiro

1. Rode `DemoBoletim`. Preveja a média **antes** (há um `null`).
2. Trilha A; quem terminar cedo parte para a B.
3. Mapa da prova da Unidade 3: o que cobra (ver a pasta `prova-unidade-3`).

## Compilar

```bash
javac aulas/17-exercicios-integradores/src/*.java
java -cp aulas/17-exercicios-integradores/src DemoBoletim
```

## Mapa rápido da ementa neste `src/`

| Tópico | Onde está |
| --- | --- |
| Encapsulamento | pesos e notas privados |
| Herança / abstrata | `Atividade` |
| Interface / polimorfismo | `Avaliavel`, lista heterogênea |
| Wrappers / null | `Integer nota()` |
| Boas práticas | exceção no construtor, `Boletim` sem `Scanner` |
| Recursão | exercício Q4, não o demo |
