package br.edu.ifba.vdc.bsi.lp1;

/**
 * Do diagrama para o Java: os campos abaixo são a leitura UML da aula de relacionamentos.
 * Compare com o quadro (Usuario 1 composição 1 Endereco; Usuario 1 — 0..5 Emprestimo).
 */
public class DemoUml {

    void main() {
        mostrarCaixa();
        IO.println();
        mostrarTraducao();
        IO.println();
        mostrarArmadilhas();
    }

    static void mostrarCaixa() {
        IO.println("""
                Caixa UML                          Java
                − saldo: double                    private double saldo;
                + sacar(valor: double): boolean    public boolean sacar(double valor)
                + totalDeContas                    static int totalDeContas  (sublinhado no diagrama)
                """);
    }

    static void mostrarTraducao() {
        IO.println("Composição 1–1: o endereço nasce no construtor do usuário.");
        IO.println("  private Endereco endereco;  // losango preenchido em Usuario");
        IO.println("Associação 1–N limitada: arranjo + quantidade, não Livro[] solto no main.");
        IO.println("  private Emprestimo[] emprestimos; // 0..5");
        IO.println("Classe associativa: Emprestimo aponta para Usuario e para Livro (dois campos).");
    }

    static void mostrarArmadilhas() {
        IO.println("Losango vazio (agregação): Turma tem Aluno; o aluno existe sem a turma.");
        IO.println("Losango cheio (composição): Pedido tem ItemPedido criado DENTRO do pedido.");
        IO.println("Multiplicidade 1..* no lado do item: Pedido sem itens costuma ser inválido no domínio.");
        IO.println("Não desenhe extends hoje — triângulo vazio é herança.");
    }
}
