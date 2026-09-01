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

c) `==` compara **identidade** (a referência), não o conteúdo dos atributos. Dois `new` são duas identidades.

## Questão 3 (2,0)

a) `Conta.total` vale **2**. `Conta.saldo` é erro conceitual: `saldo` é de instância — não existe “o saldo da classe”.

b) `this(...)` encadeia o outro construtor e **precisa** ser a primeira instrução; o compilador recusa qualquer código antes.

c)

```java
public boolean transferir(Conta destino, double valor) {
    if (destino == null) {
        return false;
    }
    if (this.sacar(valor)) {
        destino.depositar(valor);
        return true;
    }
    return false;
}
```

## Questão 4 (1,5)

a) `private`. Invariante: saldo nunca negativo, só muda por depósito/saque — não por atribuição direta.

b) `setSaldo` permite `conta.setSaldo(1_000_000)` ou `setSaldo(-1)` sem operação de negócio. O saldo só muda por métodos que validam.

c) Aceite dois dentre: pastas `.../aula04/modelo/` e `.../aula04/`; `import` do modelo na Demo; `javac -d out` + `java -cp out pacote.DemoEncapsulamento`; o arquivo público tem de se chamar como a classe.

## Questão 5 (1,5)

a) Esqueleto aceitável:

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

b) Disciplina–Aluno: **agregação** (ou associação) **1–N** — o aluno existe sem a disciplina. Aluno–Endereco: **composição 1–1** se o endereço nasce e some com o aluno neste modelo. Zere “composição” em Disciplina–Aluno sem ressalva.

## Questão 6 (1,5)

a) Losango **preenchido** em `Pedido`; ponta dos itens `0..20` (ou `1..*` se justificar pedido não vazio). Caixas com `−` nos atributos e `+ total(): double`. Sem `set` aberto de lista de itens.

b) `new` interno é composição: o item não tem identidade fora do pedido. Losango vazio (agregação) nesta questão é erro — desconte 0,5 no item (a).
