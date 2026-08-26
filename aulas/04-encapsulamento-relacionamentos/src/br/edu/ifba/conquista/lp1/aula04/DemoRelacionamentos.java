package br.edu.ifba.conquista.lp1.aula04;

import br.edu.ifba.conquista.lp1.aula04.modelo.ContaBancaria;
import br.edu.ifba.conquista.lp1.aula04.modelo.Emprestimo;
import br.edu.ifba.conquista.lp1.aula04.modelo.Endereco;
import br.edu.ifba.conquista.lp1.aula04.modelo.Livro;
import br.edu.ifba.conquista.lp1.aula04.modelo.Usuario;

/**
 * Demonstra encapsulamento e relacionamentos da biblioteca do campus.
 *
 * javac --release 25 -d aulas/04-encapsulamento-relacionamentos/out \
 *   $(find aulas/04-encapsulamento-relacionamentos/src -name "*.java")
 * java -cp aulas/04-encapsulamento-relacionamentos/out \
 *   br.edu.ifba.conquista.lp1.aula04.DemoRelacionamentos
 */
public class DemoRelacionamentos {

    void main() {
        demonstrarContaEncapsulada();
        IO.println();
        demonstrarBiblioteca();
    }

    static void demonstrarContaEncapsulada() {
        ContaBancaria conta = new ContaBancaria("001", 200);
        conta.depositar(50);
        IO.println("Saldo após depósito: " + conta.getSaldo());
        IO.println("Saque 300? " + conta.sacar(300));
        IO.println("Saldo final: " + conta.getSaldo());
        // conta.saldo = -10;  // não compila: saldo é private
    }

    static void demonstrarBiblioteca() {
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

        efetivar(new Emprestimo(ana, clean, "17/08/2026"));
        efetivar(new Emprestimo(ana, efetivo, "17/08/2026"));
        efetivar(new Emprestimo(bruno, clean, "18/08/2026")); // deve falhar
        efetivar(new Emprestimo(bruno, cabeca, "18/08/2026"));

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
