class ItemPedido {

    private String nomeProduto;
    private int quantidade;
    private double precoUnitario;

    public ItemPedido(String nomeProduto, int quantidade,
                      double precoUnitario) {

        if (nomeProduto == null || nomeProduto.isBlank()) {
            System.out.println("Nome do produto inválido.");
        }

        if (quantidade <= 0) {
            System.out.println("A quantidade deve ser positiva.");
        }

        if (precoUnitario < 0) {
            System.out.println("O preço não pode ser negativo.");
        }

        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public double subtotal() {
        return quantidade * precoUnitario;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }
}


class Pedido {

    private int numero;

    private ItemPedido[] itens;

    private int quantidadeItens;

    public Pedido(int numero) {
        this.numero = numero;
        this.itens = new ItemPedido[20];
        this.quantidadeItens = 0;
    }

    public void adicionarItem(ItemPedido item) {

        if (item == null) {
            System.out.println("O item não pode ser nulo.");
        }

        if (quantidadeItens >= itens.length) {
            System.out.println("O pedido já possui 20 itens.");
        }

        itens[quantidadeItens] = item;
        quantidadeItens++;
    }

    public double total() {

        double total = 0;

        for (int i = 0; i < quantidadeItens; i++) {
            total += itens[i].subtotal();
        }

        return total;
    }

    public int getNumero() {
        return numero;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }

    public ItemPedido getItem(int indice) {

        if (indice < 0 || indice >= quantidadeItens) {
            System.out.println("Índice fora dos limites aceitáveis");
        }

        return itens[indice];
    }
}


public class MainPedido {

    public static void main(String[] args) {

        Pedido pedido = new Pedido(1001);

        ItemPedido item1 =
            new ItemPedido("Teclado", 2, 80.00);

        ItemPedido item2 =
            new ItemPedido("Mouse", 1, 50.00);

        ItemPedido item3 =
            new ItemPedido("Monitor", 1, 700.00);

        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);
        pedido.adicionarItem(item3);

        System.out.println(
            "Pedido: " + pedido.getNumero()
        );

        System.out.println(
            "Quantidade de itens: "
            + pedido.getQuantidadeItens()
        );

        System.out.println(
            "Total: R$ " + pedido.total()
        );
    }
}