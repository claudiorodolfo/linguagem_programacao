package br.edu.ifba.vdc.bsi.lp1;

// Acessar o diretório dos fontes:
// cd aulas/16-boas-praticas/versao-limpa
// Compilar e enviar os .class para a pasta out:
// javac --release 25 -d out br/edu/ifba/vdc/bsi/lp1/*.java
// Executar a partir desta pasta, usando out no classpath:
// java -cp out br.edu.ifba.vdc.bsi.lp1.DemoLimpo

public class DemoLimpo {

    void main() {
        ContaLimpa ana = new ContaLimpa("Ana", 100);
        ContaLimpa bruno = new ContaLimpa("Bruno", 0);
        ana.depositar(50);
        boolean ok = ana.transferir(bruno, 30);
        IO.println("Transferência ok? " + ok);
        IO.println(ana.extratoFormatado());
        IO.println(bruno.extratoFormatado());
    }
}
