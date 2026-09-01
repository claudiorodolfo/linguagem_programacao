/**
 * Busca linear com comparação e return no lugar errado.
 */
public class BuscaBugada {

    void main() {
        String[] cadastro = {"Ana", "Bruno", "Caio"};
        IO.println("Ana -> " + indiceDe(cadastro, "Ana"));
        IO.println("Caio -> " + indiceDe(cadastro, "Caio"));
        IO.println("Diana -> " + indiceDe(cadastro, "Diana"));

        String digitado = new String("Ana"); // força outro objeto
        IO.println("new String(\"Ana\") -> " + indiceDe(cadastro, digitado));
    }

    static int indiceDe(String[] cadastro, String nome) {
        for (int i = 0; i < cadastro.length; i++) {
            // BUG 1: == compara referência, não conteúdo.
            if (cadastro[i] == nome) {
                return i;
            }
            // BUG 2: desiste na primeira diferença.
            return -1;
        }
        return -1;
    }
}
