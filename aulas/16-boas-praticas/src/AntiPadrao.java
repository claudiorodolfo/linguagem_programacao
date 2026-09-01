import java.util.Scanner;

/**
 * Funciona (quase). É o paciente da aula de boas práticas. Não use como modelo.
 */
public class AntiPadrao {

    public double saldo; // 3. atributo público
    public String n;

    public static void main(String[] args) {
        AntiPadrao c1 = new AntiPadrao();
        c1.n = "Ana";
        c1.saldo = 100;
        c1.faz();
    }

    // 1. SRP: lê teclado, aplica regra, "salva", imprime
    // 2. nome inútil
    public void faz() {
        Scanner s = new Scanner(System.in);
        System.out.println("valor");
        double x = s.nextDouble();
        try {
            if (x > 0) {
                saldo = saldo + x;
            }
            // 4. erro silencioso
        } catch (Exception e) {
        }
        // 5. magia: tarifa
        saldo = saldo - 15;
        AntiPadrao c2 = new AntiPadrao();
        c2.n = "Bruno";
        c2.saldo = 0;
        // 6. DRY: transferência na mão, sem validar saldo
        saldo = saldo - x;
        c2.saldo = c2.saldo + x;
        System.out.println(n + " " + saldo);
        System.out.println(c2.n + " " + c2.saldo);
        salvarNoBancoDeDadosQueNaoExiste();
    }

    void salvarNoBancoDeDadosQueNaoExiste() {
        System.out.println("salvou");
    }
}
