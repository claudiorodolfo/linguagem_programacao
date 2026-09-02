public interface Emprestavel {

    boolean emprestar(String usuario);

    void devolver();

    boolean isDisponivel();

    default String status() {
        return isDisponivel() ? "disponível" : "emprestado";
    }
}
