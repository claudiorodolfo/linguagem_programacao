# Prova da Unidade 2 — Linguagem de Programação 1

**IFBA — Campus Vitória da Conquista**  
**Curso:** Sistemas de Informação  
**Disciplina:** Linguagem de Programação 1 (Java)  
**Data:** _________________________________  
**Duração:** 2 horas  
**Valor:** 10,0 pontos  

Nome: _________________________________  Matrícula: ________________

Não é permitido material de consulta.

---

## Questão 1 — Herança (2,0)

```java
public class Veiculo {
    protected int velocidade;
    public Veiculo() { velocidade = 0; }
    public void acelerar(int delta) { velocidade += delta; }
    public int getVelocidade() { return velocidade; }
}

public class CarroEsportivo extends Veiculo {
    @Override
    public void acelerar(int delta) {
        super.acelerar(delta * 2);
    }
}
```

a) (0,7) O que imprime o trecho abaixo? Justifique citando **sobrescrita**.

```java
Veiculo v = new CarroEsportivo();
v.acelerar(10);
System.out.println(v.getVelocidade());
```

b) (0,7) Por que `super.acelerar(...)` é necessário (ou pelo menos útil) aqui? O que aconteceria num `acelerar` que fizesse `velocidade += delta * 2` **sem** chamar `super`, se amanhã a superclasse ganhasse um limite de velocidade no `acelerar`?

c) (0,6) Construtores são herdados? O que a subclasse deve fazer se `Veiculo` só tiver `Veiculo(int velocidadeInicial)`?

---

## Questão 2 — Polimorfismo (2,0)

```java
public abstract class Pagamento {
    public abstract double taxa(double valor);
}

public class Pix extends Pagamento {
    public double taxa(double valor) { return 0; }
}

public class Cartao extends Pagamento {
    public double taxa(double valor) { return valor * 0.03; }
}

public class Boleto extends Pagamento {
    public double taxa(double valor) { return 2.50; }
}
```

a) (0,8) Escreva `static double totalTaxas(Pagamento[] ps, double valor)` que soma as taxas para o mesmo `valor` em todos os pagamentos. **Proibido** `instanceof`.

b) (0,6) Por que `Pagamento` ser abstrata é melhor do que uma classe concreta com `taxa` retornando 0?

c) (0,6)

```java
static void imprime(Pagamento p) { System.out.println("P"); }
static void imprime(Pix p) { System.out.println("X"); }

Pagamento p = new Pix();
imprime(p);
```

O que é impresso? Sobrecarga ou sobrescrita?

---

## Questão 3 — Código (2,5)

No acervo do campus, `ItemAcervo` é `abstract sealed` com `resumo()` e `permits Livro, Revista, ObraConsulta`. `Emprestavel` declara `emprestar`, `devolver`, `isDisponivel`, `prazoDias()`. `Livro` já existe (prazo 14).

Implemente a classe **`JogoTabuleiro`**: é item de acervo **e** emprestável, com atributo `int numeroPecas`, prazo de **10** dias. Inclua construtor, os métodos exigidos pelos contratos **e** o ajuste em `permits`. `resumo()` deve conter título e número de peças.

---

## Questão 4 — Contratos (2,0)

a) (1,0) Complete a tabela com **sim** ou **não**:

| | Classe abstrata | Interface (Java 25) |
| --- | --- | --- |
| Pode ter atributos de instância |  |  |
| Pode ter construtor |  |  |
| Uma classe pode ter várias |  |  |
| Pode ser instanciada com `new` |  |  |
| Pode ser `sealed` |  |  |

b) (1,0) `Livro` e `Notebook` (patrimônio do NTI) precisam de `emprestar/devolver`. Defenda **interface** `Emprestavel` em vez de uma superclasse comum `CoisaEmprestavel`. Duas razões.

---

## Questão 5 — Integração (1,5)

a) (0,8) `ObraConsulta extends ItemAcervo` **não** implementa `Emprestavel`. A `Biblioteca.emprestar` recebe `Emprestavel`. Explique como o **compilador** impede o empréstimo de uma obra de consulta.

b) (0,7) Escreva um método **recursivo** `static int disponiveis(Emprestavel[] v, int i)` que conta quantos itens a partir do índice `i` estão disponíveis. Caso-base: índice fora do arranjo. Assuma que não há `null` no intervalo válido `0 .. v.length-1`.

---

Boa prova.
