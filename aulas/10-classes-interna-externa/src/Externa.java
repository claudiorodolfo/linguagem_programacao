/**
 * Exemplo mínimo do quadro: externa + interna de instância + aninhada estática.
 */
public class Externa {

    private String nome;

    public Externa(String nome) {
        this.nome = nome;
    }

    public class Interna {
        public String apresentar() {
            return "interna de " + nome;
        }

        public String nomeDaExterna() {
            return Externa.this.nome;
        }
    }

    public static class Util {
        public static String prefixo() {
            return "IFBA";
        }
    }

    public String getNome() {
        return nome;
    }
}
