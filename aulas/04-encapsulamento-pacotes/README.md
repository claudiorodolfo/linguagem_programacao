# Encapsulamento, modificadores de acesso e pacotes

**Pré-requisito:** atributos, construtores e métodos

## Objetivos

- Tornar atributos `private` e expor comportamento por métodos.
- Escolher `public`, `private`, `protected` e o acesso padrão (pacote).
- Organizar classes em **pacotes** e conhecer `import module` (Java 25).
- Proteger **invariantes** (saldo nunca negativo) em vez de escrever setters cegos.

Relacionamentos e cardinalidade ficam na aula de **relacionamentos**.

## Roteiro

1. Ataque ao código da aula de atributos, construtores e métodos: `conta.saldo = -999` no `main`.
2. Refatore ao vivo para `private` + `depositar`/`sacar`. Sem `setSaldo`.
3. Monte o pacote `br.edu.ifba.vdc.bsi.lp1.modelo` no quadro (pastas = pacotes).
4. Execute `DemoEncapsulamento`.

## 1. Encapsulamento

**Encapsular** é reunir dado + regra e impedir que o mundo externo quebre a regra.

| Antes (atributos, construtores e métodos) | Depois |
| --- | --- |
| `conta.saldo = -10;` | impossível: `saldo` é `private` |
| qualquer um altera o estado | só métodos validam o estado |

Getters e setters **não** são o encapsulamento. Encapsulamento é **proteger invariantes** (saldo nunca negativo; livro não empresta duas vezes). Um setter cego (`setSaldo(double s) { this.saldo = s; }`) devolve o furo.

Use getter quando alguém precisa **consultar**. Use setter só quando a mudança for uma operação válida do domínio.

## 2. Modificadores de acesso

| Modificador | Mesma classe | Mesmo pacote | Subclasse (outro pacote) | Mundo |
| --- | --- | --- | --- | --- |
| `private` | sim | não | não | não |
| *(nenhum)* package-private | sim | sim | não | não |
| `protected` | sim | sim | sim | não |
| `public` | sim | sim | sim | sim |

Nesta aula: atributos `private`, métodos de negócio `public`. `protected` volta na aula de herança.

## 3. Pacotes

```java
package br.edu.ifba.vdc.bsi.lp1.modelo;
```

- Espelham pastas: `src/br/edu/ifba/vdc/bsi/lp1/modelo/ContaBancaria.java`
- `import` traz classes de outro pacote.
- Convenção: minúsculas, domínio invertido. Pacote da disciplina: `br.edu.ifba.vdc.bsi.lp1`.

Compilação (a partir da raiz do repositório):

```bash
javac --release 25 -d aulas/04-encapsulamento-pacotes/bin \
  $(find aulas/04-encapsulamento-pacotes/src -name "*.java")
java -cp aulas/04-encapsulamento-pacotes/bin \
  br.edu.ifba.vdc.bsi.lp1.DemoEncapsulamento
```

No Windows PowerShell, compile arquivo a arquivo ou use a IDE.

## 3.1. Módulos e `import module`

Em classes nomeadas, `import` continua explícito. Alternativa Java 25: `import module java.base;` traz de uma vez `List`, `ArrayList`, `BigDecimal`… (JEP 511). Arquivos compactos já fazem isso sozinhos.

Pacote organiza **o seu** código. Módulo (`java.base`, etc.) é a unidade da plataforma: um conjunto de pacotes com fronteira de API. Nesta disciplina basta: pacote = pasta + `package`; módulo entra só nesse `import module` e na conversa de que `java.lang` (inclui `IO`) já está visível.

## 3.2. `record` (dado imutável)

Quando o tipo **só carrega dados** (sem regra de saldo), o Java oferece `record`:

```java
public record Intervalo(int inicio, int fim) {
    public int tamanho() {
        return fim - inicio;
    }
}
```

O compilador gera construtor, acessores (`inicio()`, não `getInicio()`), `equals`, `hashCode` e `toString`. **Não** use `record` para `Conta`: saldo muda. Na aula de relacionamentos o `Endereco` da biblioteca é um `record` (composição + dado imutável).

## 4. Exceções leves nesta aula

`IllegalArgumentException` no construtor (saldo inicial negativo, depósito ≤ 0) é aceitável. Tratamento de erros aprofunda na aula de boas práticas. `IO.println` + recusar a operação também vale.

## O que executar no projetor

O `DemoEncapsulamento` deposita, tenta sacar além do saldo e mostra que `conta.saldo = -10` **não compila**.

## Ponte para relacionamentos

Uma conta isolada não modela o campus. Um usuário **tem** endereço e **vários** empréstimos. Como expressar 1–1, 1–N e o ciclo de vida das partes?
