/*
Q2 — Composição Pedido / ItemPedido
ItemPedido possui nome do produto, quantidade e preço unitário, com
subtotal(). Pedido possui número, arranjo de itens (máx. 20),
adicionarItem(...) e total(). O item só existe dentro do pedido; não
há lista global de itens.
*/

class ItemPedido {
    private String nomeProduto;
    private int quantidade;
    private double precoUnitario;

    ItemPedido(String nomeProduto, int quantidade, double precoUnitario) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    String getNomeProduto() {
        return nomeProduto;
    }

    double subtotal() {
        return quantidade * precoUnitario;
    }
}

class Pedido {
    private int numero;
    private ItemPedido[] itens;
    private int quantidade;

    Pedido(int numero) {
        this.numero = numero;
        this.itens = new ItemPedido[20];
        this.quantidade = 0;
    }

    // O item nasce aqui: composição. Ninguém de fora faz
    // new ItemPedido e depois “encaixa” numa lista global.
    boolean adicionarItem(String nomeProduto, int qtd, double precoUnitario) {
        if (quantidade >= itens.length || qtd <= 0 || precoUnitario < 0) {
            return false;
        }
        itens[quantidade] = new ItemPedido(nomeProduto, qtd, precoUnitario);
        quantidade++;
        return true;
    }

    double total() {
        double soma = 0;
        for (int i = 0; i < quantidade; i++) {
            soma += itens[i].subtotal();
        }
        return soma;
    }

    void listar() {
        IO.println("Pedido " + numero + ":");
        for (int i = 0; i < quantidade; i++) {
            IO.println("  " + itens[i].getNomeProduto()
                    + " | subtotal: " + itens[i].subtotal());
        }
    }
}

void main() {
    var pedido = new Pedido(101);
    pedido.adicionarItem("Caderno", 2, 15.0);
    pedido.adicionarItem("Caneta", 3, 2.5);

    pedido.listar();
    IO.println("Total: " + pedido.total());
}
