package br.edu.ifba.conquista.lp1.aula05.modelo;

/** Dado imutável: record gera construtor, acessores e equals/hashCode. */
public record Endereco(String logradouro, String cidade, String uf) {

    public String formatado() {
        return "%s — %s/%s".formatted(logradouro, cidade, uf);
    }
}
