# Interfaces e classes abstratas

**Pré-requisito:** herança e polimorfismo

## Objetivos

- Declarar classe **abstrata** e método abstrato; impedir `new` da superclasse conceitual.
- Declarar **interface** como contrato (o “o quê”, sem o “como”).
- Implementar várias interfaces; contrastar com herança simples.
- Escolher entre abstrata, interface e classe concreta.
- Fechar hierarquias com `sealed` / `permits` / `final` / `non-sealed`.
- Usar método `default` na interface.

## Roteiro (estudo dirigido)

Leia este `README.md`, compile o `src/` e faça `exercicios.md` até a prova da Unidade 2. Use como estudo dirigido se o calendário não couber um encontro presencial.

Sugestão de ordem:

1. `new Conta(...)` ainda faz sentido no banco didático? Muitas vezes não: só corrente ou poupança. Torne `Conta` abstrata.
2. Método `aplicarTaxasMensais()` sem implementação comum → `abstract`.
3. Biblioteca: livro, revista e *equipamento* (notebook) se emprestam. Não há superclasse natural comum além de `Object`. Interface `Emprestavel`.
4. Laboratório: `exercicios.md`.

## 1. Classe abstrata

```java
public abstract sealed class Conta permits ContaPoupanca, ContaCorrente {
    public abstract void aplicarTaxasMensais();
    public boolean sacar(double valor) { ... } // concreto, herdado
}
```

- Não se instancia: `new Conta()` deixa de compilar.
- **`sealed` + `permits`**: a hierarquia é fechada. Toda subclasse permitida deve ser `final`, `sealed` ou `non-sealed`. `Retangulo` nesta aula é `non-sealed` para o exercício do quadrado ainda poder estendê-lo. Nova conta exige alterar `permits`.
- Pode ter atributos, construtor, métodos concretos e abstratos.
- Subclasse concreta **é obrigada** a implementar os abstratos (ou ser abstrata também).
- Serve quando há **código compartilhado** + **buraco** que cada subtipo preenche.

`aplicarTaxasMensais`: poupança rende; corrente cobra tarifa; salário não faz nada (`{}`).

## 2. Interface

```java
public interface Emprestavel {
    boolean emprestar(String usuario);
    void devolver();
    boolean isDisponivel();
}
```

Antes do Java 8, **todos** os métodos eram `public abstract`. Hoje `default` e `static` são normais (usamos `status()` nesta aula). Constantes: `public static final` implicitamente.

```java
public class Livro implements Emprestavel { ... }
public class Notebook implements Emprestavel { ... }
```

Uma classe pode `implements A, B, C`. Uma interface pode `extends` outras interfaces.

Polimorfismo:

```java
Emprestavel[] itens = { new Livro(...), new Notebook(...) };
for (Emprestavel item : itens) {
    item.emprestar("Ana");
}
```

O tipo da referência é o **contrato**. O objeto traz a implementação.

## 3. Quando usar o quê

| Preciso de… | Use |
| --- | --- |
| Estado compartilhado + algoritmo parcial | classe abstrata |
| Só o contrato; várias origens de herança | interface |
| Ambos | abstrata **e** interface (ex.: `Midia` abstrata + `Emprestavel`) |
| Implementação única e instanciável | classe concreta |

Frase de ouro: **programe para o contrato** (`Emprestavel`, `Conta`), não para o concreto (`Livro`, `ContaCorrente`), quando o cliente não precisa do extra.

## 4. Interface × abstrata (prova)

| | Classe abstrata | Interface |
| --- | --- | --- |
| Herança | uma só (`extends`) | várias (`implements`) |
| Atributos de instância | sim | não (só constantes) |
| Construtor | sim | não |
| Métodos concretos | sim | `default` e `static` (habituais no 25) |
| Relação | “é um” | “sabe fazer” / “pode ser tratado como” |

## 5. `default` (visão rápida)

```java
public interface Emprestavel {
    boolean emprestar(String usuario);
    default String status() {
        return isDisponivel() ? "livre" : "ocupado";
    }
    boolean isDisponivel();
}
```

Útil para evoluir contrato sem quebrar implementações antigas. Conflito de `default` em duas interfaces fica de fora.

## 6. `Comparable` (gancho)

```java
public class Livro implements Comparable<Livro> {
    public int compareTo(Livro outro) {
        return this.titulo.compareTo(outro.titulo);
    }
}
```

`Arrays.sort(livros)` passa a funcionar. É interface da API — mostra que o mecanismo que vocês escreveram é o mesmo do Java.

## O que executar no projetor

```bash
javac aulas/09-interfaces-classes-abstratas/src/*.java
java -cp aulas/09-interfaces-classes-abstratas/src DemoContratos
```

Instancie contas concretas, chame `aplicarTaxasMensais` num `Conta[]`. Em seguida empreste um livro e um notebook pela mesma variável `Emprestavel`.

## Ponte para integradores de POO

Não há encontro extra obrigatório: a aula de integradores de POO é **estudo dirigido** (laboratório do acervo). Integra herança, polimorfismo e contratos num mini sistema da biblioteca. Em seguida vem a prova da Unidade 2.
