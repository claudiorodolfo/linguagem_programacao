package br.edu.ifba.vdc.bsi.lp1;

// Acessar o diretório dos fontes:
// cd aulas/14-depuracao/src
// Compilar e enviar os .class para a pasta bin:
// javac --release 25 -d bin br/edu/ifba/vdc/bsi/lp1/*.java
// Executar a partir desta pasta, usando bin no classpath:
// java -cp bin br.edu.ifba.vdc.bsi.lp1.DemoDebug

/**
 * Ponto de entrada único para o projetor. Execute cada cenário em debug (não em Run).
 * Os catches existem só para a demo em "Run" não parar no primeiro bug.
 */
public class DemoDebug {

    void main() {
        IO.println("=== Média bugada ===");
        try {
            new MediaBugada().main();
        } catch (RuntimeException e) {
            IO.println(e.getClass().getSimpleName() + ": " + e.getMessage());
            e.printStackTrace();
        }

        IO.println("\n=== Transferência bugada ===");
        new TransferenciaBugada().main();

        IO.println("\n=== Busca bugada ===");
        new BuscaBugada().main();
    }
}
