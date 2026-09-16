/*
Q5 — Classe Relogio
Crie Relogio com int hora (0–23) e int minuto (0–59). Implemente
tic() e texto() no formato HH:MM. Simule 70 tics a partir de 23:50
e informe o horário final.
*/
/*
Para compilar e executar:
cd "aulas/107-exercicios/exercicios2/"
javac Metodos5.java -d bin
java -cp bin Metodos5
*/


class Relogio {
    int hora;
    int minuto;

    Relogio(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }

    void tic() {
        minuto++;
        if (minuto == 60) {
            minuto = 0;
            hora++;
            if (hora == 24) {
                hora = 0;
            }
        }
    }

    String texto() {
        return "%02d:%02d".formatted(hora, minuto);
    }
}

void main() {
    var relogio = new Relogio(23, 50);

    for (int i = 0; i < 70; i++) {
        relogio.tic();
    }

    IO.println("Horário final: " + relogio.texto());
}
