/**
 * Live coding: objetos independentes versus duas referências para o mesmo objeto.
 */
public class DemoClassesObjetos {

    void main() {
        demonstrarLivros();
        IO.println();
        demonstrarContas();
        IO.println();
        demonstrarAliasDeReferencia();
    }

    static void demonstrarLivros() {
        Livro l1 = new Livro("Clean Code", "Robert C. Martin", 2008);
        Livro l2 = new Livro("Java efetivo", "Joshua Bloch", 2018);
        l1.emprestar();
        IO.println(l1.descricao());
        IO.println(l2.descricao());
        l1.emprestar(); // já emprestado
    }

    static void demonstrarContas() {
        ContaBancaria ana = new ContaBancaria("001", 500);
        ContaBancaria bruno = new ContaBancaria("002", 200);
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
