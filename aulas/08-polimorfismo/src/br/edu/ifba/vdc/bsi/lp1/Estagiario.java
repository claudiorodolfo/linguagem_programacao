package br.edu.ifba.vdc.bsi.lp1;

public class Estagiario extends Funcionario {

    private double valeTransporte;

    public Estagiario(String nome, double bolsa, double valeTransporte) {
        super(nome, bolsa);
        this.valeTransporte = valeTransporte;
    }

    public double getValeTransporte() {
        return valeTransporte;
    }

    /** Versão “limpa” do instanceof da Q3. */
    public double beneficioTransporte() {
        return valeTransporte;
    }
}
