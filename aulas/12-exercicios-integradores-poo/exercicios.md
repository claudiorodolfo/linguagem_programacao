# Exercícios integradores — Integradores de POO

Trabalhe **sobre** o código em `src/`. Não crie um projeto paralelo, salvo se a IDE exigir.

## Laboratório

### Q1 — Leitura guiada

No caderno, responda com o código aberto:

1. Por que `ItemAcervo` é abstrata?
2. Por que `emprestar` da `Biblioteca` recebe `Emprestavel` e não `ItemAcervo`?
3. O que aconteceria se `ObraConsulta` implementasse `Emprestavel` “só para passar na lista”?

### Q2 — `DVD`

Crie `final class DVD extends ItemAcervo implements Emprestavel` com `duracaoMinutos` e prazo de 3 dias. **Atualize** `permits` em `ItemAcervo` (`... permits Livro, Revista, ObraConsulta, DVD`). Sem isso — e sem `final`/`sealed`/`non-sealed` — o compilador recusa. Cadastre um DVD no `DemoAcervo` e empreste.

### Q3 — Multa simbólica

Adicione em `Emprestimo` o método `double multa(int diasAtraso)` : R$ 1,00 por dia para livro, R$ 2,00 para revista. **Não** use `instanceof` se conseguir: coloque `double valorMultaPorDia()` em `Emprestavel` (método abstrato da interface — todas as implementações passam a ter).

### Q4 — Relatório só de emprestáveis

Na `Biblioteca`, método `void listarDisponiveis()` que percorre os itens e imprime os que são `Emprestavel` **e** estão disponíveis. Aqui `instanceof Emprestavel` é aceitável (fronteira). Opcional: guardar dois arranjos (itens vs. emprestáveis) e eliminar o teste.

### Q5 — Limite por tipo de usuário

`UsuarioBiblioteca` ganha subclasses `AlunoGraduacao` (limite 3) e `Docente` (limite 8). O limite deixa de ser um `int` mágico no construtor e vira método `int limiteEmprestimos()` sobrescrito. Ajuste `Biblioteca.emprestar`.

## Casa ( palco da prova )

### Q6 — `Notebook` do NTI

Não estende `ItemAcervo`. Implementa `Emprestavel` (prazo 1 dia, multa/dia R$ 10,00 se você fez a Q3). A `Biblioteca` precisa de um lugar para notebooks: `cadastrarEquipamento(Emprestavel e)` ou um arranjo separado. Empreste um notebook para um docente.

### Q7 — Recursão relâmpago (revisão U1)

`ItemAcervo[]` pode ter buracos (`null`). Escreva `static int contar(ItemAcervo[] v, int i)` recursivo: número de posições não nulas a partir do índice `i`. Caso-base: `i >= v.length`.

### Q8 — (desafio) Composição

`Emprestimo` hoje aponta para `Emprestavel`. Extraia `PrazoPolitica` (estratégia) em vez de `diasDePrazo()` em cada classe.
