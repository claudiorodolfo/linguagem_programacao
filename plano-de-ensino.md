# Plano de Ensino — Linguagem de Programação 1

| Campo | Informação |
| --- | --- |
| Instituição | Instituto Federal da Bahia |
| Campus | Vitória da Conquista |
| Curso | Bacharelado em Sistemas de Informação |
| Disciplina | Linguagem de Programação 1 |
| Linguagem | Java 25 (LTS) |
| Carga horária sugerida | 60 h (aulas semanais de 4 h) |

## Ementa

Recursividade. Programação orientada a objetos: abstração de dados; classes e objetos; herança; e polimorfismo. Interfaces e classes abstratas. Depuração de programas. Box e Unboxing. Boas práticas de programação.

## Objetivos

Ao final da disciplina, a estudante ou o estudante deverá ser capaz de:

1. Modelar problemas com **abstração de dados**, distinguindo classe e objeto.
2. Definir **atributos**, **construtores** e **métodos** com `this` e sobrecarga.
3. Aplicar **encapsulamento**, modificadores de acesso e organização em **pacotes**.
4. Reconhecer **cardinalidade** e relacionamentos (associação, agregação, composição).
5. Ler e produzir **diagrama de classes UML** (caixa, visibilidade, multiplicidade, losango).
6. Projetar soluções **recursivas**, identificando caso-base, caso recursivo e limites da pilha de execução.
7. Construir hierarquias com **herança** e **polimorfismo**.
8. Separar contrato de implementação com **interfaces** e **classes abstratas**.
9. Localizar e corrigir falhas com **depuração** (breakpoints, inspeção de variáveis, pilha de chamadas).
10. Distinguir tipos primitivos de **wrappers**, explicando **boxing** e **unboxing**.
11. Escrever código alinhado a **boas práticas** (nomes, responsabilidade, DRY, tratamento de erros).

## Conteúdo programático

### Unidade 1 — Fundamentos de POO

- Apresentação da disciplina e revisão de lógica de programação em Java.
- Programação orientada a objetos: classes e objetos.
- Atributos, construtores e métodos.
- Encapsulamento, modificadores de acesso e pacotes/módulos.
- Cardinalidade e relacionamento entre objetos.
- Diagrama de classes UML.

### Unidade 2 — Recursão, hierarquias e contratos

- Recursividade.
- Herança, `super`, redefinição de métodos.
- Polimorfismo, ligação dinâmica, `instanceof`.
- Interfaces e classes abstratas.

### Unidade 3 — Qualidade e tipos

- Depuração de programas.
- Boxing, unboxing e classes wrapper.
- Boas práticas de programação.
- Exercícios integradores da disciplina.

## Metodologia

- Aula expositiva dialogada com projeção de código.
- Laboratório: os estudantes compilam e alteram os exemplos de `src/` e resolvem `exercicios.md`.
- Estudo de caso recorrente (**biblioteca do campus** e **conta bancária**), aprofundado de uma aula para a outra.
- Provas escritas com trechos de código para leitura, correção e implementação.

Sugestão de dinâmica em cada encontro (ajuste ao ritmo da turma):

| Bloco | Atividade |
| --- | --- |
| 1 | Teoria + live coding do `README.md` |
| 2 | Intervalo |
| 3 | Laboratório (`exercicios.md`) |
| 4 | Correção comentada / fechamento |

## Avaliação

Três provas presenciais, alinhadas às unidades:

| Instrumento | Quando | Conteúdo |
| --- | --- | --- |
| Prova da Unidade 1 | ao final da Unidade 1 | revisão até o diagrama de classes UML |
| Prova da Unidade 2 | ao final da Unidade 2 | recursividade até os integradores de POO (com base na Unidade 1) |
| Prova da Unidade 3 | ao final da Unidade 3 | depuração, wrappers, boas práticas e integradores da disciplina (com base nas unidades anteriores) |

Sugestão de composição (edite conforme o regulamento do campus):

\[
N_f = \frac{U_1 + U_2 + U_3}{3}
\]

Os instrumentos propostos estão nas pastas de prova (`prova-unidade-2`, `prova-unidade-3`). Os gabaritos são para uso docente.

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
- Confira o calendário acadêmico do semestre (feriados, recessos) e encaixe as pastas de `aulas/` nessa ordem. Este material **não** traz datas fixas. Janelas sem encontro presencial servem às interfaces e os integradores de POO (estudo dirigido).
- Roteiro operacional do semestre: [`recursos/guia-docente.md`](recursos/guia-docente.md).
