package br.edu.ifba.vdc.bsi.lp1.modelo;

/** Dado imutável: sem regra de saldo. Não use record para ContaBancaria. */
public record Intervalo(int inicio, int fim) {

    public int tamanho() {
        return fim - inicio;
    }
}
