package br.edu.ifba.vdc.bsi.lp1;

import br.edu.ifba.vdc.bsi.lp1.modelo.Emprestimo;
import br.edu.ifba.vdc.bsi.lp1.modelo.Endereco;
import br.edu.ifba.vdc.bsi.lp1.modelo.Livro;
import br.edu.ifba.vdc.bsi.lp1.modelo.Usuario;

/**
 * Demonstra associação, composição e cardinalidade na biblioteca do campus.
 *
 * javac --release 25 -d aulas/05-relacionamentos-cardinalidade/out \
 *   $(find aulas/05-relacionamentos-cardinalidade/src -name "*.java")
 * java -cp aulas/05-relacionamentos-cardinalidade/out \
 *   br.edu.ifba.vdc.bsi.lp1.DemoRelacionamentos
 */
public class DemoRelacionamentos {

    void main() {
        Usuario ana = new Usuario(
                "Ana Souza",
                "2026001",
                new Endereco("Rua das Palmeiras, 100", "Vitória da Conquista", "BA"));
        Usuario bruno = new Usuario(
                "Bruno Lima",
                "2026002",
                new Endereco("Av. Centenário, 50", "Vitória da Conquista", "BA"));

        Livro clean = new Livro("Clean Code", "Martin");
        Livro efetivo = new Livro("Java efetivo", "Bloch");
        Livro cabeca = new Livro("Use a cabeça! Java", "Sierra");

        efetivar(new Emprestimo(ana, clean, "01/03"));
        efetivar(new Emprestimo(ana, efetivo, "01/03"));
        efetivar(new Emprestimo(bruno, clean, "02/03")); // deve falhar
        efetivar(new Emprestimo(bruno, cabeca, "02/03"));

        IO.println("Ana mora em: " + ana.cidadeFormatada());
        ana.listarEmprestimos();
        bruno.listarEmprestimos();
        IO.println("Clean Code emprestado? " + clean.isEmprestado());
    }

    static void efetivar(Emprestimo emprestimo) {
        if (emprestimo.efetivar()) {
            IO.println("OK: " + emprestimo.resumo());
        } else {
            IO.println("FALHOU: " + emprestimo.resumo() + " (livro indisponível ou limite)");
        }
    }
}
