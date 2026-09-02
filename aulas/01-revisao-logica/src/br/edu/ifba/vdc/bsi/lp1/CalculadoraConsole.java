package br.edu.ifba.vdc.bsi.lp1;

/**
 * Mini calculadora de console — text block, switch expressão e IO.readln (Java 25).
 */
public class CalculadoraConsole {

    void main() {
        int opcao;
        do {
            IO.println("""
                    1) Somar
                    2) Subtrair
                    3) Multiplicar
                    4) Dividir
                    0) Sair
                    """);
            opcao = Integer.parseInt(IO.readln("Opção: ").strip());

            if (opcao >= 1 && opcao <= 4) {
                double a = Double.parseDouble(IO.readln("a: ").strip());
                double b = Double.parseDouble(IO.readln("b: ").strip());
                IO.println("Resultado: " + calcular(opcao, a, b));
            } else if (opcao != 0) {
                IO.println("Opção inválida.");
            }
        } while (opcao != 0);
        IO.println("Até a próxima aula.");
    }

    double calcular(int opcao, double a, double b) {
        return switch (opcao) {
            case 1 -> a + b;
            case 2 -> a - b;
            case 3 -> a * b;
            case 4 -> {
                if (b == 0.0) {
                    IO.println("Divisão por zero não é permitida; devolvendo 0.");
                    yield 0.0;
                }
                yield a / b;
            }
            default -> 0.0;
        };
    }
}
