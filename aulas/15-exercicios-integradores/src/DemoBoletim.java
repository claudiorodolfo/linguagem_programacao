public class DemoBoletim {

    void main() {
        Estudante ana = new Estudante("Ana Souza", "2026001");

        ProvaEscrita p1 = new ProvaEscrita("Prova 1", 2);
        p1.lancar(8);

        ProvaEscrita p2 = new ProvaEscrita("Prova 2", 2);
        // nota não lançada de propósito → Integer null

        Trabalho t = new Trabalho("Trabalho POO", 1);
        t.lancar(6);

        ana.adicionar(p1);
        ana.adicionar(p2);
        ana.adicionar(t);

        IO.println(Boletim.relatorio(ana));
        IO.println("Média (objeto): " + Boletim.media(ana));
    }
}
