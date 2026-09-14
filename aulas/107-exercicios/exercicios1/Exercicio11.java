/*
Exercício 11
Implemente uma classe chamada Carro com as seguintes propriedades:

Um veículo tem um certo consumo de combustível (medidos em km/litro) e uma certa quantidade de combustível no tanque.
O consumo é especificado no construtor e o nível de combustível inicial é 0.
Forneça um método andar() que simule o ato de dirigir o veículo por uma certa distância, reduzindo o nível de combustível no tanque de gasolina.
Forneça um método obterGasolina(), que retorna o nível atual de combustível.
Forneça um método adicionarGasolina(), para abastecer o tanque.

Exemplo de uso:
var meuFusca = new Carro(15)  ;     // 15 quilômetros por litro de combustível. 
meuFusca.adicionarGasolina(20);     // abastece com 20 litros de combustível. 
meuFusca.andar(100);                // anda 100 quilômetros.
meuFusca.obterGasolina();           //  Imprime o combustível que resta no tanque.
*/

/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios1/"
javac Exercicio11.java -d bin
java -cp bin Exercicio11
*/
class Carro {
    private final double consumo;
    private double gasolina;

    public Carro(double consumo) {
        this.consumo = consumo;
        this.gasolina = 0;
    }

    public void andar(double distancia) {
        if (distancia <= 0) {
            return;
        }

        var combustivelNecessario = distancia / consumo;

        if (combustivelNecessario > gasolina) {
            IO.println("Combustível insuficiente.");
            return;
        }

        gasolina -= combustivelNecessario;
    }

    public double obterGasolina() {
        return gasolina;
    }

    public void adicionarGasolina(double litros) {
        if (litros > 0) {
            gasolina += litros;
        }
    }
}

public class Exercicio11 {
    void main() {
        var meuFusca = new Carro(15);

        meuFusca.adicionarGasolina(20);
        meuFusca.andar(100);

        IO.println("Gasolina restante: %.2f litros".formatted(
                meuFusca.obterGasolina()
        ));
    }
}