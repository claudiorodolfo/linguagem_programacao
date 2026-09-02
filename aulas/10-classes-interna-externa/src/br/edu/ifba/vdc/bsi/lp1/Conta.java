package br.edu.ifba.vdc.bsi.lp1;

/**
 * Conta do campus: o movimento só existe ligado a esta conta (interna).
 * O formatador de moeda não precisa de conta (aninhada estática).
 */
public class Conta {

    private final String numero;
    private double saldo;

    public Conta(String numero, double saldoInicial) {
        this.numero = numero;
        this.saldo = saldoInicial;
    }

    public boolean depositar(double valor) {
        if (valor <= 0) {
            return false;
        }
        saldo += valor;
        return true;
    }

    public boolean sacar(double valor) {
        if (valor <= 0 || valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }

    public Movimento registrar(String descricao, double valor) {
        return new Movimento(descricao, valor);
    }

    public class Movimento {
        private final String descricao;
        private final double valor;

        public Movimento(String descricao, double valor) {
            this.descricao = descricao;
            this.valor = valor;
        }

        public String texto() {
            return numero + " | " + descricao + " | " + Formatador.reais(valor)
                    + " | saldo " + Formatador.reais(saldo);
        }
    }

    public static class Formatador {
        public static String reais(double valor) {
            return "R$ " + valor;
        }
    }

    @Override
    public String toString() {
        return "Conta " + numero + " (" + Formatador.reais(saldo) + ")";
    }
}
