/*
Q5 — record ou classe?
Considere: Cpf (onze dígitos, imutável depois de criado) e
ContaCorrente (saldo muda). Qual vira record e qual permanece
classe? Escreva o record Cpf com um método formatado()
(000.000.000-00 vale como esboço).
*/
/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios2/"
javac Pacotes5.java -d bin
java -cp bin Pacotes5
*/

//Use record quando o objeto representa principalmente um valor imutável. 
// Use class quando o objeto possui um estado que precisa mudar ao longo do tempo.
//
// CPF representa um valor que, depois de criado, não deve ser alterado. 
// Por isso, podemos usar um record: ele é adequado para objetos cujo 
// estado é definido na criação e permanece imutável. 
//
// O record cria automaticamente o construtor e o método digitos(),
// que permite acessar o valor armazenado no componente digitos.
// Também cria equals(), hashCode() e toString().

record Cpf(String digitos) {
    Cpf {
        if (digitos == null || digitos.length() != 11) {
            IO.println("Valor inválido para o CPF");
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

// Já uma ContaCorrente possui um estado que muda durante sua existência. 
// O saldo, por exemplo, pode aumentar com um depósito ou diminuir com um saque. 
// Por isso, ContaCorrente continua sendo uma classe. 
//
// Pense assim: 
// CPF = "qual é o valor deste CPF?" 
// ContaCorrente = "como está o estado desta conta agora?" 
//
// Além disso, uma ContaCorrente possui regras que precisam ser preservadas, 
// como não permitir operações que deixem o saldo em uma situação inválida. 
// Essas regras são chamadas de invariantes da classe.
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
