# Gabarito — Prova da Unidade 3

## Questão 1 (2,0)

a) Aceite quatro dentre: nomes `X`/`faz`/`n`/`v`; `n` público; `catch` vazio; mistura de “somar” com “limitar”; magia 10; sem documentação da regra; possível overflow não tratado (não exigir).

b) Exemplo:

```java
public class ContadorLimitado {
    public static final int TETO = 10;
    private int valor;

    public void incrementar(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException("delta >= 0");
        }
        valor += delta;
        if (valor > TETO) {
            valor = TETO;
        }
    }

    public int getValor() {
        return valor;
    }
}
```

Não precisa ser exatamente isso; precisa de encapsulamento e ausência do `catch` vazio.

## Questão 2 (2,5)

a) Boxing: primitivo → objeto wrapper. Unboxing: wrapper → primitivo.

b) Genéricos (e coleções) trabalham com objetos, não com primitivos.

c) `true`, `false`, `true`.

d) `NullPointerException`. O compilador inseriu `x.intValue()` (unboxing).

Se no item (c) o aluno inverter 127/200 mas explicar cache: até 0,4. Sem `equals` true: −0,2.

## Questão 3 (2,0)

```java
static String conceito(Integer media) {
    if (media == null) {
        return "incompleto"; // sem unboxing
    }
    int m = media; // unboxing seguro
    if (m >= 9) return "A";
    if (m >= 7) return "B";
    if (m >= 5) return "C";
    return "D";
}
```

Unboxing direto no `if (media >= 9)` também é correto **depois** do teste de null (`media >= 9` unboxa). Quem unboxa antes do null: no máximo 0,8.

## Questão 4 (2,0)

a) `int` não representa “ausente”; `Integer` pode ser `null`.

b) Polimorfismo / programar para o contrato `Avaliavel` (ligação dinâmica de `nota()` e `peso()`).

c) SRP: `Boletim` calcula, `Atividade` guarda dados. Violação: modelo misturado com I/O (`Scanner` na atividade). Encapsulamento do peso no construtor também vale.

## Questão 5 (1,5)

```java
static int contarNulos(Integer[] v, int i) {
    if (i >= v.length) {
        return 0;
    }
    int agora = v[i] == null ? 1 : 0;
    return agora + contarNulos(v, i + 1);
}
```

Iterativo: 0,4 se o enunciado pedia recursivo. Esquecer o caso-base: 0,5.
