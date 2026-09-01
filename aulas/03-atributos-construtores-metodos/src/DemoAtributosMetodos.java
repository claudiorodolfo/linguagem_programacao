/**
 * Live coding: construtores, this, métodos e atributo estático.
 */
public class DemoAtributosMetodos {

    void main() {
        demonstrarLivrosComConstrutor();
        IO.println();
        demonstrarContas();
        IO.println();
        demonstrarAliasDeReferencia();
    }

    static void demonstrarLivrosComConstrutor() {
        Livro padrao = new Livro();
        Livro l1 = new Livro("Clean Code", "Robert C. Martin", 2008);
        l1.emprestar();
        IO.println(padrao.descricao());
        IO.println(l1.descricao());
    }

    static void demonstrarContas() {
        ContaBancaria ana = new ContaBancaria("001", 500);
        ContaBancaria bruno = new ContaBancaria("002"); // saldo 0 via this(...)
        bruno.depositar(200);
        ana.depositar(50);
        bruno.sacar(30);
        ana.transferir(bruno, 100);
        IO.println(ana.extratoResumido());
        IO.println(bruno.extratoResumido());
        IO.println("Total de contas criadas: " + ContaBancaria.totalDeContas);
    }

    static void demonstrarAliasDeReferencia() {
        ContaBancaria a = new ContaBancaria("010", 100);
        ContaBancaria b = a; // alias: mesmo objeto
        ContaBancaria c = new ContaBancaria("011", 100);
        b.depositar(50);
        c.depositar(50);
        IO.println("a: " + a.consultarSaldo());
        IO.println("b: " + b.consultarSaldo());
        IO.println("c: " + c.consultarSaldo());
        IO.println("a == b? " + (a == b));
        IO.println("a == c? " + (a == c));
    }
}
