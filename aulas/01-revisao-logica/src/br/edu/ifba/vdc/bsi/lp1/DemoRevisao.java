package br.edu.ifba.vdc.bsi.lp1;

/**
 * Demonstração da revisão de lógica em Java 25.
 * Percorra os métodos no projetor; comente chamadas para focar um tópico.
 */
public class DemoRevisao {

    void main() {
        tiposEOperadores();
        decisao(8.2);
        lacoTabuada(4);
        arranjoEBusca();
        IO.println("Máximo: " + maximo(3, 9, 6));
        IO.println("2024 bissexto? " + ehBissexto(2024));
        IO.println("Conceito 6.5: " + conceito(6.5));
    }

    void tiposEOperadores() {
        int quantidade = 5;
        int grupos = 2;
        IO.println("Divisão inteira 5/2 = " + (quantidade / grupos));
        IO.println("Divisão real 5/2 = " + (quantidade / (double) grupos));

        double media = 7.5;
        boolean aprovado = media >= 7.0;
        IO.println("Aprovado? " + aprovado);
    }

    void decisao(double media) {
        if (media >= 7.0) {
            IO.println("Situação: aprovado");
        } else if (media >= 5.0) {
            IO.println("Situação: recuperação");
        } else {
            IO.println("Situação: reprovado");
        }
    }

    void lacoTabuada(int k) {
        IO.println("Tabuada de " + k);
        for (int i = 1; i <= 10; i++) {
            IO.println("%d x %d = %d".formatted(k, i, k * i));
        }
    }

    void arranjoEBusca() {
        int[] notas = {7, 5, 9, 6, 8};
        int alvo = 9;
        int posicao = -1;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] == alvo) {
                posicao = i;
                break;
            }
        }
        IO.println("9 encontrado no índice " + posicao);

        int soma = 0;
        for (int nota : notas) {
            soma += nota;
        }
        IO.println("Média da amostra: " + (soma / (double) notas.length));
    }

    int maximo(int a, int b, int c) {
        int m = a;
        if (b > m) {
            m = b;
        }
        if (c > m) {
            m = c;
        }
        return m;
    }

    boolean ehBissexto(int ano) {
        return ano % 400 == 0 || (ano % 4 == 0 && ano % 100 != 0);
    }

    String conceito(double media) {
        return switch ((int) media) {
            case 10, 9 -> "A";
            case 8, 7 -> "B";
            case 6, 5 -> "C";
            default -> "D";
        };
    }
}
