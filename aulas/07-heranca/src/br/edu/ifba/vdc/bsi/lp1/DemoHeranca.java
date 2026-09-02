package br.edu.ifba.vdc.bsi.lp1;

// Acessar o diretório dos fontes:
// cd aulas/07-heranca/src
// Compilar e enviar os .class para a pasta out:
// javac --release 25 -d out br/edu/ifba/vdc/bsi/lp1/*.java
// Executar a partir desta pasta, usando out no classpath:
// java -cp out br.edu.ifba.vdc.bsi.lp1.DemoHeranca

public class DemoHeranca {

    void main() {
        ContaPoupanca poupanca = new ContaPoupanca("001", 1000, 0.01);
        ContaCorrente corrente = new ContaCorrente("002", 200, 150);

        poupanca.render();
        IO.println("Após rendimento: " + poupanca);

        IO.println("Saque 300 da corrente? " + corrente.sacar(300));
        IO.println(corrente);

        IO.println("Saque 300 da poupança? " + poupanca.sacar(3000));
        IO.println(poupanca);

        // Upcast ainda não é o tema, mas já funciona:
        Conta referencia = corrente;
        IO.println("Referência Conta apontando para corrente: " + referencia);
    }
}
