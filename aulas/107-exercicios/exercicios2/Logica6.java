/*
Q6 — Menu com do-while
Crie um menu com as opções:
1 - Celsius → Fahrenheit;
2 - Fahrenheit → Celsius;
3 - Sair.
Utilize F = C × 9/5 + 32 e C = (F - 32) × 5/9.
Valide opção inválida. O menu deve continuar até a escolha de Sair.
*/
/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios2/"
javac Logica6.java -d bin
java -cp bin Logica6
*/


void main() {
    int opcao;

    do {
        IO.println("""
                1 - Celsius → Fahrenheit
                2 - Fahrenheit → Celsius
                3 - Sair
                """);

        opcao = Integer.parseInt(IO.readln("Opção: "));

        switch (opcao) {
            case 1 -> {
                double c = Double.parseDouble(
                    IO.readln("Celsius: ")
                );

                double f = c * 9 / 5 + 32;

                IO.println("Fahrenheit: " + f);
            }

            case 2 -> {
                double f = Double.parseDouble(
                    IO.readln("Fahrenheit: ")
                );

                double c = (f - 32) * 5 / 9;

                IO.println("Celsius: " + c);
            }

            case 3 -> IO.println("Programa encerrado.");

            default -> IO.println("Opção inválida.");
        }

    } while (opcao != 3);
}