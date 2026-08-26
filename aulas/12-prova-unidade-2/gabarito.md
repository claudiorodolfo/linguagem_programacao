# Gabarito — Prova da Unidade 2

## Questão 1 (2,0)

a) **20**. A variável é `Veiculo`, o objeto é `CarroEsportivo`; `acelerar` sobrescrito multiplica o delta por 2 e delega a `super`.

b) `super` reutiliza a política da superclasse. Se o aluno só faz `velocidade += delta * 2`, um futuro limite em `Veiculo.acelerar` seria **ignorado** (risco de quebrar o contrato).

c) Construtores **não** são herdados. A subclasse deve chamar `super(velocidadeInicial)`.

## Questão 2 (2,0)

a)

```java
static double totalTaxas(Pagamento[] ps, double valor) {
    double s = 0;
    for (Pagamento p : ps) {
        s += p.taxa(valor);
    }
    return s;
}
```

b) Impede `new Pagamento()` sem política; deixa explícito que todo pagamento **tem** de definir taxa. Um `return 0` concreto esconde tipo incompleto e vira bug silencioso.

c) Imprime `P`. É **sobrecarga** resolvida pelo tipo da referência (`Pagamento`) em compilação.

## Questão 3 (2,5)

Esqueleto esperado (variações de nomes de campo ok):

```java
public final class JogoTabuleiro extends ItemAcervo implements Emprestavel {
    private int numeroPecas;
    private boolean disponivel = true;

    public JogoTabuleiro(String codigo, String titulo, int numeroPecas) {
        super(codigo, titulo);
        this.numeroPecas = numeroPecas;
    }

    @Override
    public String resumo() {
        return getTitulo() + " (" + numeroPecas + " peças)";
    }

    @Override
    public boolean emprestar(String matriculaUsuario) {
        if (!disponivel) return false;
        disponivel = false;
        return true;
    }

    @Override
    public void devolver() { disponivel = true; }

    @Override
    public boolean isDisponivel() { return disponivel; }

    @Override
    public int prazoDias() { return 10; }
}
```

Desconto se faltar `implements`, `extends`, prazo 10 ou o `permits ..., JogoTabuleiro` em `ItemAcervo`. Sem `resumo`: −0,5.

## Questão 4 (2,0)

a)

| | Abstrata | Interface |
| --- | --- | --- |
| Atributos de instância | sim | não (só constantes) |
| Construtor | sim | não |
| Uma classe pode ter várias | não (uma superclasse) | sim |
| `new` | não | não |
| `sealed` | sim | sim |
| Métodos `default`/`static` | concretos na classe | sim (desde 8; usuais no 25) |

b) Razões aceitáveis: (1) livro e notebook **não** são o mesmo “é um”; (2) Java só tem herança simples — o notebook pode já estender `Equipamento`; (3) contrato descreve capacidade, não família; (4) evita hierarquia artificial só para reusar dois métodos.

## Questão 5 (1,5)

a) `ObraConsulta` não é `Emprestavel`; passar `atlas` para `emprestar` é erro de **tipo** em compilação (incompatível). Não é exceção em runtime.

b)

```java
static int disponiveis(Emprestavel[] v, int i) {
    if (i >= v.length) return 0;
    int agora = v[i].isDisponivel() ? 1 : 0;
    return agora + disponiveis(v, i + 1);
}
```
