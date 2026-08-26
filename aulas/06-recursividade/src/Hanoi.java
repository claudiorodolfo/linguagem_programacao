public class Hanoi {

    public static void mover(int n, char origem, char destino, char auxiliar) {
        if (n <= 0) {
            return;
        }
        if (n == 1) {
            IO.println(origem + " -> " + destino);
            return;
        }
        mover(n - 1, origem, auxiliar, destino);
        IO.println(origem + " -> " + destino);
        mover(n - 1, auxiliar, destino, origem);
    }
}
