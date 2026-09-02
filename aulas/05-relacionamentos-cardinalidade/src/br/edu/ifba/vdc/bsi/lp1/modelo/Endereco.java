package br.edu.ifba.vdc.bsi.lp1.modelo;

/** Dado imutável: record gera construtor, acessores e equals/hashCode. */
public record Endereco(String logradouro, String cidade, String uf) {

    public String formatado() {
        return "%s — %s/%s".formatted(logradouro, cidade, uf);
    }
}
