# Exercícios — Aula 02 (classes e objetos)

## Laboratório

### Q1 — Classe `Pessoa`

Atributos: `nome` (`String`) e `idade` (`int`). Sem construtor declarado. Método `apresentar()` que devolve um texto do tipo `Ana (20 anos)`. Crie duas pessoas no `main` e imprima as apresentações.

### Q2 — Dois objetos, dois estados

Crie dois `Livro` (use a classe da aula). Empreste só o primeiro. Imprima `descricao()` dos dois e explique, em um comentário, por que o segundo continua disponível.

### Q3 — Referências

Sem executar de cabeça, escreva o que será impresso e depois confira:

```java
Livro a = new Livro();
a.titulo = "Clean Code";
Livro b = a;
Livro c = new Livro();
c.titulo = "Clean Code";
b.emprestar();
IO.println(a.emprestado);
IO.println(b.emprestado);
IO.println(c.emprestado);
IO.println(a == b);
IO.println(a == c);
```

### Q4 — Identidade versus estado

Dois objetos podem ter os **mesmos valores** nos atributos e mesmo assim serem objetos diferentes. Escreva um trecho que prove isso com `==` e com os campos `titulo` / `autor`.

## Casa

### Q5 — Classe `Lampada`

Atributos: `ligada` (`boolean`). Métodos `ligar()`, `desligar()` e `estaLigada()`. No `main`, ligue, imprima, desligue, imprima. Não use construtor — só `new Lampada()` e métodos.

### Q6 — (desafio) Várias referências, um objeto

Crie um `Livro`, atribua três variáveis (`a`, `b`, `d`) à **mesma** instância e uma quarta (`c`) a outra instância. Empreste via `d`. Quais impressões de `emprestado` você espera em `a`, `b`, `c` e `d`? Confira.
