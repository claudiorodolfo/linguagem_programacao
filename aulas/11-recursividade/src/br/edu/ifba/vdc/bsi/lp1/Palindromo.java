package br.edu.ifba.vdc.bsi.lp1;

public class Palindromo {

    public static boolean verificar(String s) {
        if (s == null) {
            return false;
        }
        return verificar(s, 0, s.length() - 1);
    }

    static boolean verificar(String s, int i, int j) {
        if (i >= j) {
            return true;
        }
        if (s.charAt(i) != s.charAt(j)) {
            return false;
        }
        return verificar(s, i + 1, j - 1);
    }
}
