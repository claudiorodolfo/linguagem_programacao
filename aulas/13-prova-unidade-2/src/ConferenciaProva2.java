public class ConferenciaProva2 {

    void main() {
        Veiculo v = new CarroEsportivo();
        v.acelerar(10);
        IO.println("velocidade (esperado 20): " + v.getVelocidade());

        Pagamento[] ps = { new Pix(), new Cartao(), new Boleto() };
        IO.println("taxas de 100 (esperado 5.5): " + totalTaxas(ps, 100));

        Pagamento p = new Pix();
        imprime(p);
    }

    static double totalTaxas(Pagamento[] ps, double valor) {
        double s = 0;
        for (Pagamento pag : ps) {
            s += pag.taxa(valor);
        }
        return s;
    }

    static void imprime(Pagamento p) {
        IO.println("P");
    }

    static void imprime(Pix p) {
        IO.println("X");
    }
}

class Veiculo {
    protected int velocidade;
    public Veiculo() { velocidade = 0; }
    public void acelerar(int delta) { velocidade += delta; }
    public int getVelocidade() { return velocidade; }
}

class CarroEsportivo extends Veiculo {
    @Override
    public void acelerar(int delta) {
        super.acelerar(delta * 2);
    }
}

abstract class Pagamento {
    public abstract double taxa(double valor);
}

class Pix extends Pagamento {
    public double taxa(double valor) { return 0; }
}

class Cartao extends Pagamento {
    public double taxa(double valor) { return valor * 0.03; }
}

class Boleto extends Pagamento {
    public double taxa(double valor) { return 2.50; }
}
