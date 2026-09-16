/*
Q4 — Identidade versus Estado
Escreva um trecho que prove que dois objetos podem ter os mesmos
valores nos atributos e, ainda assim, serem objetos diferentes.
Utilize == e compare os campos titulo e autor.
*/
/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios2/"
javac Classes4.java -d bin
java -cp bin Classes4
*/


class Livro {
    String titulo;
    String autor;
}

void main() {
    Livro a = new Livro();
    a.titulo = "Clean Code";
    a.autor = "Robert Martin";

    Livro c = new Livro();
    c.titulo = "Clean Code";
    c.autor = "Robert Martin";

    IO.println("titulo iguais: " + (a.titulo == c.titulo));
    IO.println("autor iguais: " + (a.autor == c.autor));
    IO.println("a == c: " + (a == c));
}
