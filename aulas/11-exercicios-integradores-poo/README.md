# Aula 11 — Exercícios integradores de POO

**Data:** 26/10  
**Unidade:** 2  
**Pré-requisito:** aulas 08 a 10  
**Depois desta aula:** feriados em 02/11 e 09/11; prova em 16/11.

## Objetivos

- Reunir herança, polimorfismo, classe abstrata e interface **num único problema**.
- Ler código de terceiros (o `src/` desta aula) e estendê-lo sem reescrever tudo.
- Identificar o ponto certo para um novo tipo (nova subclasse vs. novo contrato).

Não há tópico teórico novo. O encontro é laboratório longo, com um fechamento de 20 minutos no quadro.

## O sistema: acervo do campus

Pacote conceitual (arquivos no mesmo `src/`, sem package, para compilação simples):

| Tipo | Papel |
| --- | --- |
| `ItemAcervo` | classe **abstrata selada** (`permits Livro, Revista, ObraConsulta`): código, título, `resumo()` |
| `Emprestavel` | **interface**: emprestar / devolver / disponível |
| `Livro` | extends `ItemAcervo`, implements `Emprestavel` — prazo 14 dias |
| `Revista` | extends `ItemAcervo`, implements `Emprestavel` — prazo 7 dias |
| `ObraConsulta` | extends `ItemAcervo` — **não** é emprestável (só consulta local) |
| `UsuarioBiblioteca` | nome, matrícula, limite de itens |
| `Emprestimo` | associa usuário + item + dias de prazo |
| `Biblioteca` | cadastro de itens e usuários; `emprestar`, `devolver`, `relatorio()` |
| `DemoAcervo` | cenário pronto para o projetor |

Regras já implementadas:

1. Só se empresta o que `implements Emprestavel` e está disponível.
2. `ObraConsulta` não entra no fluxo de empréstimo (o compilador impede se você só aceita `Emprestavel`).
3. Usuário tem limite (default 3).
4. `Biblioteca.relatorio()` percorre `ItemAcervo[]` e imprime `resumo()` — polimórfico.

## Roteiro

1. (30 min) Execute `DemoAcervo`. Desenhe o diagrama no quadro com a turma (abstrata, interface, subclasses).
2. (resto) Exercícios: a turma **altera e amplia** o sistema. Você circula. Não abra o gabarito.
3. (20 min) Correção comentada da Q2 e da Q4 (as que mais caem na prova).

## Diagrama para a lousa

```
                 «abstract»
                 ItemAcervo
                 resumo()
               /     |      \
          Livro   Revista   ObraConsulta
             \      / 
          «interface» Emprestavel
```

`Notebook` (exercício) implementa `Emprestavel` **sem** ser `ItemAcervo` — o mesmo gancho da aula 10.

## Compilar

```bash
javac aulas/11-exercicios-integradores-poo/src/*.java
java -cp aulas/11-exercicios-integradores-poo/src DemoAcervo
```

## Preparação da prova (16/11)

Avise: a prova mistura leitura de código, implementação de uma subclasse e uma questão conceitual interface vs. abstrata. Recursão e encapsulamento da Unidade 1 **podem** aparecer como detalhe, não como eixo.
