/** Não implementa Emprestavel: só consulta no recinto. */
public final class ObraConsulta extends ItemAcervo {

    private String secao;

    public ObraConsulta(String codigo, String titulo, String secao) {
        super(codigo, titulo);
        this.secao = secao;
    }

    @Override
    public String resumo() {
        return "[" + getCodigo() + "] Consulta local: " + getTitulo() + " (" + secao + ")";
    }
}
