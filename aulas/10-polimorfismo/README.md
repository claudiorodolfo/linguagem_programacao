# Aula 10 — Polimorfismo

**Data:** 26/10  
**Unidade:** 2  
**Pré-requisito:** aula 09

## Objetivos

- Usar uma referência da **superclasse** para objetos das **subclasses**.
- Explicar **ligação dinâmica** (qual método roda de verdade).
- Percorrer coleções heterogêneas (`Conta[]`, `Midia[]`).
- Usar `instanceof` e downcast **com parcimônia**.
- Ver polimorfismo de `toString` / `equals` como caso de `Object`.

## Roteiro

1. Recupere `ContaCorrente` e `ContaPoupanca`. Declare `Conta c = new ContaCorrente(...)`.
2. Chame `c.sacar(300)`: quem executa? A corrente. Isso é o coração da aula.
3. Monte um `Conta[]` e um método `static void processarSaques(Conta[] contas, double valor)`.
4. Mostre o erro de chamar `render()` em `c` sem downcast — e por que o downcast cheira mal.
5. Laboratório.

## 1. Muitos corpos, uma interface de uso

Polimorfismo aqui: **a mesma mensagem** (`sacar`, `folha`, `toString`) **se comporta de acordo com o objeto real**, não com o tipo da variável.

```java
Conta c1 = new ContaPoupanca("001", 1000, 0.01);
Conta c2 = new ContaCorrente("002", 200, 150);
c1.sacar(50); // regra da poupança (herdada de Conta)
c2.sacar(300); // regra da corrente (sobrescrita)
```

Upcast (`ContaCorrente` → `Conta`) é implícito e seguro.  
Downcast (`Conta` → `ContaCorrente`) é explícito e pode lançar `ClassCastException`.

## 2. Ligação dinâmica

O compilador verifica se o **tipo da referência** tem o método (`c.sacar` ok; `c.render()` não, se `render` só existe na poupança).

A JVM, **na execução**, olha o objeto e escolhe a versão mais específica sobrescrita.

Desenhe:

```
variável: tipo Conta     objeto: ContaCorrente
           │                    │
           │  compilador        │  JVM (runtime)
           ▼                    ▼
        "existe sacar?"      "qual sacar?"
```

## 3. Coleções heterogêneas

```java
Conta[] contas = {
    new ContaPoupanca("001", 500, 0.01),
    new ContaCorrente("002", 100, 200),
    new Conta("003", 50)
};

double total = 0;
for (Conta conta : contas) {
    total += conta.getSaldo();
}
```

O `for` **não** pergunta o tipo concreto para somar saldo. Quando precisar de comportamento específico, **prefira método sobrescrito na hierarquia** a um `switch` de `instanceof`.

## 4. `instanceof` e quando usar

```java
if (conta instanceof ContaPoupanca p) {
    p.render();
}
```

Legítimo em fronteiras (deserializar, UI). Abusivo no meio da regra de negócio: se o banco “rende” só poupança, crie `void aplicarRendimentoMensal()` na superclasse com corpo vazio (ou método concreto só na subclasse chamado por um serviço que já sabe a lista de poupanças).

O cast clássico ` (ContaPoupanca) conta ` ainda existe; na disciplina usamos **pattern matching** (`instanceof Tipo x`). Na aula 11 o `switch` em classe `sealed` elimina o `default` obrigatório (exaustivo).

## 5. Polimorfismo paramétrico? Não nesta ementa

Não precisa de genéricos (`List<T>`) ainda. Se alguém perguntar: “é outro tipo de polimorfismo; aparece nas coleções nativas depois.” Wrappers na aula 15 usam `ArrayList<Integer>` de leve.

## 6. Armadilhas

- **Sobrecarga não é polimorfismo de execução.** `f(Conta)` vs `f(ContaCorrente)` escolhe pelo tipo **da variável** em compilação.
- Atributos **não** são polimórficos: se super e sub declaram `int x`, a referência `Conta` vê o `x` da `Conta`. Por isso atributos ficam `private` e o comportamento vai para método.
- `static` **não** é dinâmico: `Conta.tipo()` esconde, não sobrescreve.

## O que executar no projetor

```bash
javac aulas/10-polimorfismo/src/*.java
java -cp aulas/10-polimorfismo/src DemoPolimorfismo
```

Peça para a turma prever cada saque **antes** de rodar. Depois mostre `FolhaPagamento` com `Funcionario[]`.

## Ponte para a aula 11

E se não fizer sentido instanciar `Conta` “genérica”? E se várias hierarquias diferentes precisarem de `emprestar()`? **Classe abstrata** e **interface** — estudo dirigido na janela 26/10–16/11 (aula 11), junto com o acervo (aula 12).
