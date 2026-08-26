package br.edu.ifba.conquista.lp1.aula04.modelo;

/** Livro com invariante: não se empresta duas vezes. */
public class Livro {

    private String titulo;
    private String autor;
    private boolean emprestado;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public boolean emprestar() {
        if (emprestado) {
            return false;
        }
        emprestado = true;
        return true;
    }

    public void devolver() {
        emprestado = false;
    }
}
