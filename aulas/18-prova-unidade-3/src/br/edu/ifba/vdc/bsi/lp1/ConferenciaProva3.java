package br.edu.ifba.vdc.bsi.lp1;

public class ConferenciaProva3 {

    void main() {
        Integer a = 127, b = 127;
        Integer c = 200, d = 200;
        IO.println("127 == " + (a == b));
        IO.println("200 == " + (c == d));
        IO.println("200 equals " + c.equals(d));

        IO.println(conceito(null));
        IO.println(conceito(9));
        IO.println(conceito(7));
        IO.println(conceito(5));
        IO.println(conceito(4));

        Integer[] v = { 1, null, 3, null };
        IO.println("nulos = " + contarNulos(v, 0));
    }

    static String conceito(Integer media) {
        if (media == null) {
            return "incompleto";
        }
        int m = media;
        if (m >= 9) return "A";
        if (m >= 7) return "B";
        if (m >= 5) return "C";
        return "D";
    }

    static int contarNulos(Integer[] v, int i) {
        if (i >= v.length) {
            return 0;
        }
        int agora = v[i] == null ? 1 : 0;
        return agora + contarNulos(v, i + 1);
    }
}
