public class Emprestimo {

    private UsuarioBiblioteca usuario;
    private Emprestavel item;
    private int prazoDias;

    public Emprestimo(UsuarioBiblioteca usuario, Emprestavel item) {
        this.usuario = usuario;
        this.item = item;
        this.prazoDias = item.prazoDias();
    }

    public UsuarioBiblioteca getUsuario() {
        return usuario;
    }

    public Emprestavel getItem() {
        return item;
    }

    public int getPrazoDias() {
        return prazoDias;
    }

    public String resumo() {
        return usuario.getNome() + " → prazo " + prazoDias + " dia(s)";
    }
}
