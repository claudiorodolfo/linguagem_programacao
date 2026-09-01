# Ambiente de desenvolvimento

## JDK

A disciplina usa **Java 25** (LTS). Verifique no terminal:

```bash
java -version
javac -version
```

A primeira linha deve conter `25`. Se aparecer 11, 17 ou 21, os exemplos com `IO`, `void main()` e `super(...)` depois de validação **não compilam**.

Instalação sugerida (Adoptium Temurin 25):

- **macOS:** [Temurin](https://adoptium.net/) ou `brew install --cask temurin@25`
- **Windows:** instalador Temurin 25 (marque *Set JAVA_HOME* e *Add to PATH*)
- **Linux:** pacote `temurin-25-jdk` da Adoptium, ou o SDK da distribuição equivalente

Na IDE, defina o *Project SDK* e o *language level* para **25**.

## IDE

Qualquer uma destas opções serve. Escolha **uma** e mantenha a turma alinhada nas primeiras semanas:

| IDE | Quando usar |
| --- | --- |
| IntelliJ IDEA Community | Depuração confortável; recomendada a partir da aula 14. Language level 25. |
| Eclipse | Tradicional em disciplinas de SI; compiler compliance 25 |
| VS Code + Extension Pack for Java | Máquinas com pouca RAM; `java.configuration.runtimes` apontando para o 25 |
| Linha de comando (`javac` / `java`) | Sempre disponível; usada nos roteiros |

## Primeiro programa

Arquivo compacto `OlaIfba.java` (Java 25):

```java
void main() {
    IO.println("Linguagem de Programação 1 — IFBA Conquista");
}
```

```bash
java OlaIfba.java          # executa direto (source-file mode)
# ou
javac OlaIfba.java
java OlaIfba
```

A forma com classe explícita e a forma clássica `public static void main` estão em [`java25.md`](java25.md).

## Estrutura típica de um projeto na disciplina

Nas aulas sem pacote, todos os `.java` ficam em `src/` e compilam juntos. Nas aulas com pacote (a partir da aula 04), a árvore de diretórios espelha o `package`.

## Atalhos úteis de depuração (aula 14)

| Ação | IntelliJ | Eclipse | VS Code |
| --- | --- | --- | --- |
| Iniciar debug | Shift+F9 | F11 | F5 |
| Step over | F8 | F6 | F10 |
| Step into | F7 | F5 | F11 |
| Step out | Shift+F8 | F7 | Shift+F11 |
| Resume | F9 | F8 | F5 |
