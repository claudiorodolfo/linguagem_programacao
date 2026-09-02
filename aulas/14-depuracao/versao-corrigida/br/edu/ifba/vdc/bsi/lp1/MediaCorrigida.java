package br.edu.ifba.vdc.bsi.lp1;

// Acessar o diretório dos fontes:
// cd aulas/14-depuracao/versao-corrigida
// Compilar e enviar os .class para a pasta out:
// javac --release 25 -d out br/edu/ifba/vdc/bsi/lp1/*.java
// Executar a partir desta pasta, usando out no classpath:
// java -cp out br.edu.ifba.vdc.bsi.lp1.MediaCorrigida

/** Versão corrigida para o fechamento da aula. Não mostre antes do laboratório. */
public class MediaCorrigida {

    void main() {
        int[] notas = {7, 8, 9};
        IO.println("Média: " + media(notas));
    }

    static double media(int[] notas) {
        int soma = 0;
        for (int i = 0; i < notas.length; i++) {
            soma += notas[i];
        }
        return soma / (double) notas.length;
    }
}
