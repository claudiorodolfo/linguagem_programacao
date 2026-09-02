package br.edu.ifba.vdc.bsi.lp1;

public class Boletim {

    /**
     * Média ponderada das atividades com nota lançada.
     * @return {@code null} se nenhuma nota existir
     */
    public static Double media(Estudante estudante) {
        double somaPonderada = 0;
        double somaPesos = 0;
        for (Avaliavel a : estudante.getAtividades()) {
            if (!temNota(a)) {
                continue;
            }
            somaPonderada += a.nota().doubleValue() * a.peso();
            somaPesos += a.peso();
        }
        if (somaPesos == 0) {
            return null;
        }
        return Double.valueOf(somaPonderada / somaPesos);
    }

    public static String situacao(Estudante estudante) {
        return switch (media(estudante)) {
            case null -> "cursando";
            case Double v when v >= 7.0 -> "aprovado";
            case Double v when v >= 5.0 -> "recuperação";
            default -> "reprovado";
        };
    }

    public static String relatorio(Estudante estudante) {
        StringBuilder sb = new StringBuilder();
        sb.append(estudante.getNome()).append(" (").append(estudante.getMatricula()).append(")\n");
        for (Avaliavel a : estudante.getAtividades()) {
            sb.append("  - ").append(a.nome()).append(": ");
            sb.append(switch (a.nota()) {
                case null -> "sem nota";
                case Integer n -> n.toString();
            });
            sb.append(" (peso ").append(a.peso()).append(")\n");
        }
        Double m = media(estudante);
        sb.append("Média: ").append(m == null ? "—" : m).append('\n');
        sb.append("Situação: ").append(situacao(estudante));
        return sb.toString();
    }

    private static boolean temNota(Avaliavel a) {
        return a != null && a.nota() != null;
    }
}
