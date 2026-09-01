# Prova da Unidade 3 — Linguagem de Programação 1

**IFBA — Campus Vitória da Conquista**  
**Curso:** Sistemas de Informação  
**Disciplina:** Linguagem de Programação 1 (Java)  
**Data:** 14/12  
**Duração:** 2 horas  
**Valor:** 10,0 pontos  

Nome: _________________________________  Matrícula: ________________

Não é permitido material de consulta.

---

## Questão 1 — Boas práticas (2,0)

```java
public class X {
    public int n;
    public void faz(int v) {
        try {
            n = n + v;
        } catch (Exception e) {}
        if (n > 10) n = 10;
    }
}
```

a) (1,2) Aponte **quatro** problemas distintos. Use o vocabulário da disciplina (SRP, encapsulamento, nomes, erro silencioso, magia numérica, …).  
b) (0,8) Reescreva a classe com um nome honesto, atributo privado, validação e **sem** `catch` vazio. A regra de teto 10 pode virar constante.

---

## Questão 2 — Wrappers (2,5)

a) (0,5) Complete: boxing é ________________; unboxing é ________________.  
b) (0,6) Por que `ArrayList<int>` não compila e `ArrayList<Integer>` compila?  
c) (0,7) O que imprimem, **em uma JVM típica** que respeita o cache da JLS:

```java
Integer a = 127, b = 127;
Integer c = 200, d = 200;
System.out.println(a == b);
System.out.println(c == d);
System.out.println(c.equals(d));
```

d) (0,7)

```java
Integer x = null;
int y = x;
```

O que acontece? Em uma frase, o que o compilador inseriu.

---

## Questão 3 — Nota opcional (2,0)

Escreva `static String conceito(Integer media)`:

| media | retorno |
| --- | --- |
| `null` | `"incompleto"` |
| ≥ 9 | `"A"` |
| ≥ 7 | `"B"` |
| ≥ 5 | `"C"` |
| demais | `"D"` |

Não pode lançar `NullPointerException`. Indique onde ocorre (ou não ocorre) unboxing.

---

## Questão 4 — Integração POO (2,0)

No boletim do campus, `Avaliavel` tem `Integer nota()` e `double peso()`. `Atividade` é abstrata e implementa o contrato comum (título, peso). `ProvaEscrita` e `Trabalho` estendem `Atividade`.

a) (0,8) Por que `nota()` devolve `Integer` e não `int`? Relacione com o domínio (nota ainda não lançada).  
b) (0,6) `Boletim.media` percorre `ArrayList<Avaliavel>`. Que mecanismo permite tratar prova e trabalho no mesmo laço?  
c) (0,6) Cite **uma** boa prática já visível nesse desenho (SRP, encapsulamento ou composição) e **uma** que seria violada se `Atividade` lesse nota do `Scanner`.

---

## Questão 5 — Depuração (1,5)

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

Boa prova.
