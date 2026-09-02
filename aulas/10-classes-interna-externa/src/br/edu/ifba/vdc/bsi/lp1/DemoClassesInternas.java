package br.edu.ifba.vdc.bsi.lp1;

/**
 * Interna precisa do objeto externo; aninhada static não.
 */
public class DemoClassesInternas {

    void main() {
        demonstrarExternaInterna();
        IO.println();
        demonstrarConta();
        IO.println();
        demonstrarEstatica();
    }

    static void demonstrarExternaInterna() {
        Externa campus = new Externa("Vitória da Conquista");
        Externa.Interna etiqueta = campus.new Interna();
        IO.println(etiqueta.apresentar());
        // new Externa.Interna(); // não compila: falta o objeto da externa
    }

    static void demonstrarConta() {
        Conta conta = new Conta("2026-001", 100.0);
        conta.depositar(50.0);
        Conta.Movimento credito = conta.registrar("depósito", 50.0);
        IO.println(conta);
        IO.println(credito.texto());
    }

    static void demonstrarEstatica() {
        IO.println(Externa.Util.prefixo());
        IO.println(Conta.Formatador.reais(7.5));
        Conta.Formatador formatador = new Conta.Formatador();
        IO.println("instância estática: " + formatador.reais(1.0));
    }
}
