/*
Exercício 10
Faça um programa completo utilizando classes e métodos que:

1. Possua uma classe chamada bombaCombustível, com no mínimo esses atributos:
tipoCombustivel
valorLitro
quantidadeCombustivel

2. Possua no mínimo esses métodos:
abastecerPorValor(): método onde é informado o valor a ser abastecido e mostra a quantidade de litros que foi colocada no veículo
abastecerPorLitro(): método onde é informado a quantidade em litros de combustível e mostra o valor a ser pago pelo cliente.
alterarValor(): altera o valor do litro do combustível.
alterarCombustivel(): altera o tipo do combustível.
alterarQuantidadeCombustivel(): altera a quantidade de combustível restante na bomba.
OBS: Sempre que acontecer um abastecimento é necessário atualizar a quantidade de combustível total na bomba.
*/

/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios1/"
javac Exercicio10.java -d bin
java -cp bin Exercicio10
*/
class BombaCombustivel {
    private String tipoCombustivel;
    private double valorLitro;
    private double quantidadeCombustivel;

    public BombaCombustivel(
            String tipoCombustivel,
            double valorLitro,
            double quantidadeCombustivel) {

        this.tipoCombustivel = tipoCombustivel;
        this.valorLitro = valorLitro;
        this.quantidadeCombustivel = quantidadeCombustivel;
    }

    public void abastecerPorValor(double valor) {
        if (valor <= 0) {
            return;
        }

        var litros = valor / valorLitro;

        if (litros > quantidadeCombustivel) {
            IO.println("Combustível insuficiente na bomba.");
            return;
        }

        quantidadeCombustivel -= litros;

        IO.println("Foram abastecidos %.2f litros.".formatted(litros));
    }

    public void abastecerPorLitro(double litros) {
        if (litros <= 0) {
            return;
        }

        if (litros > quantidadeCombustivel) {
            IO.println("Combustível insuficiente na bomba.");
            return;
        }

        var valor = litros * valorLitro;
        quantidadeCombustivel -= litros;

        IO.println("Valor a pagar: R$ %.2f".formatted(valor));
    }

    public void setValor(double valorLitro) {
        if (valorLitro > 0) {
            this.valorLitro = valorLitro;
        }
    }

    public void setCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public void setQuantidadeCombustivel(
            double quantidadeCombustivel) {

        if (quantidadeCombustivel >= 0) {
            this.quantidadeCombustivel = quantidadeCombustivel;
        }
    }

    public double getQuantidadeCombustivel() {
        return quantidadeCombustivel;
    }
}

public class Exercicio10 {
    void main() {
        var bomba = new BombaCombustivel(
                "Gasolina",
                6.20,
                1000
        );

        bomba.abastecerPorValor(100);
        bomba.abastecerPorLitro(20);

        IO.println("Restante na bomba: %.2f litros".formatted(
                bomba.getQuantidadeCombustivel()
        ));
    }
}