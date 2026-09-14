/*
Q5 — record ou classe?
Considere: Cpf (onze dígitos, imutável depois de criado) e
ContaCorrente (saldo muda). Qual vira record e qual permanece
classe? Escreva o record Cpf com um método formatado()
(000.000.000-00 vale como esboço).
*/

// Cpf vira record: só carrega dados, não muda depois de criado.
// ContaCorrente permanece classe: saldo muda (depósito/saque).
// record gera construtor, acessor digitos(), equals, hashCode e
// toString. Não use record para tipo com invariante de saldo.

record Cpf(String digitos) {
    Cpf {
        if (digitos == null || digitos.length() != 11) {
            throw new IllegalArgumentException("CPF deve ter 11 dígitos");
        }
    }

    String formatado() {
        return "%s.%s.%s-%s".formatted(
                digitos.substring(0, 3),
                digitos.substring(3, 6),
                digitos.substring(6, 9),
                digitos.substring(9, 11));
    }
}

class ContaCorrente {
    private double saldo;

    ContaCorrente(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    double getSaldo() {
        return saldo;
    }
}

void main() {
    var cpf = new Cpf("12345678901");
    IO.println(cpf.formatado());

    var conta = new ContaCorrente(100);
    conta.depositar(50);
    IO.println("saldo: " + conta.getSaldo());
}
