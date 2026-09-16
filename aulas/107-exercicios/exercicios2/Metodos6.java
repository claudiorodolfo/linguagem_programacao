/*
Q6 — Classe Carrinho
Um carrinho possui até 10 nomes de produtos (String[]) e uma
quantidade de itens efetivos. O construtor sem argumentos inicializa
o arranjo. Implemente adicionar(String produto), removerUltimo() e
listar(). Utilize apenas arrays.
*/
/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios2/"
javac Metodos6.java -d bin
java -cp bin Metodos6
*/


class Carrinho {
    String[] produtos;
    int quantidade;

    Carrinho() {
        produtos = new String[10];
        quantidade = 0;
    }

    void adicionar(String produto) {
        if (quantidade < produtos.length) {
            produtos[quantidade++] = produto;
        }
    }

    void removerUltimo() {
        if (quantidade > 0) {
            quantidade--;
            produtos[quantidade] = null;
        }
    }

    void listar() {
        for (int i = 0; i < quantidade; i++) {
            IO.println(produtos[i]);
        }
    }
}

void main() {
    var carrinho = new Carrinho();

    carrinho.adicionar("Caderno");
    carrinho.adicionar("Caneta");
    carrinho.adicionar("Borracha");
    carrinho.removerUltimo();

    carrinho.listar();
}
