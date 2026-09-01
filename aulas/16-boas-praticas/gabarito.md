# Gabarito — Aula 16

## Q1 — problemas em `AntiPadrao`

Lista mínima aceitável (há mais):

1. Classe faz UI, regra e persistência fictícia (SRP).
2. Nomes `c1`, `faz()`, `x`.
3. `saldo` público.
4. `catch (Exception e) {}`.
5. Número mágico `15` (tarifa?).
6. `transferir` duplica lógica de saque em vez de chamar método único (DRY).
7. `toString` default / prints misturados no modelo.
8. Método enorme `faz()`.

## Q2

Ver `versao-limpa/`: `ContaLimpa`, `ServicoTransferencia` (ou `transferir` na conta), `DemoLimpo`. Critério: encapsulamento, nomes, validação, `main` magro.

## Q3

Aceite Javadoc com `@param`, `@return` ou texto equivalente em português.

## Q4

```java
public class ProfessorVisitante {
    private final String nome;
    private final UsuarioBiblioteca conta; // composição

    public boolean emprestarNaBiblioteca(Biblioteca bib, Emprestavel item) {
        return bib.emprestar(conta, item);
    }
}
```

Não precisa copiar a biblioteca inteira: um esboço já demonstra o “tem um”.

## Q6

```java
public static final int PRAZO_DIAS = 14;
public int prazoDias() { return PRAZO_DIAS; }
```

## Q7

```java
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof Livro outro) {
        return getCodigo().equals(outro.getCodigo());
    }
    return false;
}

@Override
public int hashCode() {
    return getCodigo().hashCode();
}
```
