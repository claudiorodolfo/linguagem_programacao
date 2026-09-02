package br.edu.ifba.vdc.bsi.lp1;

// Acessar o diretório dos fontes:
// cd aulas/09-interfaces-classes-abstratas/src
// Compilar e enviar os .class para a pasta bin:
// javac --release 25 -d bin br/edu/ifba/vdc/bsi/lp1/*.java
// Executar a partir desta pasta, usando bin no classpath:
// java -cp bin br.edu.ifba.vdc.bsi.lp1.DemoContratos

public class DemoContratos {

    void main() {
        demonstrarContasAbstratas();
        IO.println();
        demonstrarEmprestavel();
        IO.println();
        demonstrarFormas();
    }

    static void demonstrarContasAbstratas() {
        // Conta c = new Conta("x", 1); // não compila
        Conta[] contas = {
            new ContaPoupanca("001", 1000, 0.01),
            new ContaCorrente("002", 500, 200, 15)
        };
        for (Conta c : contas) {
            c.aplicarTaxasMensais();
            String rotulo = switch (c) {
                case ContaPoupanca _ -> "poupança";
                case ContaCorrente _ -> "corrente";
            };
            IO.println("Após taxas (%s): %s".formatted(rotulo, c));
        }
    }

    static void demonstrarEmprestavel() {
        Emprestavel[] itens = {
            new Livro("Clean Code", "Martin"),
            new Notebook("IFBA-NT-17")
        };
        for (Emprestavel item : itens) {
            IO.println(item);
            item.emprestar("Ana");
            IO.println("  agora: " + item.status());
        }
        itens[0].devolver();
        IO.println("Livro devolvido: " + itens[0]);
    }

    static void demonstrarFormas() {
        Forma[] formas = {
            new Retangulo(3, 4),
            new Circulo(2)
        };
        for (Forma f : formas) {
            String tipo = switch (f) {
                case Circulo _ -> "círculo";
                case Retangulo _ -> "retângulo";
            };
            IO.println("%s: %s".formatted(tipo, f));
        }
    }
}
