# Exercícios — Aula 16 (boas práticas)

## Laboratório

### Q1 — Caça ao anti-padrão

Abra `AntiPadrao.java`. Liste no caderno **pelo menos cinco** problemas, com o nome da prática violada (nome, SRP, DRY, erro silencioso, magia numérica, etc.).

### Q2 — Refatoração

Reescreva o cenário (conta + transferência + relatório) em classes novas, no espírito de `versao-limpa/`. Não copie colando sem ler. O `main` só cria objetos e imprime.

### Q3 — Contrato

Escreva Javadoc de `sacar` e do construtor da sua conta. Inclua o que acontece com valor ≤ 0.

### Q4 — Composição

Modele `ProfessorVisitante` que **tem** um `UsuarioBiblioteca` (não herda). Um método `emprestarNaBiblioteca(Emprestavel item)` delega. (Pode usar a interface da aula 11 ou um `boolean` fictício.)

## Casa

### Q5 — Code review cruzado

Troque o Q2 com um colega. Marque 3 sugestões. Entrega: o código **seu** + as 3 notas do colega (texto).

### Q6 — Extraia a magia

No acervo da aula 12, prazos 14 e 7 estão soltos. Transforme em constantes `public static final` nas classes. Um único lugar para mudar a política.

### Q7 — (desafio) `equals`

Implemente `equals` e `hashCode` de `Livro` por `codigo` do acervo. Dois livros com o mesmo código são o mesmo item. Teste com `new String("L01")` nos códigos para não cair no `==`.
