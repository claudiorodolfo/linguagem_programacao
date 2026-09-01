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
        Double m = media(estudante);
        if (m == null) {
            return "cursando";
        }
        double v = m.doubleValue();
        if (v >= 7.0) {
            return "aprovado";
        }
        if (v >= 5.0) {
            return "recuperação";
        }
        return "reprovado";
    }

    public static String relatorio(Estudante estudante) {
        StringBuilder sb = new StringBuilder();
        sb.append(estudante.getNome()).append(" (").append(estudante.getMatricula()).append(")\n");
        for (Avaliavel a : estudante.getAtividades()) {
            sb.append("  - ").append(a.nome()).append(": ");
            sb.append(a.nota() == null ? "sem nota" : a.nota());
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
