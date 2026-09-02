# Exercícios integradores de POO

**Pré-requisito:** recursividade, herança, polimorfismo e interfaces

## Objetivos

- Reunir herança, polimorfismo, classe abstrata e interface **num único problema**.
- Ler código de terceiros (o `src/` desta aula) e estendê-lo sem reescrever tudo.
- Identificar o ponto certo para um novo tipo (nova subclasse vs. novo contrato).

Não há tópico teórico novo. Use como laboratório longo (estudo dirigido, se não houver encontro presencial): leia o `src/`, estenda o acervo, compare com o gabarito só depois.

## O sistema: acervo do campus

Pacote conceitual (arquivos no mesmo `src/`, sem package, para compilação simples):

| Tipo | Papel |
| --- | --- |
| `ItemAcervo` | classe **abstrata selada** (`permits Livro, Revista, ObraConsulta`): código, título, `resumo()` |
| `Emprestavel` | **interface**: emprestar / devolver / disponível |
| `Livro` | extends `ItemAcervo`, implements `Emprestavel` — prazo 14 dias |
| `Revista` | extends `ItemAcervo`, implements `Emprestavel` — prazo 7 dias |
| `ObraConsulta` | extends `ItemAcervo` — **não** é emprestável (só consulta local) |
| `UsuarioBiblioteca` | nome, matrícula, limite de itens |
| `Emprestimo` | associa usuário + item + dias de prazo |
| `Biblioteca` | cadastro de itens e usuários; `emprestar`, `devolver`, `relatorio()` |
| `DemoAcervo` | cenário pronto para o projetor |

Regras já implementadas:

1. Só se empresta o que `implements Emprestavel` e está disponível.
2. `ObraConsulta` não entra no fluxo de empréstimo (o compilador impede se você só aceita `Emprestavel`).
3. Usuário tem limite (default 3).
4. `Biblioteca.relatorio()` percorre `ItemAcervo[]` e imprime `resumo()` — polimórfico.

## Roteiro (estudo dirigido)

1. Execute `DemoAcervo` e desenhe o diagrama (abstrata, interface, subclasses) no caderno.
2. Resolva `exercicios.md`, alterando e ampliando o sistema. Não abra o gabarito antes.
3. Compare Q2 e Q4 com o gabarito.

## Diagrama para a lousa

```
                 «abstract»
                 ItemAcervo
                 resumo()
               /     |      \
          Livro   Revista   ObraConsulta
             \      / 
          «interface» Emprestavel
```

`Notebook` (exercício) implementa `Emprestavel` **sem** ser `ItemAcervo` — o mesmo gancho da aula de interfaces e classes abstratas.

## Compilar

```bash
javac --release 25 -d aulas/12-exercicios-integradores-poo/out \
  $(find aulas/12-exercicios-integradores-poo/src -name "*.java")
java -cp aulas/12-exercicios-integradores-poo/out br.edu.ifba.vdc.bsi.lp1.DemoAcervo
```

