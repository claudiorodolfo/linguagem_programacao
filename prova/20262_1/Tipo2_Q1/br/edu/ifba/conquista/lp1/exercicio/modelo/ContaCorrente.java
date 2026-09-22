package br.edu.ifba.conquista.lp1.exercicio.modelo;

public class ContaCorrente {

    private int numero;
    private String nomeCorrentista;
    private double saldo;

    public ContaCorrente(int numero, String nomeCorrentista) {
        this(numero, nomeCorrentista, 0);
    }

    public ContaCorrente(int numero, String nomeCorrentista,
                         double saldo) {

        if (numero <= 0) {
            throw new IllegalArgumentException(
                "Número da conta inválido."
            );
        }

        if (nomeCorrentista == null ||
            nomeCorrentista.isBlank()) {

            throw new IllegalArgumentException(
                "Nome do correntista inválido."
            );
        }

        if (saldo < 0) {
            throw new IllegalArgumentException(
                "O saldo inicial não pode ser negativo."
            );
        }

        this.numero = numero;
        this.nomeCorrentista = nomeCorrentista;
        this.saldo = saldo;
    }

    public void alterarNome(String nome) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException(
                "Nome inválido."
            );
        }

        this.nomeCorrentista = nome;
    }

    public void depositar(double valor) {

        if (valor <= 0) {
            throw new IllegalArgumentException(
                "O valor do depósito deve ser positivo."
            );
        }

        saldo += valor;
    }

    public void sacar(double valor) {

        if (valor <= 0) {
            throw new IllegalArgumentException(
                "O valor do saque deve ser positivo."
            );
        }

        if (valor > saldo) {
            throw new IllegalStateException(
                "Saldo insuficiente."
            );
        }

        saldo -= valor;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public int getNumero() {
        return numero;
    }

    public String getNomeCorrentista() {
        return nomeCorrentista;
    }
}