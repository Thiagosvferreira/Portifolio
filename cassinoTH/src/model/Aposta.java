package model;

public class Aposta {
    private double valor;
    private double multiplicadorSaque;

    public Aposta(double valor, double multiplicadorSaque) {
        this.valor = valor;
        this.multiplicadorSaque = multiplicadorSaque;
    }

    public double getValor() {
        return valor;
    }

    public double getMultiplicadorSaque() {
        return multiplicadorSaque;
    }

    public double calcularGanho() {
        return valor * multiplicadorSaque;
    }
}
