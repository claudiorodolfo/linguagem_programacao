# Guia rápido do docente

Como usar este repositório semana a semana, sem reler tudo.

## Antes do semestre

1. Confira **JDK 25** nas máquinas do laboratório ([`ambiente.md`](ambiente.md), [`java25.md`](java25.md)). Language level 25 na IDE.
2. Publique o repositório (GitHub Classroom, GitLab do IFBA ou pasta compartilhada).
3. **Não** publique os `gabarito.md` no mesmo momento que os exercícios, se quiser que o laboratório valha. Opções: branch `gabaritos` privada; ou zip só para você.
4. Imprima ou exporte as provas com antecedência (pastas `prova-unidade-2` e `prova-unidade-3`).

## Em cada encontro

| Arquivo | Uso |
| --- | --- |
| `README.md` da aula | Roteiro de 4 h + teoria no projetor |
| `src/` | Live coding; classe `Demo...` no final |
| `exercicios.md` | Laboratório; trilha casa no fim |
| `gabarito.md` | Depois, no fechamento ou no atendimento |

Siga o bloco do [`plano-de-ensino.md`](../plano-de-ensino.md): teoria → intervalo → laboratório → fechamento.

## Dois fios condutores

Não mude o vocabulário toda semana:

- **Conta bancária** — encapsulamento, debug, herança, boas práticas.
- **Biblioteca / acervo do campus** — relacionamentos, interfaces, integrador da Unidade 2.

A Unidade 3 fecha com o **boletim** (wrappers + `null` = nota não lançada).

## Feriados e recessos

Siga o calendário do campus. Este repositório não marca dia/mês. Se houver janela longa sem encontro na Unidade 2, as interfaces e os integradores de POO servem como estudo dirigido.

## Compilação

```bash
./compilar.sh aulas/02-poo-classes-objetos DemoClassesObjetos
./compilar-tudo.sh   # checagem sua, gera .class (já no .gitignore)
```

As aulas usam o pacote `br.edu.ifba.vdc.bsi.lp1`. O comando está no `README.md` de cada uma; na raiz, `./compilar.sh`.

## Provas

Cada pasta de prova tem mapa de competências. Após aplicar, compare com o gabarito.

## O que este material não cobre (de propósito)

- JavaFX / Android / Spring
- Estruturas de dados (listas encadeadas, árvores) — outra ementa
- Genéricos além de `ArrayList<Integer>`
- Concorrência, I/O em arquivo, JDBC
