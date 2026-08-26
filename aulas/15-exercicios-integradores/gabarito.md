# Gabarito — Aula 15

## Q1

Atividades do demo (confira os números no `DemoBoletim.java`):

- Prova 1: 8,0 peso 2 → 16
- Prova 2: `null` (ignora)
- Trabalho: 6,0 peso 1 → 6

Média = (16+6) / (2+1) = **7,333...**

Se o aluno incluir a prova 2 como 0, a média cai — é o erro que a aula quer expor.

## Q2

Espelhar `Trabalho`. Recalcular pesos.

## Q3

```java
public static String situacao(Estudante e) {
    Integer m = media(e);
    if (m == null) return "cursando";
    double v = m; // ou m.doubleValue() — aqui média pode ser Integer arredondada
    ...
}
```

No código da aula a média é `Double` (melhor). Ajuste o enunciado da Q3 se usar `Double`: a ideia é o `null`. Ver `Boletim.media` que devolve `Double`.

Critério: não unboxar `Double`/`Integer` nulo.

## Q4

```java
static double somaNotas(Avaliavel[] v, int i) {
    if (v == null || i >= v.length) return 0;
    Integer n = v[i].nota();
    double agora = n == null ? 0 : n.doubleValue();
    return agora + somaNotas(v, i + 1);
}
```

Isto **não** é a média (ignora pesos). Para pesos, outro método recursivo `somaPesos` só de quem tem nota.

## Q5

`temNota` = `a != null && a.nota() != null`.

## Q6

Aceite qualquer desenho documentado. Solução limpa: `Boletim.mediaFinal` chama `mediaParcial`; se recuperação, inclui a prova final na segunda passada.

## Q7

```java
public int compareTo(Estudante o) {
    Double m1 = Boletim.media(this);
    Double m2 = Boletim.media(o);
    if (m1 == null && m2 == null) return 0;
    if (m1 == null) return 1;
    if (m2 == null) return -1;
    return Double.compare(m2, m1); // maior média primeiro
}
```

## Q8

Campo `private UsuarioBiblioteca acessoAcervo;` — “é um estudante; tem um cadastro na biblioteca”.
