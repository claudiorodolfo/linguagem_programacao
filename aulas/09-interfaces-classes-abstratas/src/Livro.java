public class Livro implements Emprestavel {

    private String titulo;
    private String autor;
    private String comQuem;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.comQuem = null;
    }

    @Override
    public boolean emprestar(String usuario) {
        if (!isDisponivel()) {
            return false;
        }
        comQuem = usuario;
        return true;
    }

    @Override
    public void devolver() {
        comQuem = null;
    }

    @Override
    public boolean isDisponivel() {
        return comQuem == null;
    }

    @Override
    public String toString() {
        return "Livro \"" + titulo + "\" de " + autor + " (" + status() + ")";
    }
}
