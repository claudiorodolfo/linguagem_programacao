# Exercícios — Aula 04 (encapsulamento e pacotes)

## Laboratório

### Q1 — Encapsular `Retangulo`

Pegue o `Retangulo` da aula 03. Atributos `private`. Construtor rejeita base ou altura ≤ 0 (imprima erro e use 1.0 como fallback, ou recuse criar — documente a escolha). Sem `setBase` que aceite negativo.

### Q2 — Invariante

Na `ContaBancaria` encapsulada desta aula, explique por que **não** deve existir `setSaldo`. O que um atacante faria com ele?

### Q3 — Modificadores

Para cada situação, escolha `private`, package-private, `protected` ou `public` e justifique em uma frase:

1. o atributo `saldo` de `ContaBancaria`;
2. o método `sacar`;
3. um método auxiliar `boolean valorPositivo(double v)` usado só dentro da classe;
4. a classe `DemoEncapsulamento`.

### Q4 — Pacote

Mova `Retangulo` para `br.edu.ifba.conquista.lp1.exercicio.modelo` e o `main` para `...exercicio.app`. Compile com `-d out` e execute pelo nome qualificado.

## Casa

### Q5 — `record` ou classe?

`Cpf` (onze dígitos, imutável depois de criado) e `ContaCorrente` (saldo muda). Qual vira `record` e qual permanece classe? Escreva o `record` com um método `formatado()` (`000.000.000-00` vale como esboço).

### Q6 — (desafio) Pacote e visibilidade

Duas classes no **mesmo** pacote: `Estoque` (com atributo package-private `int quantidade`) e `Inventario`. `Inventario` altera `quantidade` diretamente. Mova `Inventario` para outro pacote — o que deixa de compilar? Qual modificador você usaria de verdade, e por quê?
