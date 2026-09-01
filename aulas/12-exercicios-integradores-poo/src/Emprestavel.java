public interface Emprestavel {

    boolean emprestar(String matriculaUsuario);

    void devolver();

    boolean isDisponivel();

    int prazoDias();
}
