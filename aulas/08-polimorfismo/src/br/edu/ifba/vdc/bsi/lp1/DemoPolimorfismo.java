package br.edu.ifba.vdc.bsi.lp1;

// Acessar o diretório dos fontes:
// cd aulas/08-polimorfismo/src
// Compilar e enviar os .class para a pasta bin:
// javac --release 25 -d bin br/edu/ifba/vdc/bsi/lp1/*.java
// Executar a partir desta pasta, usando bin no classpath:
// java -cp bin br.edu.ifba.vdc.bsi.lp1.DemoPolimorfismo

public class DemoPolimorfismo {

    void main() {
        demonstrarContas();
        IO.println();
        demonstrarFolha();
    }

    static void demonstrarContas() {
        Conta[] contas = {
            new Conta("001", 100),
            new ContaCorrente("002", 100, 50),
            new ContaPoupanca("003", 100, 0.10)
        };

        IO.println("Saque de 130 em cada conta:");
        for (Conta c : contas) {
            boolean ok = c.sacar(130);
            IO.println(c + " saque ok? " + ok);
        }

        IO.println("\nRendimento com pattern matching:");
        for (Conta c : contas) {
            if (c instanceof ContaPoupanca p) {
                p.render();
                IO.println("rendeu: " + p);
            }
        }
    }

    static void demonstrarFolha() {
        Funcionario[] equipe = {
            new Funcionario("Ana", 3000),
            new Gerente("Bruno", 5000, 1200),
            new Estagiario("Caio", 1200, 150),
            new Gerente("Diana", 4500, 800)
        };
        for (Funcionario f : equipe) {
            IO.println(f + " folha=" + f.folha());
        }
        IO.println("Total: " + FolhaPagamento.totalFolha(equipe));
        IO.println("Vales (instanceof): " + FolhaPagamento.totalValeComInstanceof(equipe));
    }
}
