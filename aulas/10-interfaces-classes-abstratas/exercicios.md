# Exercícios — Aula 10

## Laboratório

### Q1 — `Forma` abstrata

`abstract sealed class Forma permits Retangulo, Circulo` (e `Quadrado`, se criar) com `abstract double area()` e `abstract double perimetro()`, mais `String nome()`.  
`Retangulo`, `Circulo`, `Quadrado extends Retangulo` (ou `extends Forma` direto — discuta **e** atualize `permits`). No `src/` da aula, `Retangulo` é `non-sealed` para o quadrado poder estendê-lo sem novo `permits`.  
`Forma[]` no `main` imprimindo área e perímetro. `new Forma()` não deve compilar. `switch` na hierarquia selada é exaustivo (sem `default` obrigatório).

### Q2 — Interface `Autenticavel`

```java
public interface Autenticavel {
    boolean autenticar(String senha);
}
```

`Usuario` e `TerminalAdministrativo` implementam (o terminal tem senha de serviço). Método `static boolean entrar(Autenticavel a, String senha)`.

### Q3 — Conta abstrata

Tome a hierarquia da aula 09 e torne `Conta` abstrata com `abstract void aplicarTaxasMensais()`. Implemente nas subclasses. Um `Conta[]` percorre e aplica taxas.

### Q4 — Duas interfaces

`Imprimivel { void imprimir(); }` e `Persistivel { void salvar(); }`.  
`Relatorio` implementa as duas. Mostre no `main` uma variável de cada tipo de contrato apontando para o **mesmo** relatório.

## Casa

### Q5 — Comparação

Responda em até meia página: por que `Notebook` e `Livro` não devem, neste domínio, compartilhar uma superclasse só para “poder emprestar”, e por que a interface resolve?

### Q6 — (desafio) `default`

Adicione `default void registrarLog(String msg)` em `Emprestavel` que imprime no console. Não altere `Livro` nem `Notebook`. Chame `registrarLog` pelo contrato.
