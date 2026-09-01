public class FolhaPagamento {

    public static double totalFolha(Funcionario[] equipe) {
        double soma = 0;
        for (Funcionario f : equipe) {
            soma += f.folha();
        }
        return soma;
    }

    public static double totalValeComInstanceof(Funcionario[] equipe) {
        double soma = 0;
        for (Funcionario f : equipe) {
            if (f instanceof Estagiario e) {
                soma += e.getValeTransporte();
            }
        }
        return soma;
    }
}
