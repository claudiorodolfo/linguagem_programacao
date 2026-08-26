import java.util.ArrayList;

public class Estudante {

    private final String nome;
    private final String matricula;
    private final ArrayList<Avaliavel> atividades = new ArrayList<>();

    public Estudante(String nome, String matricula) {
        if (nome == null || matricula == null) {
            throw new IllegalArgumentException("nome e matrícula obrigatórios");
        }
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void adicionar(Avaliavel atividade) {
        if (atividade == null) {
            throw new IllegalArgumentException("atividade obrigatória");
        }
        atividades.add(atividade);
    }

    public ArrayList<Avaliavel> getAtividades() {
        return atividades;
    }
}
