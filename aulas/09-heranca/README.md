# Aula 09 — Herança

**Data:** 19/10  
**Unidade:** 2  
**Pré-requisito:** Unidade 1 (classes, encapsulamento) e aula 08

## Objetivos

- Criar hierarquias com `extends` e reutilizar código.
- Usar `super` (construtor e método).
- Distinguir **sobrescrita** (`@Override`) de **sobrecarga**.
- Entender `protected` e o que **não** se herda (construtores, membros `private`).
- Conhecer `Object` (`toString`; `equals` entra com calma).

## Roteiro

1. Conta da Unidade 1 no quadro: poupança rende juros, corrente tem cheque especial. Copiar-colar `ContaBancaria`? “Não: especializamos.”
2. Live coding: `Conta` ← `ContaPoupanca`, `ContaCorrente`.
3. Mostre o construtor da subclasse chamando `super(...)`.
4. Redefina `sacar` na corrente (permite negativo até o limite).
5. Laboratório.

## 1. “É um”

Herança modela **especialização**: toda `ContaPoupanca` **é uma** `Conta`. Tudo que vale para conta vale para poupança, mais o que for específico.

Não use herança para “a turma *tem* alunos” — isso é associação (aula 05). Teste da frase: se você não diz “é um” com naturalidade, não é `extends`.

## 2. Sintaxe

```java
public class ContaPoupanca extends Conta {
    private double taxaJuros;

    public ContaPoupanca(String numero, double saldo, double taxaJuros) {
        if (taxaJuros < 0) {                          // prólogo (Java 25)
            throw new IllegalArgumentException("taxa >= 0");
        }
        super(numero, saldo);                         // não precisa mais ser a 1ª linha
        this.taxaJuros = taxaJuros;
    }
}
```

- Java: **uma** superclasse (herança simples).
- Subclasse herda membros `public` e `protected` (e package-private se estiver no mesmo pacote).
- Atributos `private` da superclasse **não** são acessíveis pelo nome na subclasse; use getters ou `protected` com parcimônia.

## 3. `super`

| Uso | Exemplo |
| --- | --- |
| Construtor da superclasse | `super(numero, saldo);` |
| Método original quando você sobrescreveu | `super.sacar(valor);` |

Se a superclasse **não** tem construtor sem argumentos, a subclasse **é obrigada** a chamar `super(...)`. No Java 25 isso **não** precisa ser a primeira linha: o *prólogo* pode validar argumentos (sem usar `this` em métodos de instância). Depois de `super`, vem o *epílogo*.

## 4. Sobrescrita versus sobrecarga

**Sobrescrita:** mesma assinatura na subclasse, comportamento novo. Anote `@Override` — o compilador denuncia erro de digitação.

**Sobrecarga:** mesmo nome, parâmetros diferentes, na mesma classe (ou herdado + nova assinatura). Resolvida em **compilação**.

```java
@Override
public boolean sacar(double valor) { // sobrescrita
    ...
}

public boolean sacar(double valor, String motivo) { // sobrecarga
    ...
}
```

## 5. `protected`

Membro visível na hierarquia (e no pacote). Útil para `saldo` se as subclasses precisam alterar com regra própria — **ou** deixe `private` e ofereça `protected void ajustarSaldo(double delta)` para não espalhar o campo. Nesta aula o código usa `protected double saldo` de propósito, para a turma ver o acesso; na aula 16 discutimos se isso foi uma boa ideia.

## 6. `Object`

Toda classe herda de `Object` se não disser `extends`.

```java
@Override
public String toString() {
    return "Conta " + numero + " saldo=" + saldo;
}
```

Sem `toString`, `System.out.println(conta)` imprime `Conta@1a2b3c`. `equals` e `hashCode` juntos: mencione; implementação completa pode ficar para a aula 16.

## 7. O que herança não é

- Não é desconto de código a qualquer custo (veja *composição em vez de herança* na aula 16).
- Subclasse não deve **quebrar** o contrato da superclasse (poupança que “saca” aumentando o saldo é abuso). Princípio da substituição (Liskov) em versão de uma frase: **onde se espera a superclasse, a subclasse precisa fazer sentido**.

## O que executar no projetor

```bash
javac aulas/09-heranca/src/*.java
java -cp aulas/09-heranca/src DemoHeranca
```

Mostre o saque da corrente abaixo de zero (dentro do limite) e o saque da poupança recusado. Imprima os objetos para ver `toString`.

## Ponte para a aula 10

Hoje cada variável ainda tem o tipo **exato** (`ContaPoupanca p = ...`). Amanhã uma `Conta[]` guarda correntes e poupanças e o `sacar` certo é escolhido **em tempo de execução**.
