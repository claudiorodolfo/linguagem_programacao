package br.edu.ifba.vdc.bsi.lp1;

// Acessar o diretório dos fontes:
// cd aulas/04-encapsulamento-pacotes/src
// Compilar e enviar os .class para a pasta out:
// javac --release 25 -d out br/edu/ifba/vdc/bsi/lp1/*.java br/edu/ifba/vdc/bsi/lp1/modelo/*.java
// Executar a partir desta pasta, usando out no classpath:
// java -cp out br.edu.ifba.vdc.bsi.lp1.DemoEncapsulamento

import br.edu.ifba.vdc.bsi.lp1.modelo.ContaBancaria;

/**
 * Demonstra encapsulamento e organização em pacotes.
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
