package br.edu.ifba.vdc.bsi.lp1;

public class BuscaCorrigida {

    void main() {
        String[] cadastro = {"Ana", "Bruno", "Caio"};
        IO.println("Ana -> " + indiceDe(cadastro, "Ana"));
        IO.println("Caio -> " + indiceDe(cadastro, "Caio"));
        IO.println("Diana -> " + indiceDe(cadastro, "Diana"));
        IO.println("new String(\"Ana\") -> " + indiceDe(cadastro, new String("Ana")));
    }

    static int indiceDe(String[] cadastro, String nome) {
        for (int i = 0; i < cadastro.length; i++) {
            if (cadastro[i].equals(nome)) {
                return i;
            }
        }
        return -1;
    }
}
