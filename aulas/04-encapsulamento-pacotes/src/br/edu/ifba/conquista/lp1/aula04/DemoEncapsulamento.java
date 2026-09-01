package br.edu.ifba.conquista.lp1.aula04;

import br.edu.ifba.conquista.lp1.aula04.modelo.ContaBancaria;

/**
 * Demonstra encapsulamento e organização em pacotes.
 *
 * javac --release 25 -d aulas/04-encapsulamento-pacotes/out \
 *   $(find aulas/04-encapsulamento-pacotes/src -name "*.java")
 * java -cp aulas/04-encapsulamento-pacotes/out \
 *   br.edu.ifba.conquista.lp1.aula04.DemoEncapsulamento
 */
public class DemoEncapsulamento {

    void main() {
        ContaBancaria conta = new ContaBancaria("001", 200);
        conta.depositar(50);
        IO.println("Saldo após depósito: " + conta.getSaldo());
        IO.println("Saque 300? " + conta.sacar(300));
        IO.println("Saldo final: " + conta.getSaldo());
        // conta.saldo = -10;  // não compila: saldo é private
    }
}
