package br.edu.ifba.vdc.bsi.lp1;

// Acessar o diretório dos fontes:
// cd aulas/15-boxing-unboxing/src
// Compilar e enviar os .class para a pasta bin:
// javac --release 25 -d bin br/edu/ifba/vdc/bsi/lp1/*.java
// Executar a partir desta pasta, usando bin no classpath:
// java -cp bin br.edu.ifba.vdc.bsi.lp1.ArmadilhasWrapper

/** Comparações que o compilador aceita e a JVM pune. */
public class ArmadilhasWrapper {

    public static int somaPerigosa(Integer a, Integer b) {
        return a + b; // NPE se qualquer um for null
    }

    public static int somaSegura(Integer a, Integer b) {
        int x = a == null ? 0 : a.intValue();
        int y = b == null ? 0 : b.intValue();
        return x + y;
    }

    void main() {
        IO.println("segura(null, 3) = " + somaSegura(null, 3));
        IO.println("segura(2, 3) = " + somaSegura(2, 3));
        IO.println("perigosa(2, 3) = " + somaPerigosa(2, 3));
        // IO.println(somaPerigosa(null, 3));
    }
}
