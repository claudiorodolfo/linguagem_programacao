# Aula 04 — Encapsulamento, pacotes e relacionamentos

**Data:** 24/08  
**Unidade:** 1  
**Pré-requisito:** aula 03

## Objetivos

- Tornar atributos `private` e expor comportamento por métodos.
- Escolher `public`, `private`, `protected` e o acesso padrão (pacote).
- Organizar classes em **pacotes**.
- Identificar associação, agregação e composição, e cardinalidade 1–1, 1–N.

## Roteiro

1. Ataque ao código da aula 03: `conta.saldo = -999` no `main`. Pergunte se isso é aceitável.
2. Refatore ao vivo para `private` + `depositar`/`sacar`.
3. Desenhe UML simplificado: `Usuario` 1 — N `Emprestimo` N — 1 `Livro`.
4. Execute `DemoRelacionamentos` (usa pacotes).
5. Laboratório.

## 1. Encapsulamento

**Encapsular** é reunir dado + regra e impedir que o mundo externo quebre a regra.

| Antes (aula 03) | Depois |
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

Nesta aula: atributos `private`, métodos de negócio `public`. `protected` volta na aula 08.

## 3. Pacotes

```java
package br.edu.ifba.conquista.lp1.aula04.modelo;
```

- Espelham pastas: `src/br/edu/ifba/conquista/lp1/aula04/modelo/Livro.java`
- `import` traz classes de outro pacote.
- Convenção: minúsculas, domínio invertido.

Compilação (a partir da raiz do repositório):

```bash
javac --release 25 -d aulas/04-encapsulamento-relacionamentos/out \
  $(find aulas/04-encapsulamento-relacionamentos/src -name "*.java")
java -cp aulas/04-encapsulamento-relacionamentos/out \
  br.edu.ifba.conquista.lp1.aula04.DemoRelacionamentos
```

No Windows PowerShell, compile arquivo a arquivo ou use a IDE.

Em classes nomeadas, `import` continua explícito. Alternativa Java 25: `import module java.base;` traz de uma vez `List`, `ArrayList`, `BigDecimal`… (JEP 511). Arquivos compactos já fazem isso sozinhos.

## 3.1. `record` (dado imutável)

Quando o tipo **só carrega dados** (sem regra de saldo, sem lista interna), o Java 25 (na verdade desde 16) oferece `record`:

```java
public record Endereco(String logradouro, String cidade, String uf) {
    public String formatado() {
        return "%s — %s/%s".formatted(logradouro, cidade, uf);
    }
}
```

O compilador gera construtor, acessores (`cidade()`, não `getCidade()`), `equals`, `hashCode` e `toString`. **Não** use `record` para `Conta`: saldo muda. `Endereco` nesta aula é composição + record.

## 4. Relacionamentos

Fale em português antes de UML.

| Relacionamento | Ideia | Exemplo desta aula |
| --- | --- | --- |
| **Associação** | objetos se conhecem | `Emprestimo` conhece `Usuario` e `Livro` |
| **Agregação** | “tem um”, mas as partes vivem sozinhas | `Estante` tem `Livro`; o livro existe sem a estante |
| **Composição** | “parte de”, ciclo de vida acoplado | `Pedido` e `ItemPedido`: o item não faz sentido sem o pedido |

Cardinalidade:

- **1–1:** `Usuario` tem um `Endereco`.
- **1–N:** `Usuario` tem vários `Emprestimo`.
- **N–N:** na implementação, vira duas listas ou uma classe associativa (`Emprestimo`).

Na memória: relacionamento é **referência** (campo) ou **coleção de referências** (arranjo / lista). Nesta aula usamos arranjo com capacidade fixa para não exigir `ArrayList` ainda; na aula 11 a biblioteca passa a usar lista.

## 5. Lei de Demeter (versão leve)

Evite cadeias `usuario.getEndereco().getCidade().getUf()`. Prefira `usuario.cidadeFormatada()`. Não cobre isso em prova com o nome da lei; cobre o hábito: **não espalhe a estrutura interna**.

## 6. Diagrama no quadro

```
┌─────────┐       1     N  ┌────────────┐     N     1  ┌───────┐
│ Usuario │───────────────▶│ Emprestimo │─────────────▶│ Livro │
└─────────┘                └────────────┘              └───────┘
      │ 1
      │
      ▼ 1
┌──────────┐
│ Endereco │     (composição: o endereço “nasce” com o usuário)
└──────────┘
```

## O que executar no projetor

O `DemoRelacionamentos` cria dois usuários, três livros, registra empréstimos e tenta emprestar um livro já emprestado (a regra está em `Livro.emprestar()`, não no `main`).

## Ponte para a aula 05

Quando a regra falha no meio do caminho, o `println` não basta. Na próxima aula a turma **pausa** o programa e observa o estado.
