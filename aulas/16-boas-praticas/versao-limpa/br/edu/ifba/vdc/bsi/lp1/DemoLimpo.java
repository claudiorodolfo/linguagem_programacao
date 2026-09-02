package br.edu.ifba.vdc.bsi.lp1;

public class DemoLimpo {

    void main() {
        ContaLimpa ana = new ContaLimpa("Ana", 100);
        ContaLimpa bruno = new ContaLimpa("Bruno", 0);
        ana.depositar(50);
        boolean ok = ana.transferir(bruno, 30);
        IO.println("Transferência ok? " + ok);
        IO.println(ana.extratoFormatado());
        IO.println(bruno.extratoFormatado());
    }
}
