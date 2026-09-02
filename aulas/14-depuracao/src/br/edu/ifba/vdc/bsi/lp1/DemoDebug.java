package br.edu.ifba.vdc.bsi.lp1;

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
