# Plano de ensino — Linguagem de Programação 1

| Campo | Informação |
| --- | --- |
| Instituição | Instituto Federal de Educação, Ciência e Tecnologia da Bahia |
| Campus | Vitória da Conquista |
| Curso | Bacharelado em Sistemas de Informação |
| Disciplina | Linguagem de Programação 1 |
| Linguagem | Java 25 (LTS) |
| Carga horária sugerida | 60 h (aulas semanais de 4 h) |

Ajuste carga horária, créditos e composição da nota conforme o PPC vigente do curso.

## Ementa

Recursividade. Programação orientada a objetos: abstração de dados; classes e objetos; herança; e polimorfismo. Interfaces e classes abstratas. Depuração de programas. Box e Unboxing. Boas práticas de programação.

## Objetivos

Ao final da disciplina, a estudante ou o estudante deverá ser capaz de:

1. Revisar e aplicar estruturas de controle, arranjos e métodos em Java.
2. Modelar problemas com **abstração de dados**, definindo classes, objetos, atributos e comportamentos.
3. Aplicar **encapsulamento** e organizar código em pacotes, reconhecendo associação, agregação e composição.
4. Localizar e corrigir falhas com **depuração** (breakpoints, inspeção de variáveis, pilha de chamadas).
5. Projetar soluções **recursivas**, identificando caso-base, caso recursivo e limites da pilha de execução.
6. Construir hierarquias com **herança** e **polimorfismo**.
7. Separar contrato de implementação com **interfaces** e **classes abstratas**.
8. Distinguir tipos primitivos de **wrappers**, explicando **boxing** e **unboxing**.
9. Escrever código alinhado a **boas práticas** (nomes, responsabilidade, DRY, tratamento de erros).

## Conteúdo programático

### Unidade 1 — Fundamentos de POO e recursão

- Apresentação da disciplina e revisão de lógica de programação em Java.
- Classes, objetos, construtores e o operador `new`.
- Encapsulamento, modificadores de acesso e organização em pacotes.
- Relacionamentos entre objetos (associação, agregação, composição).
- Depuração de programas.
- Recursividade.

### Unidade 2 — Hierarquias e contratos

- Herança, `super`, redefinição de métodos.
- Polimorfismo, ligação dinâmica, `instanceof`.
- Interfaces e classes abstratas.
- Exercícios integradores de POO.

### Unidade 3 — Qualidade e tipos

- Boas práticas de programação.
- Boxing, unboxing e classes wrapper.
- Exercícios integradores da disciplina.

## Metodologia

- Aula expositiva dialogada com projeção de código.
- Laboratório: os estudantes compilam e alteram os exemplos de `src/` e resolvem `exercicios.md`.
- Estudo de caso recorrente (**biblioteca do campus** e **conta bancária**), aprofundado de uma aula para a outra.
- Provas escritas com trechos de código para leitura, correção e implementação.

Sugestão de dinâmica em cada encontro de 4 h:

| Bloco | Duração | Atividade |
| --- | --- | --- |
| 1 | 50–70 min | Teoria + live coding do `README.md` |
| 2 | 15 min | Intervalo |
| 3 | 80–100 min | Laboratório (`exercicios.md`) |
| 4 | 20–30 min | Correção comentada / fechamento |

## Avaliação

Três provas presenciais, alinhadas às unidades:

| Instrumento | Data | Conteúdo |
| --- | --- | --- |
| Prova da Unidade 1 | 21/09 | Aulas 02 a 06 |
| Prova da Unidade 2 | 16/11 | Aulas 08 a 11 (com base na Unidade 1) |
| Prova da Unidade 3 | 14/12 | Aulas 13 a 15 (com base nas unidades anteriores) |

Sugestão de composição (edite conforme o regulamento do campus):

\[
N_f = \frac{U_1 + U_2 + U_3}{3}
\]

Os instrumentos propostos estão em `aulas/07-prova-unidade-1`, `aulas/12-prova-unidade-2` e `aulas/16-prova-unidade-3`. Os gabaritos são para uso docente.

## Bibliografia básica

1. DEITEL, Harvey; DEITEL, Paul. *Java: como programar*. Pearson.
2. HORSTMANN, Cay S. *Core Java*. Volume I — Fundamentos. Pearson / Bookman.
3. SIERRA, Kathy; BATES, Bert. *Use a cabeça! Java*. Alta Books.

## Bibliografia complementar

1. BARNES, David J.; KÖLLING, Michael. *Programação orientada a objetos com Java: uma introdução prática usando o BlueJ*. Pearson.
2. BLOCH, Joshua. *Effective Java*. Pearson / Alta Books.
3. MARTIN, Robert C. *Código limpo*. Alta Books.
4. ORACLE. *Java Platform, Standard Edition 25 — Documentation*. https://docs.oracle.com/en/java/javase/25/
5. SCHILDT, Herbert. *Java: the complete reference*. McGraw-Hill.

## Observações

- Linguagem-alvo: **Java 25** (LTS). Sem recursos em preview. Ver [`recursos/java25.md`](recursos/java25.md).
- IDE sugerida: IntelliJ IDEA Community, Eclipse ou VS Code + Extension Pack for Java, com SDK 25. Ver [`recursos/ambiente.md`](recursos/ambiente.md).
- Os feriados de 07/09, 12/10, 02/11 e 09/11 **não têm encontro**. Não há reposição automática neste material.
- Roteiro operacional do semestre: [`recursos/guia-docente.md`](recursos/guia-docente.md).
