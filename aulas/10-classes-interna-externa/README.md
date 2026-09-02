# Classes internas e externas

**Pré-requisito:** classes, atributos, encapsulamento

## Objetivos

- Distinguir **classe externa** (de primeiro nível, um arquivo) e **classe aninhada** (declarada *dentro* de outra).
- Usar **classe interna** (de instância): ela existe ligada a um objeto da externa e acessa os membros `private`.
- Usar **classe aninhada estática** (`static`): não precisa de objeto da externa.
- Instanciar a interna com `externa.new Interna(...)` e a estática com `new Externa.Estatica(...)`.
- Reconhecer classe **local** e classe **anônima** no nível desta disciplina.

## Roteiro

1. No quadro: duas classes no mesmo arquivo *não* compilam se as duas forem `public`. Uma classe *dentro* da outra, sim — e o motivo não é “economia de arquivo”.
2. Live coding de `Externa` / `Interna`: mostre `externa.new Interna()` e o acesso ao campo `private` da externa.
3. Contraste com `static class`: `new Externa.Util()` sem objeto da externa.
4. Passe o mesmo vocabulário para `Conta` + `Movimento` (domínio da conta).
5. Laboratório: `exercicios.md`.

## 1. Classe externa

A classe **externa** (ou de primeiro nível) é a que você já conhece: um arquivo `Conta.java` com `public class Conta`.

Ela **não** fica dentro de outra classe. O nome completo é só o da classe (e o pacote, quando houver).

## 2. Por que aninhar?

Uma classe aninhada existe quando o tipo **só faz sentido no contexto** da externa, ou quando precisa ver o estado `private` sem abrir getters à toa.

| Forma | Precisa de objeto da externa? | Acesso ao `private` da externa |
| --- | --- | --- |
| Interna (de instância) | sim | sim, do *aquele* objeto |
| Aninhada `static` | não | só membros `static` da externa |
| Local (dentro de um método) | — | o que o método enxerga (variáveis `final` ou efetivamente finais) |
| Anônima | — | o mesmo da local; não tem nome |

Não aninhe por estética. Se `Movimento` for útil sozinho (outro sistema, outro arquivo), ele é classe externa.

## 3. Classe interna (de instância)

Declarada **dentro** da externa, **sem** `static`. Cada objeto interno guarda uma referência oculta para o objeto externo que o criou.

```java
public class Externa {
    private String nome;

    public Externa(String nome) {
        this.nome = nome;
    }

    public class Interna {
        public String apresentar() {
            return "interna de " + nome; // lê o private da externa
        }
    }
}
```

Instanciação:

```java
Externa externa = new Externa("campus");
Externa.Interna interna = externa.new Interna();
```

`new Interna()` **sozinho** no `main` não compila: não há objeto externo.

Se um nome se chocar (atributo da interna e da externa), use `Externa.this.nome`.

## 4. Classe aninhada estática

Com `static`, o aninhamento é só **organização de nome**. Não há objeto externo implícito.

```java
public class Conta {
    public static class Formatador {
        public static String reais(double valor) {
            return "R$ " + valor;
        }
    }
}
```

```java
String texto = Conta.Formatador.reais(10.0);
Conta.Formatador f = new Conta.Formatador();
```

`Formatador` **não** lê `saldo` da conta — não há “esta conta”. Se precisar do saldo, passe a `Conta` por parâmetro ou use uma interna de instância.

## 5. Classe local e anônima

**Local:** declarada *dentro de um método*. Serve para um tipo de uso único, naquele método.

**Anônima:** classe sem nome, criada no `new` de uma superclasse (ou, mais adiante, de uma interface).

```java
Conta amostra = new Conta("000", 0) {
    @Override
    public String toString() {
        return "conta-demo";
    }
};
```

Não é o centro desta aula. Reconheça a sintaxe; o uso pesado volta com contratos (interfaces) e, na prática, muitas anônimas viram lambdas — fora desta ementa.

## 6. No domínio da conta

`Conta` guarda `numero` e `saldo` **privados**. `Movimento` (interna) registra um crédito ou débito e, no texto, cita o número da conta **sem** `getNumero()` público extra.

`Formatador` (estática) formata valor em reais sem depender de uma conta concreta.

## O que executar no projetor

```bash
javac --release 25 -d aulas/10-classes-interna-externa/bin \
  $(find aulas/10-classes-interna-externa/src -name "*.java")
java -cp aulas/10-classes-interna-externa/bin br.edu.ifba.vdc.bsi.lp1.DemoClassesInternas
```

O `DemoClassesInternas` instancia a interna a partir da externa, o movimento lê o `numero` privado e `Conta.Formatador` existe sem `new Conta`.

## Ponte

Uma interna **não** é herança: `Movimento` não *é uma* `Conta`. É um tipo que **vive junto** de uma conta. Herança continua sendo “é um”; aninhamento é “faz sentido só aqui”.
