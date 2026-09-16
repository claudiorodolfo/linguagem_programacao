/*
Q4 — Pacote
Mova Retangulo para br.edu.ifba.conquista.lp1.exercicio.modelo e o
programa principal para br.edu.ifba.conquista.lp1.exercicio.app.
Compile com -d bin e execute pelo nome qualificado.
*/
/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios2/Pacote4/"
javac br/edu/ifba/conquista/lp1/exercicio/modelo/Retangulo.java br/edu/ifba/conquista/lp1/exercicio/app/Principal.java -d bin
java -cp bin br.edu.ifba.conquista.lp1.exercicio.app.Principal
*/


// Fontes nos pacotes (pastas = pacotes):
//   br/edu/ifba/conquista/lp1/exercicio/modelo/Retangulo.java
//   br/edu/ifba/conquista/lp1/exercicio/app/Principal.java
//
// O app importa Retangulo porque está em outro pacote.
// Construtor e area() são public: package-private não atravessa
// a fronteira do pacote.
// Compilar e executar (nesta pasta, exercicios2/Pacote4):
//
//   javac -d bin \
//     br/edu/ifba/conquista/lp1/exercicio/modelo/Retangulo.java \
//     br/edu/ifba/conquista/lp1/exercicio/app/Principal.java
//   java -cp bin br.edu.ifba.conquista.lp1.exercicio.app.Principal
//
// -d bin grava os .class em bin/br/edu/ifba/... (espelho do pacote).
// A execução usa o nome qualificado, não o nome do arquivo.
//
// Para executar o programa faça
//   java -cp bin \
//     br.edu.ifba.conquista.lp1.exercicio.app.Principal

package br.edu.ifba.conquista.lp1.exercicio.app;

import br.edu.ifba.conquista.lp1.exercicio.modelo.Retangulo;

public class Principal {

    void main() {
        var sala = new Retangulo(8.0, 5.0);
        IO.println("área: " + sala.area());
    }
}
