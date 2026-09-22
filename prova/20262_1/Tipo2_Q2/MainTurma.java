class Inscricao {

    private String nomeAluno;
    private double media;

    public Inscricao(String nomeAluno, double media) {

        if (nomeAluno == null || nomeAluno.isBlank()) {
            System.out.println("Nome do aluno inválido.");
        }

        if (media < 0 || media > 10) {
            System.out.println("A média deve estar entre 0 e 10.");
        }

        this.nomeAluno = nomeAluno;
        this.media = media;
    }

    public void consultarDados() {

        System.out.println(
            "Aluno: " + nomeAluno
            + " | Média: " + media
        );
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public double getMedia() {
        return media;
    }
}


class Turma {

    private String codigo;

    private Inscricao[] inscricoes;

    private int quantidadeInscricoes;

    public Turma(String codigo) {

        if (codigo == null || codigo.isBlank()) {
            System.out.println(
                "Código da turma inválido."
            );
        }

        this.codigo = codigo;
        this.inscricoes = new Inscricao[40];
        this.quantidadeInscricoes = 0;
    }

    public void matricular(String nomeAluno, double media) {

        if (quantidadeInscricoes >= inscricoes.length) {
            System.out.println("A turma já possui 40 inscrições.");
        }

        Inscricao inscricao =
            new Inscricao(nomeAluno, media);

        inscricoes[quantidadeInscricoes] = inscricao;

        quantidadeInscricoes++;
    }

    public double mediaDaTurma() {

        if (quantidadeInscricoes == 0) {
            return 0;
        }

        double soma = 0;

        for (int i = 0; i < quantidadeInscricoes; i++) {
            soma += inscricoes[i].getMedia();
        }

        return soma / quantidadeInscricoes;
    }

    public void listar() {

        System.out.println(
            "Turma: " + codigo
        );

        for (int i = 0; i < quantidadeInscricoes; i++) {

            System.out.println(
                "Aluno: "
                + inscricoes[i].getNomeAluno()
                + " | Média: "
                + inscricoes[i].getMedia()
            );
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public int getQuantidadeInscricoes() {
        return quantidadeInscricoes;
    }
}


public class MainTurma {

    public static void main(String[] args) {

        Turma turma = new Turma("BSI-2026.2");

        turma.matricular("Ana", 8.5);
        turma.matricular("Bruno", 7.0);
        turma.matricular("Carlos", 9.0);
        turma.matricular("Daniela", 6.5);

        turma.listar();

        System.out.println(
            "Média da turma: "
            + turma.mediaDaTurma()
        );
    }
}