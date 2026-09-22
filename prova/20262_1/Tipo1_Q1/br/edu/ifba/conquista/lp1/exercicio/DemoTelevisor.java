package br.edu.ifba.conquista.lp1.exercicio;

import br.edu.ifba.conquista.lp1.exercicio.modelo.Televisor;

public class DemoTelevisor {

    public static void main(String[] args) {

        Televisor tv1 = new Televisor();
        Televisor tv2 = new Televisor(10, 20);

        System.out.println("TV 1");
        System.out.println("Canal: " + tv1.consultarCanal());
        System.out.println("Volume: " + tv1.consultarVolume());

        tv1.alterarCanal(5);
        tv1.aumentarVolume();
        tv1.aumentarVolume();

        System.out.println("Canal: " + tv1.consultarCanal());
        System.out.println("Volume: " + tv1.consultarVolume());

        System.out.println("\nTV 2");
        System.out.println("Canal: " + tv2.consultarCanal());
        System.out.println("Volume: " + tv2.consultarVolume());

        tv2.alterarCanal(20);
        tv2.diminuirVolume();

        System.out.println("Canal: " + tv2.consultarCanal());
        System.out.println("Volume: " + tv2.consultarVolume());
    }
} {
    
}
