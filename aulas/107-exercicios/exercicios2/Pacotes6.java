/*
Q6 — Pacote e visibilidade
Duas classes no mesmo pacote: Estoque (atributo visibilidade com
pacote int quantidade) e Inventario. Inventario altera quantidade
diretamente. Mova Inventario para outro pacote: o que deixa de
compilar? Qual modificador você usaria de verdade e por quê?
*/

class Estoque {
    int quantidade; // package-private: qualquer classe do pacote acessa
}

class Inventario {
    void entrada(Estoque estoque, int qtd) {
        estoque.quantidade += qtd;
    }
}

void main() {
    var estoque = new Estoque();
    var inventario = new Inventario();
    inventario.entrada(estoque, 10);
    IO.println("quantidade: " + estoque.quantidade);

    // Neste arquivo compacto as duas classes estão no mesmo
    // (unnamed) package, então estoque.quantidade += qtd compila.
    //
    // Se Inventario for para outro pacote, deixa de compilar o
    // acesso a estoque.quantidade: package-private não atravessa
    // a fronteira do pacote.
    //
    // De verdade: quantidade seria private, e Estoque teria
    // entrada(int)/saida(int) (ou equivalente). Assim a regra
    // (quantidade nunca negativa, por exemplo) fica na classe
    // dona do dado, e Inventario deixa de furar o estado.
}
