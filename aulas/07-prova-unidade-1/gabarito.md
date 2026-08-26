# Gabarito — Prova da Unidade 1

## Questão 1 (1,5)

a) Defeitos:

1. `i <= v.length` causa `ArrayIndexOutOfBoundsException` (e, se fosse `<`, ainda haveria o item 2).
2. A condição `v[i] % 2 == 1` conta **ímpares** (e falha para negativos ímpares em Java, se quiser rigor extra: `Math.abs(v[i]) % 2 == 0` ou `v[i] % 2 == 0` para pares, lembrando que `(-3) % 2 == -1` em Java). No nível da turma: par é `% 2 == 0`.

b)

```java
static int contarPares(int[] v) {
    int q = 0;
    for (int i = 0; i < v.length; i++) {
        if (v[i] % 2 == 0) {
            q++;
        }
    }
    return q;
}
```

Critério: 0,75 + 0,75. Se corrigir só o laço e deixar ímpares, no máximo 0,9 no total da questão.

## Questão 2 (2,0)

a) `a.x = 9`, `b.x = 9`, `c.x = 1`. `a` e `b` referenciam o **mesmo objeto**; `c` é outro objeto com estado inicialmente igual.

b) `a == b` → `true`; `a == c` → `false`.

c)

```java
public void mover(int dx, int dy) {
    this.x += dx;
    this.y += dy;
}
```

## Questão 3 (2,0)

a) `private`. Invariante: média em 0–10, capacidade da turma, etc. não podem ser quebrados por atribuição direta.

b) Esqueleto aceitável:

```java
public class Disciplina {
    private String nome;
    private Aluno[] alunos;
    private int quantidade;

    public Disciplina(String nome) {
        this.nome = nome;
        this.alunos = new Aluno[50];
        this.quantidade = 0;
    }

    public boolean matricular(Aluno a) {
        if (a == null || quantidade >= alunos.length) return false;
        alunos[quantidade++] = a;
        return true;
    }

    public double mediaDaTurma() {
        if (quantidade == 0) return 0;
        double soma = 0;
        for (int i = 0; i < quantidade; i++) {
            soma += alunos[i].getMedia();
        }
        return soma / quantidade;
    }
}
```

c) **Agregação** (ou associação 1–N): o aluno existe independentemente da disciplina. Composição seria se o aluno “morresse” com a disciplina — não é o caso acadêmico.

Aceite “associação” se a justificativa de ciclo de vida estiver correta. Zere “composição” sem ressalva.

## Questão 4 (1,5)

a) `Pedido.total`, arquivo `Pedido.java`, linha 24. (A ordem do stack trace: topo = mais recente.)

b) Item `null` no arranjo (iterou `length` em vez de `quantidade`); ou o próprio arranjo `itens` é `null`.

c) Compilação: `javac` recusa (sintaxe/tipos). Execução: JVM lança exceção. Lógica: termina “bem” com resultado errado.

## Questão 5 (2,0)

```java
static int somaDigitos(int n) {
    if (n < 10) {          // caso-base
        return n;
    }
    return (n % 10) + somaDigitos(n / 10); // caso recursivo
}
```

`n == 0` cai no caso-base. Iterativo: no máximo 0,6 se o enunciado pedia recursivo.

## Questão 6 (1,0)

```
s(5) = 5 + s(3)
s(3) = 3 + s(1)
s(1) = 1 + s(-1)
s(-1) = 0
volta: 1 + 0 = 1
volta: 3 + 1 = 4
volta: 5 + 4 = 9
```

Resposta final **9**. Só o 9 sem pilha: 0,4.
