# Boas práticas de programação

**Unidade:** 3  
**Pré-requisito:** Unidade 2 e depuração e boxing/wrappers (já há código “grande” o bastante para ficar ruim)

## Objetivos

- Nomear tipos, métodos e variáveis de forma honesta.
- Aplicar responsabilidade única, DRY e KISS no nível da disciplina.
- Distinguir comentário útil de ruído; usar Javadoc no contrato público.
- Tratar erros de forma previsível (`IllegalArgumentException`, retornos booleanos).
- Preferir composição a herança quando o “é um” for forçado.
- Revisitar encapsulamento: getters/setters não são o objetivo.

## Roteiro

1. Projete `AntiPadrao.java` (código que funciona e é hostil). Peça reescrita em duplas **antes** da teoria.
2. Nomeie as práticas no quadro, mapeando o que as duplas já fizeram.
3. Mostre a versão em `versao-limpa/`.
4. Laboratório: refatorar, não criar sistema novo.

Esta aula não é Engenharia de Software completa. É o **mínimo profissional** para o restante da graduação.

## 1. Nomes

| Evite | Prefira |
| --- | --- |
| `x`, `aux`, `faz()` | `saldo`, `indice`, `calcularMedia()` |
| `Aluno2`, `ContaNova` | nome que diz o papel (`ContaPoupanca`) |
| `flag`, `ok` | `emprestado`, `saqueAprovado` |
| classe `Util` genérica | tipo do domínio |

Método = **verbo** (ou predicado `is/eh/tem`). Classe = **substantivo**. Constante = `MAX_EMPRESTIMOS`.

Se o nome precisa de comentário para ser entendido, o nome está errado.

## 2. Responsabilidade única (SRP, versão de laboratório)

Uma classe, **um motivo para mudar**.

- `ContaBancaria` não imprime menu, não lê `Scanner`, não grava arquivo.
- `Demo` / `Main` orquestra.
- `Biblioteca` coordena empréstimos; `Livro` não conhece a lista de usuários.

Quando a classe ganha “e também envia e-mail e também gera PDF”, parte.

## 3. DRY e KISS

- **DRY:** a regra de saldo insuficiente em um só método `sacar`; `transferir` chama `sacar` + `depositar`.
- **KISS:** não crie interface `AbstractSingletonProxyFactoryBean` para três contas. Três classes claras vencem um framework improvisado.

## 4. Comentários e Javadoc

```java
// Incrementa i  ← inútil

// A taxa do banco é cobrada só em dia útil; feriado cai no próximo.  ← útil
```

Javadoc no que o **aluno da outra dupla** precisa para usar:

```java
/**
 * Debita {@code valor} se houver saldo. Não permite valor negativo.
 * @return {@code false} se o saque for recusado
 */
public boolean sacar(double valor) { ... }
```

Código morto comentado (método antigo inteiro) não entra no Git da disciplina.

## 5. Erros: não silencie

Ruim:

```java
public void depositar(double v) {
    try { saldo += v; } catch (Exception e) {}
}
```

Melhor, nesta disciplina:

- Pré-condição violada → `IllegalArgumentException` (mensagem em português).
- Operação de negócio recusada (saque sem saldo) → `boolean` ou tipo de resultado, **documentado**.
- Não use exceção para fluxo normal (não lance `SaldoInsuficienteException` em todo saque didático, a menos que a turma já esteja confortável).

Nunca engula `Exception` vazia.

## 6. Encapsulamento de verdade

Já dito na aula de encapsulamento e pacotes: `setSaldo(double)` público destrói a conta.  
Nesta aula: getters em massa (`getA()`, `getB()`, `getC()` para o `main` montar a regra) também espalham a lógica. Prefira `conta.extratoFormatado()` a três getters no `Demo`.

`protected double saldo` da aula de herança: honesto para ensinar herança; em código “limpo”, `private` + `protected void debitar`.

## 7. Composição × herança

Herança é acoplamento forte. Se a frase não é “é um”, **tenha um**.

```java
// Frágil: AlunoUniversitario extends UsuarioBiblioteca extends Pessoa extends ...
// Mais estável:
public class Aluno {
    private Pessoa dados;
    private UsuarioBiblioteca contaBiblioteca;
}
```

Não obrigue composição em toda hierarquia boa (`ContaCorrente extends Conta` continua correta).

## 8. Outros hábitos rápidos

- Magias: `if (p == 14)` → `Livro.PRAZO_DIAS`.
- Métodos longos: se precisa rolar a tela, extraia `private`.
- `null`: rejeite no construtor; não espalhe NPE.
- `equals`/`hashCode` juntos se comparar objetos em coleções (mencione; implementação completa só se der tempo).
- Indentação e `{ }` mesmo em `if` de uma linha — evita o bug do “achei que estava dentro”.
- **`record`** para dados imutáveis (`Endereco`); classe quando o estado muda.
- **`sealed`** quando a hierarquia for um conjunto fechado (toda subclasse nova altera `permits`).
- I/O de console: `IO`, não `Scanner` no modelo.

## 9. Records (revisão)

```java
public record Intervalo(int inicio, int fim) {
    public Intervalo {
        if (fim < inicio) {
            throw new IllegalArgumentException("intervalo invertido");
        }
    }
}
```

O bloco sem parâmetros é o **construtor compacto**: valida, não precisa repetir `this.inicio = inicio`.

## O que executar no projetor

```bash
javac aulas/16-boas-praticas/src/*.java
java -cp aulas/16-boas-praticas/src AntiPadrao

javac aulas/16-boas-praticas/versao-limpa/*.java
java -cp aulas/16-boas-praticas/versao-limpa DemoLimpo
```

## Ponte para integradores da disciplina

Último laboratório do semestre: boletim com wrappers, contratos e uma boa prática (sem `==` em `Integer`, sem NPE). A prova da Unidade 3 vem a seguir.
