package br.edu.ifba.vdc.bsi.lp1;

// Acessar o diretório dos fontes:
// cd aulas/12-exercicios-integradores-poo/src
// Compilar e enviar os .class para a pasta out:
// javac --release 25 -d out br/edu/ifba/vdc/bsi/lp1/*.java
// Executar a partir desta pasta, usando out no classpath:
// java -cp out br.edu.ifba.vdc.bsi.lp1.DemoAcervo

public class DemoAcervo {

    void main() {
        Biblioteca ifba = new Biblioteca();

        Livro clean = new Livro("L01", "Clean Code", "Martin");
        Livro efetivo = new Livro("L02", "Java efetivo", "Bloch");
        Revista info = new Revista("R01", "InfoExame", 320);
        ObraConsulta atlas = new ObraConsulta("C01", "Atlas do Sertão", "Referência");

        ifba.cadastrarItem(clean);
        ifba.cadastrarItem(efetivo);
        ifba.cadastrarItem(info);
        ifba.cadastrarItem(atlas);

        UsuarioBiblioteca ana = new UsuarioBiblioteca("Ana Souza", "2026001", 3);
        UsuarioBiblioteca bruno = new UsuarioBiblioteca("Bruno Lima", "2026002", 1);
        ifba.cadastrarUsuario(ana);
        ifba.cadastrarUsuario(bruno);

        IO.println("Emprestar Clean Code para Ana? " + ifba.emprestar(ana, clean));
        IO.println("Emprestar Clean Code para Bruno? " + ifba.emprestar(bruno, clean));
        IO.println("Emprestar revista para Bruno? " + ifba.emprestar(bruno, info));
        IO.println("Segundo item para Bruno (limite 1)? " + ifba.emprestar(bruno, efetivo));

        // atlas não é Emprestavel: a linha abaixo nem compila.
        // ifba.emprestar(ana, atlas);

        ifba.relatorio();

        ifba.devolver(ana, clean);
        IO.println("\nApós Ana devolver:");
        ifba.relatorio();
    }
}
