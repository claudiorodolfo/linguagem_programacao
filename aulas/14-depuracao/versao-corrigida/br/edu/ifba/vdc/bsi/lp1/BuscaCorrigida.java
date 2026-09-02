package br.edu.ifba.vdc.bsi.lp1;

// Acessar o diretório dos fontes:
// cd aulas/14-depuracao/versao-corrigida
// Compilar e enviar os .class para a pasta bin:
// javac --release 25 -d bin br/edu/ifba/vdc/bsi/lp1/*.java
// Executar a partir desta pasta, usando bin no classpath:
// java -cp bin br.edu.ifba.vdc.bsi.lp1.BuscaCorrigida

public class BuscaCorrigida {

    void main() {
        String[] cadastro = {"Ana", "Bruno", "Caio"};
        IO.println("Ana -> " + indiceDe(cadastro, "Ana"));
        IO.println("Caio -> " + indiceDe(cadastro, "Caio"));
        IO.println("Diana -> " + indiceDe(cadastro, "Diana"));
        IO.println("new String(\"Ana\") -> " + indiceDe(cadastro, new String("Ana")));
    }

    static int indiceDe(String[] cadastro, String nome) {
        for (int i = 0; i < cadastro.length; i++) {
            if (cadastro[i].equals(nome)) {
                return i;
            }
        }
        return -1;
    }
}
