# Exercícios integradores — Aula 17

## Trilha A (laboratório)

### Q1 — Previsão

No `DemoBoletim`, a prova 2 não tem nota. Calcule a média ponderada **no papel** e confira.

### Q2 — `Seminario`

`Seminario extends Atividade`. Nota 0–10. Peso no construtor. Cadastre um seminário com nota 9, peso 1, no estudante do demo e recalcule.

### Q3 — Situação com wrapper

`Boletim.situacao(Estudante e)` já existe? Se não, implemente:

- média `null` → `"cursando"`
- ≥ 7 → `"aprovado"`
- ≥ 5 → `"recuperação"`
- senão `"reprovado"`

Unboxing só depois do teste de `null`.

### Q4 — Recursão

`static double somaNotas(Avaliavel[] v, int i)` — soma das notas **não nulas** a partir de `i`. Sem `for`. Fachada que converte a lista do estudante para arranjo é aceitável (`toArray`).

### Q5 — Boas práticas

O método de média está grande? Extraia `private static boolean temNota(Avaliavel a)`. Substitua um `==` entre `Integer` se houver (não deve haver no `src/` original).

## Trilha B (casa / desafio)

### Q6 — Recuperação

Classe `ProvaFinal extends ProvaEscrita` (ou `extends Atividade`) com peso próprio. Só entra na média se a média parcial for < 7 e ≥ 5. Isso exige um método `mediaParcial` separado da média final. Documente a regra em Javadoc.

### Q7 — Comparar estudantes

`Estudante` implementa `Comparable<Estudante>` por média (null no fim da lista). `Collections.sort`. Cuidado: `compareTo` não deve NPE.

### Q8 — Integração biblioteca

Um `Estudante` **tem** `UsuarioBiblioteca` (composição, aula 16). Não precisa da biblioteca inteira: um campo e um getter bastam, com comentário dizendo por que não foi `extends`.

### Q9 — Relatório em arquivo? Não.

Não grave em disco nesta disciplina. Imprima um relatório texto com `StringBuilder` no `Boletim.relatorio(Estudante)`.
