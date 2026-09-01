# Convenções da disciplina

Adote estas regras no quadro e nos exercícios. Elas reaparecem na aula de boas práticas.

## Nomes

| Elemento | Convenção | Exemplo |
| --- | --- | --- |
| Classe | PascalCase, substantivo | `ContaBancaria`, `Livro` |
| Método | camelCase, verbo | `sacar`, `calcularMedia` |
| Variável / atributo | camelCase | `saldo`, `quantidadePaginas` |
| Constante | MAIÚSCULAS com `_` | `TAXA_SAQUE`, `MAX_EMPRESTIMOS` |
| Pacote | minúsculas, domínio invertido | `br.edu.ifba.conquista.lp1.aula04` |

## Visibilidade

- Atributos: `private` (salvo constante `public static final`).
- Métodos de negócio: `public` quando fizerem parte do contrato; `private` quando forem detalhe interno.
- `protected`: só quando houver herança e o subtipo precisar do membro.

## Comentários

- Explique **por quê**, não o óbvio.
- Javadoc em classes e métodos públicos usados pelos estudantes.

```java
/** Debita valor da conta se houver saldo suficiente. */
public boolean sacar(double valor) { ... }
```

## Organização

- Uma classe pública por arquivo, com o mesmo nome do arquivo.
- Classe `Demo...` em cada aula: ponto de entrada `void main()` (Java 25).
- I/O de console com `IO.readln` / `IO.println`. Não misture leitura no modelo; leia no `main` e passe valores.
- `record` para dados imutáveis sem regra de negócio (`Endereco`). Classe quando houver invariante (`Conta`).

## Compilação

Prefira mostrar `javac` no primeiro mês, mesmo que a IDE compile sozinha. Isso evita a ideia de que “o botão verde é a linguagem”.
