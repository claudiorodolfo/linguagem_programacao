# Recursividade

**Pré-requisito:** Unidade 1 (métodos, arranjos)

## Objetivos

- Identificar caso-base e caso recursivo.
- Relacionar recursão à **pilha de execução** (quadros de chamada). A aula de depuração volta a essa pilha no depurador.
- Implementar algoritmos recursivos clássicos e comparar com a versão iterativa.
- Reconhecer risco de `StackOverflowError` e explosão de chamadas (Fibonacci ingênuo).

## Roteiro

1. Desenhe os quadros na lousa: `fat(4)` espera `fat(3)`, … até `fat(1) = 1`, depois os retornos multiplicam.
2. Se a IDE estiver à mão, chame `fatorial(4)` com breakpoint em `return n * fatorial(n - 1)` e **step into**. A call stack cresce — a aula de depuração sistematiza o depurador.
3. Live coding: palíndromo e busca binária.
4. Mostre Fibonacci recursivo vs. iterativo (tempo).
5. Laboratório.

Abre a Unidade 2. A herança vem na aula de herança.

## 1. Ideia

Um método é recursivo quando **chama a si mesmo** para um problema **menor**, e sabe resolver o menor de todos **sem** se chamar (caso-base).

Checklist no quadro:

1. O problema menor é da **mesma natureza**?
2. Há caso-base que **encerra**?
3. Cada chamada se aproxima do caso-base?
4. Depois do retorno, combino o resultado corretamente?

Se faltar o item 2 ou 3: `StackOverflowError`.

## 2. Fatorial

\[
n! =
\begin{cases}
1 & \text{se } n = 0 \text{ ou } n = 1 \\
n \times (n-1)! & \text{se } n > 1
\end{cases}
\]

```java
static long fatorial(int n) {
    if (n < 0) {
        throw new IllegalArgumentException("n >= 0");
    }
    if (n == 0 || n == 1) {
        return 1; // caso-base
    }
    return n * fatorial(n - 1); // caso recursivo
}
```

`long` porque `20!` já não cabe em `int`. `21!` não cabe em `long`. `BigInteger` fica de fora.

## 3. A pilha

Para `fatorial(4)`:

```
fat(4) → 4 * fat(3)
           fat(3) → 3 * fat(2)
                      fat(2) → 2 * fat(1)
                                 fat(1) → 1
```

Cada chamada ocupa um **quadro** (parâmetros, variáveis locais, endereço de retorno). Recursão profunda demais esgota a pilha. Java não garante otimização de chamada de cauda.

No depurador (opcional hoje; obrigatório na aula de depuração): step into até o caso-base; step out / resume vendo os retornos.

## 4. Recursão sobre arranjos e strings

Padrão: reduza o **intervalo** `[inicio, fim]`, não copie o vetor inteiro a cada chamada (isso é caro e esconde o índice).

Busca binária recursiva (vetor **ordenado**):

- Caso-base: intervalo vazio → não achou; meio igual ao alvo → achou.
- Recursivo: metade esquerda ou direita.

Palíndromo: compare extremos e recua para o miolo.

## 5. Fibonacci: o contraexemplo famoso

```java
static long fib(int n) { // fácil de escrever, inviável para n grande
    if (n <= 1) return n;
    return fib(n - 1) + fib(n - 2);
}
```

A árvore de chamadas **repete** trabalho (`fib(5)` calcula `fib(3)` várias vezes). Versão iterativa (ou com memoização) é linear. Use isto para dizer: **recursivo não é automaticamente elegante nem rápido**.

## 6. Recursão versus iteração

| | Recursão | Iteração |
| --- | --- | --- |
| Quando brilha | estrutura auto-similar (árvore, divisão e conquista) | laços simples, desempenho previsível |
| Custo extra | pilha, cada chamada |
| Risco | estouro de pilha, explosão exponencial | laço infinito |

Nesta disciplina ainda não há árvores (isso é outra ementa). Recursão vale por si: divide-and-conquer, palíndromo, potenciação.

## 7. Potência e Torre de Hanói

`potencia(base, exp)`: caso-base `exp == 0 → 1`; recursivo `base * potencia(base, exp - 1)`. Versão logarítmica (`exp` par → quadrado) é desafio.

Hanói com 3 discos: o número de movimentos é \(2^n - 1\). `n = 30` é inviável na prática.

## O que executar no projetor

```bash
javac --release 25 -d aulas/11-recursividade/bin \
  $(find aulas/11-recursividade/src -name "*.java")
java -cp aulas/11-recursividade/bin br.edu.ifba.vdc.bsi.lp1.DemoRecursao
```

Depure `Fatorial.calcular(4)` e rode `DemoRecursao`. `Fibonacci.ingenuo(40)` pode travar a máquina; 35 já é lento.

## Ponte para herança

Recursão resolve um problema **menor da mesma natureza**. Herança resolve um tipo **mais específico da mesma família** (`ContaPoupanca` *é uma* `Conta`). Não misture os dois vocabulários.
