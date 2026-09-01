public abstract sealed class ItemAcervo permits Livro, Revista, ObraConsulta {

    private String codigo;
    private String titulo;

    public ItemAcervo(String codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public abstract String resumo();
}
