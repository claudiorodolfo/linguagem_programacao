# Prova da Unidade 1 — Linguagem de Programação 1

**IFBA — Campus Vitória da Conquista**  
**Curso:** Sistemas de Informação  
**Disciplina:** Linguagem de Programação 1 (Java)  
**Data:** 21/09  
**Duração:** 2 horas  
**Valor:** 10,0 pontos  

Nome: _________________________________  Matrícula: ________________

Instruções: caneta; letra legível; identifique as questões. Não é permitido material de consulta. Em código, priorize a lógica; erros leves de sintaxe não zeram a questão.

---

## Questão 1 — Revisão (1,5)

O método abaixo deveria devolver a **quantidade de pares** no vetor. Encontre os defeitos e reescreva-o corretamente.

```java
static int contarPares(int[] v) {
    int q = 0;
    for (int i = 0; i <= v.length; i++) {
        if (v[i] % 2 == 1) {
            q++;
        }
    }
    return q;
}
```

a) (0,75) Liste os defeitos.  
b) (0,75) Código corrigido.

---

## Questão 2 — Classes, objetos e referências (2,0)

Considere:

```java
public class Ponto {
    int x;
    int y;
    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
```

e o trecho:

```java
Ponto a = new Ponto(1, 2);
Ponto b = a;
Ponto c = new Ponto(1, 2);
b.x = 9;
```

a) (0,8) Quais os valores de `a.x`, `b.x` e `c.x` após o trecho? Justifique com as palavras *objeto* e *referência*.  
b) (0,6) O que imprime `a == b`? E `a == c`?  
c) (0,6) Escreva um método de instância `void mover(int dx, int dy)` que translada o ponto.

---

## Questão 3 — Encapsulamento e relacionamentos (2,0)

Uma `Disciplina` possui vários `Aluno` (no máximo 50). Cada aluno tem `nome` (String) e `media` (double).

a) (0,6) Os atributos devem ser `public` ou `private`? Por quê, em uma frase ligada a **invariante**?  
b) (0,8) Escreva o esqueleto de `Disciplina` com: construtor que recebe o nome da disciplina; `boolean matricular(Aluno a)`; `double mediaDaTurma()`. Você pode usar arranjo.  
c) (0,6) O vínculo Disciplina–Aluno é associação, agregação ou composição? Justifique com o ciclo de vida: o aluno deixa de existir se a disciplina for encerrada?

---

## Questão 4 — Depuração (1,5)

O programa lança:

```
Exception in thread "main" java.lang.NullPointerException
    at Pedido.total(Pedido.java:24)
    at Caixa.fechar(Caixa.java:11)
    at App.main(App.java:8)
```

a) (0,5) Qual foi o **último** método que a JVM estava executando quando a exceção ocorreu? Em que arquivo e linha você abriria primeiro?  
b) (0,5) Cite uma causa típica de `NullPointerException` em um método `total()` de um pedido com arranjo de itens.  
c) (0,5) Diferencie, em uma frase cada, erro de **compilação**, erro de **execução** e erro de **lógica**.

---

## Questão 5 — Recursão: implementar (2,0)

Escreva `static int somaDigitos(int n)` **recursivo**, com `n >= 0`, que devolve a soma dos dígitos. Exemplos: `somaDigitos(0) = 0`, `somaDigitos(172) = 10`.

Indique claramente o caso-base e o caso recursivo (comentário ou texto ao lado).

---

## Questão 6 — Recursão: rastrear (1,0)

Dado:

```java
static int s(int n) {
    if (n <= 0) {
        return 0;
    }
    return n + s(n - 2);
}
```

Mostre a pilha de chamadas de `s(5)` até o caso-base e o valor final. Não basta só o número.

---

Boa prova.
