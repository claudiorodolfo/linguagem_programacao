/**
 * Modelo simplificado de livro da biblioteca do campus.
 * Sem construtor declarado (o padrão entra em cena) e sem private —
 * construtores na aula 03, encapsulamento na aula 04.
 */
public class Livro {

    String titulo;
    String autor;
    boolean emprestado;

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
        return titulo + " (" + autor + ") — " + status;
    }
}
