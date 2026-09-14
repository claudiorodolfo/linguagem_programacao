/*
Q4 — Pacote
Mova Retangulo para br.edu.ifba.conquista.lp1.exercicio.modelo e o
programa principal para br.edu.ifba.conquista.lp1.exercicio.app.
Compile com -d out e execute pelo nome qualificado.
*/

// Fontes nos pacotes (pastas = pacotes):
//   br/edu/ifba/conquista/lp1/exercicio/modelo/Retangulo.java
//   br/edu/ifba/conquista/lp1/exercicio/app/Principal.java
//
// O app importa Retangulo porque está em outro pacote.
// Compilar e executar (nesta pasta, exercicios2):
//
//   javac --release 25 -d out \
//     br/edu/ifba/conquista/lp1/exercicio/modelo/Retangulo.java \
//     br/edu/ifba/conquista/lp1/exercicio/app/Principal.java
//   java -cp out br.edu.ifba.conquista.lp1.exercicio.app.Principal
//
// -d out grava os .class em out/br/edu/ifba/... (espelho do pacote).
// A execução usa o nome qualificado, não o nome do arquivo.

class Retangulo {
    private double base;
    private double altura;

    Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    double area() {
        return base * altura;
    }
}

void main() {
    var sala = new Retangulo(8.0, 5.0);
    IO.println("área: " + sala.area());
}
