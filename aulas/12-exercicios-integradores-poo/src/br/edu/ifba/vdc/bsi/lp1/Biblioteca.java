package br.edu.ifba.vdc.bsi.lp1;

public class Biblioteca {

    private static final int MAX = 50;

    private ItemAcervo[] itens = new ItemAcervo[MAX];
    private int quantidadeItens = 0;

    private UsuarioBiblioteca[] usuarios = new UsuarioBiblioteca[MAX];
    private int quantidadeUsuarios = 0;

    private Emprestimo[] emprestimos = new Emprestimo[MAX];
    private int quantidadeEmprestimos = 0;

    public boolean cadastrarItem(ItemAcervo item) {
        if (item == null || quantidadeItens >= MAX) {
            return false;
        }
        itens[quantidadeItens++] = item;
        return true;
    }

    public boolean cadastrarUsuario(UsuarioBiblioteca usuario) {
        if (usuario == null || quantidadeUsuarios >= MAX) {
            return false;
        }
        usuarios[quantidadeUsuarios++] = usuario;
        return true;
    }

    public boolean emprestar(UsuarioBiblioteca usuario, Emprestavel item) {
        if (usuario == null || item == null) {
            return false;
        }
        if (!usuario.podeEmprestarMais()) {
            IO.println("Limite de empréstimos de " + usuario.getNome());
            return false;
        }
        if (!item.emprestar(usuario.getMatricula())) {
            IO.println("Item indisponível.");
            return false;
        }
        emprestimos[quantidadeEmprestimos++] = new Emprestimo(usuario, item);
        usuario.registrarEmprestimo();
        return true;
    }

    public boolean devolver(UsuarioBiblioteca usuario, Emprestavel item) {
        for (int i = 0; i < quantidadeEmprestimos; i++) {
            Emprestimo e = emprestimos[i];
            if (e != null && e.getUsuario() == usuario && e.getItem() == item) {
                item.devolver();
                usuario.registrarDevolucao();
                emprestimos[i] = emprestimos[quantidadeEmprestimos - 1];
                emprestimos[quantidadeEmprestimos - 1] = null;
                quantidadeEmprestimos--;
                return true;
            }
        }
        return false;
    }

    public void relatorio() {
        IO.println("--- Acervo ---");
        for (int i = 0; i < quantidadeItens; i++) {
            IO.println(itens[i].resumo());
        }
        IO.println("--- Empréstimos ativos: " + quantidadeEmprestimos + " ---");
        for (int i = 0; i < quantidadeEmprestimos; i++) {
            IO.println(emprestimos[i].resumo());
        }
    }
}
