/*
Q6 — Pacote e visibilidade
Duas classes no mesmo pacote: Estoque (atributo visibilidade com
pacote int quantidade) e Inventario. Inventario altera quantidade
diretamente. Mova Inventario para outro pacote: o que deixa de
compilar? Qual modificador você usaria de verdade e por quê?
*/
/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios2/"
javac Pacotes6.java -d bin
java -cp bin Pacotes6
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

// quantidade não possui um modificador de acesso. 
// Nesse caso, ela possui visibilidade de pacote (package-private). 
// 
// Isso significa que qualquer classe do MESMO pacote pode acessar 
// quantidade diretamente. Por isso, neste exemplo, Inventario pode fazer: 
// 
//     estoque.quantidade += qtd; 
//
// Se Inventario estiver em OUTRO pacote, esse acesso deixa de funcionar, 
// porque um atributo package-private não pode ser acessado de outro pacote. 
// 
// Na prática, preferimos proteger o estado da classe: 
// 
//     private int quantidade; 
// 
// Assim, somente Estoque pode alterar diretamente sua quantidade.
// Outras classes precisam pedir que Estoque faça a operação:
// 
//     estoque.entrada(qtd); 
// 
// Dessa forma, Estoque pode controlar as regras do seu próprio estado,
// por exemplo, não permitir que uma saída deixe a quantidade negativa.
// 
// Essa é uma ideia importante de encapsulamento: 
// a classe deve proteger seus dados e controlar como eles podem ser alterados.
}
