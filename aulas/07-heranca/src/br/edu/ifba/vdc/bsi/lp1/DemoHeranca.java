package br.edu.ifba.vdc.bsi.lp1;

public class DemoHeranca {

    void main() {
        ContaPoupanca poupanca = new ContaPoupanca("001", 1000, 0.01);
        ContaCorrente corrente = new ContaCorrente("002", 200, 150);

        poupanca.render();
        IO.println("Após rendimento: " + poupanca);

        IO.println("Saque 300 da corrente? " + corrente.sacar(300));
        IO.println(corrente);

        IO.println("Saque 300 da poupança? " + poupanca.sacar(3000));
        IO.println(poupanca);

        // Upcast ainda não é o tema, mas já funciona:
        Conta referencia = corrente;
        IO.println("Referência Conta apontando para corrente: " + referencia);
    }
}
