package br.edu.ifba.conquista.lp1.exercicio;

import br.edu.ifba.conquista.lp1.exercicio.modelo.ContaCorrente;

public class DemoConta {

    public static void main(String[] args) {

        ContaCorrente conta =
            new ContaCorrente(12345, "João");

        System.out.println(
            "Conta: " + conta.getNumero()
        );

        System.out.println(
            "Correntista: "
            + conta.getNomeCorrentista()
        );

        System.out.println(
            "Saldo inicial: "
            + conta.consultarSaldo()
        );

        conta.depositar(1000);

        System.out.println(
            "Saldo após depósito: "
            + conta.consultarSaldo()
        );

        conta.sacar(250);

        System.out.println(
            "Saldo após saque: "
            + conta.consultarSaldo()
        );

        conta.alterarNome("João da Silva");

        System.out.println(
            "Novo nome: "
            + conta.getNomeCorrentista()
        );
    }
}