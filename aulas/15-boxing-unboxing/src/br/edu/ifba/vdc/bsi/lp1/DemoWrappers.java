package br.edu.ifba.vdc.bsi.lp1;

// Acessar o diretório dos fontes:
// cd aulas/15-boxing-unboxing/src
// Compilar e enviar os .class para a pasta bin:
// javac --release 25 -d bin br/edu/ifba/vdc/bsi/lp1/*.java
// Executar a partir desta pasta, usando bin no classpath:
// java -cp bin br.edu.ifba.vdc.bsi.lp1.DemoWrappers

import module java.base;

/**
 * Boxing, unboxing, cache e NPE. Comente explodirNpe() no projetor até a hora certa.
 * {@code import module java.base} (Java 25) traz ArrayList, List, etc.
 */
public class DemoWrappers {

    void main() {
        boxingBasico();
        IO.println();
        cacheDeInteger();
        IO.println();
        listaDeNotas();
        IO.println();
        situacao(null);
        situacao(8); // autoboxing
        situacao(4);
        // explodirNpe();
    }

    static void boxingBasico() {
        int primitivo = 10;
        Integer objeto = Integer.valueOf(primitivo); // boxing explícito — nunca new Integer
        Integer auto = primitivo;                      // autoboxing
        int deVolta = objeto;                          // unboxing
        IO.println("primitivo=%d objeto=%s auto=%s deVolta=%d"
                .formatted(primitivo, objeto, auto, deVolta));
        IO.println("parseInt(\"42\")=" + Integer.parseInt("42"));
        IO.println("MAX_VALUE=" + Integer.MAX_VALUE);
    }

    static void cacheDeInteger() {
        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;
        IO.println("127 == 127 ? " + (a == b) + " equals? " + a.equals(b));
        IO.println("128 == 128 ? " + (c == d) + " equals? " + c.equals(d));
    }

    static void listaDeNotas() {
        ArrayList<Integer> notas = new ArrayList<>(List.of(7, 8, 9)); // boxing em List.of
        int soma = 0;
        for (Integer n : notas) {
            soma += n; // unboxing
        }
        IO.println("média da lista = " + (soma / (double) notas.size()));
        IO.println("primeira (sequenced): " + notas.getFirst()); // Java 21+
    }

    static void situacao(Integer media) {
        if (media == null) {
            IO.println("sem média");
            return;
        }
        IO.println(media >= 7 ? "aprovado (" + media + ")" : "reprovado (" + media + ")");
    }

    static void explodirNpe() {
        Integer idade = null;
        int x = idade; // NPE no unboxing — a mensagem do 14+ cita o unboxing
        IO.println(x);
    }
}
