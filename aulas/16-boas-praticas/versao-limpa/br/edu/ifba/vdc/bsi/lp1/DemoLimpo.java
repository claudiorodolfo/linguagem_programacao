package br.edu.ifba.vdc.bsi.lp1;

// Acessar o diretório dos fontes:
// cd aulas/16-boas-praticas/versao-limpa
// Compilar e enviar os .class para a pasta bin:
// javac --release 25 -d bin br/edu/ifba/vdc/bsi/lp1/*.java
// Executar a partir desta pasta, usando bin no classpath:
// java -cp bin br.edu.ifba.vdc.bsi.lp1.DemoLimpo

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
