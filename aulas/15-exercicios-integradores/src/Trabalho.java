public class Trabalho extends Atividade {

    private Integer notaLancada;

    public Trabalho(String titulo, double peso) {
        super(titulo, peso);
    }

    public void lancar(int nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("nota de 0 a 10");
        }
        this.notaLancada = Integer.valueOf(nota);
    }

    @Override
    public Integer nota() {
        return notaLancada;
    }
}
