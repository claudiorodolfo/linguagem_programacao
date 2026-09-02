package br.edu.ifba.vdc.bsi.lp1;

// Acessar o diretório dos fontes:
// cd aulas/11-recursividade/src
// Compilar e enviar os .class para a pasta bin:
// javac --release 25 -d bin br/edu/ifba/vdc/bsi/lp1/*.java
// Executar a partir desta pasta, usando bin no classpath:
// java -cp bin br.edu.ifba.vdc.bsi.lp1.DemoRecursao

/**
 * Execute no projetor. Para ver a pilha: coloque breakpoint em Fatorial.calcular
 * e use Step Into com n = 4.
 */
public class DemoRecursao {

    void main() {
        IO.println("""
                4! = %s
                2^10 linear = %s
                2^10 log    = %s
                arara? %s
                ifba?  %s
                """.formatted(
                Fatorial.calcular(4),
                Potencia.linear(2, 10),
                Potencia.logaritmica(2, 10),
                Palindromo.verificar("arara"),
                Palindromo.verificar("ifba")));

        int[] ordenado = {2, 4, 6, 8, 10, 12};
        IO.println("busca 8: " + BuscaBinaria.buscar(ordenado, 8));
        IO.println("busca 7: " + BuscaBinaria.buscar(ordenado, 7));

        IO.println("fib ingenuo(10) = " + Fibonacci.ingenuo(10));
        IO.println("fib iter(10)    = " + Fibonacci.iterativo(10));

        long t0 = System.currentTimeMillis();
        long f35i = Fibonacci.iterativo(35);
        long t1 = System.currentTimeMillis();
        long f35r = Fibonacci.ingenuo(35);
        long t2 = System.currentTimeMillis();
        IO.println("fib(35) iter = " + f35i + " em " + (t1 - t0) + " ms");
        IO.println("fib(35) rec  = " + f35r + " em " + (t2 - t1) + " ms");

        IO.println("\nHanói com 3 discos:");
        Hanoi.mover(3, 'A', 'C', 'B');
    }
}
