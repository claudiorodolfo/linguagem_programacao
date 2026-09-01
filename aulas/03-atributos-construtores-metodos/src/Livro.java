/**
 * Livro da aula 02, agora com construtores e this.
 * Atributos ainda sem private — isso muda na aula 04.
 */
public class Livro {

    String titulo;
    String autor;
    int ano;
    boolean emprestado;

    public Livro() {
        this("sem título", "desconhecido", 0);
    }

    public Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.emprestado = false;
    }

    public void emprestar() {
        if (emprestado) {
            IO.println("O livro \"" + titulo + "\" já está emprestado.");
            return;
        }
        emprestado = true;
    }

    public void devolver() {
        emprestado = false;
    }

    public String descricao() {
        String status = emprestado ? "emprestado" : "disponível";
        return titulo + " (" + autor + ", " + ano + ") — " + status;
    }
}
