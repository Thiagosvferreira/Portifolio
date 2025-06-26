import application.JogoCrash;
import model.Aposta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JogoCrash jogo = new JogoCrash();

        System.out.print("Digite o valor da aposta: R$ ");
        double valor = scanner.nextDouble();

        System.out.print("Digite o multiplicador para sacar (ex: 2.5): ");
        double multiplicador = scanner.nextDouble();

        Aposta aposta = new Aposta(valor, multiplicador);
        jogo.iniciar(aposta);
    }
}
