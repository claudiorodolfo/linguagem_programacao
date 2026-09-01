# Prova da Unidade 1 — Linguagem de Programação 1

**IFBA — Campus Vitória da Conquista**  
**Curso:** Sistemas de Informação  
**Disciplina:** Linguagem de Programação 1 (Java)  
**Data:** 28/09  
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
}
```

e o trecho:

```java
Ponto a = new Ponto();
a.x = 1;
a.y = 2;
Ponto b = a;
Ponto c = new Ponto();
c.x = 1;
c.y = 2;
b.x = 9;
```

a) (0,8) Quais os valores de `a.x`, `b.x` e `c.x` após o trecho? Justifique com as palavras *objeto* e *referência*.  
b) (0,6) O que imprime `a == b`? E `a == c`?  
c) (0,6) Por que `a` e `c` podem ter o mesmo *estado* e mesmo assim `a == c` ser `false`?

---

## Questão 3 — Atributos, construtores e métodos (2,0)

```java
public class Conta {
    static int total = 0;
    String numero;
    double saldo;

    public Conta(String numero) {
        this(numero, 0.0);
    }

    public Conta(String numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
        total++;
    }

    public boolean sacar(double valor) {
        if (valor <= 0 || valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }
}
```

a) (0,7) Depois de `new Conta("001", 100); new Conta("002");`, quanto vale `Conta.total`? O que seria um erro conceitual: ler `saldo` pela classe (`Conta.saldo`)?  
b) (0,7) Por que `this(numero, 0.0)` precisa ser a **primeira** instrução do construtor de um argumento?  
c) (0,6) Escreva um método de instância `boolean transferir(Conta destino, double valor)` que só deposita no destino se o saque na origem funcionar. Assuma que existe `depositar(double)`.

---

## Questão 4 — Encapsulamento e pacotes (1,5)

a) (0,5) Os atributos de uma `ContaBancaria` devem ser `public` ou `private`? Por quê, em uma frase ligada a **invariante**?  
b) (0,5) Por que **não** deve existir `setSaldo(double s)`? O que um atacante faria com ele?  
c) (0,5) A classe `ContaBancaria` está em `br.edu.ifba.conquista.lp1.aula04.modelo` e a Demo em `br.edu.ifba.conquista.lp1.aula04`. Cite **duas** consequências práticas (pasta no disco, `import`, compilação com `-d`).

---

## Questão 5 — Relacionamentos e cardinalidade (1,5)

Uma `Disciplina` possui vários `Aluno` (no máximo 50). Cada aluno tem `nome` (String) e `media` (double). Cada aluno tem **um** `Endereco`.

a) (0,8) Escreva o esqueleto de `Disciplina` com: construtor que recebe o nome da disciplina; `boolean matricular(Aluno a)`; `double mediaDaTurma()`. Você pode usar arranjo. Atributos `private`.  
b) (0,7) Classifique Disciplina–Aluno e Aluno–Endereco (associação, agregação ou composição) **e** a cardinalidade (1–1, 1–N). Justifique com o ciclo de vida.

---

## Questão 6 — Diagrama de classes UML (1,5)

Um `Pedido` é composto por vários `ItemPedido` (máximo 20). Cada item tem nome (`String`), quantidade (`int`) e preço unitário (`double`). O pedido tem `numero` (`String`) e a operação `total(): double`.

a) (0,9) Desenhe o diagrama de classes: caixas com visibilidade, losango **adequado** ao ciclo de vida, multiplicidades nas pontas.  
b) (0,6) No Java, o método `adicionarItem` deve fazer `new ItemPedido(...)` **dentro** do pedido. Relacione essa escolha ao losango que você desenhou.

---

Boa prova.
