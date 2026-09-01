# Gabarito — Aula 04

## Q1

Construtor:

```java
public Retangulo(double base, double altura) {
    if (base <= 0 || altura <= 0) {
        throw new IllegalArgumentException("base e altura devem ser positivas");
    }
    this.base = base;
    this.altura = altura;
}
```

Se a turma ainda não viu exceções, o fallback `base = 1.0` com mensagem no console é aceitável. Exceções voltam com mais calma na aula 16.

Sem setter aberto. Se houver `redimensionar(double b, double a)`, valide de novo.

## Q2

`setSaldo` permite `conta.setSaldo(1_000_000)` ou `setSaldo(-1)` sem depósito, saque, auditoria ou cheque especial. O saldo só muda por operações de negócio.

## Q3

1. `private` — invariante do saldo.
2. `public` — operação do contrato da conta.
3. `private` — detalhe interno.
4. `public` — ponto de entrada visível para a JVM / docente executar.

## Q4

Árvore:

```
src/br/edu/ifba/conquista/lp1/exercicio/modelo/Retangulo.java
src/br/edu/ifba/conquista/lp1/exercicio/app/Principal.java
```

`Principal` faz `import br.edu.ifba.conquista.lp1.exercicio.modelo.Retangulo;`

```bash
javac --release 25 -d out $(find src -name "*.java")
java -cp out br.edu.ifba.conquista.lp1.exercicio.app.Principal
```

## Q5

`Cpf` → `record` (dado imutável). `ContaCorrente` → classe (estado muda).

```java
public record Cpf(String digitos) {
    public String formatado() {
        return digitos; // formatação completa é exercício de String
    }
}
```

## Q6

Acesso package-private quebra ao mudar de pacote. O certo é `private` + métodos de negócio (`adicionar`, `baixar`), não atributo visível ao pacote “porque é mais fácil”.
