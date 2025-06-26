package application;

import model.Aposta;
import utils.CrashSimulator;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class JogoCrash {
    private final CrashSimulator simulator;

    public JogoCrash() {
        this.simulator = new CrashSimulator();
    }

    public void iniciar(Aposta aposta) {
        System.out.println("🔥 Acendendo foguete...");
        tocarSom("sounds/isqueiro.wav");
        esperar(1000);
        System.out.println("🚀 Subindo multiplicador...");

        double crash = simulator.gerarCrash();
        double atual = 1.0;

        while (atual < crash && atual < aposta.getMultiplicadorSaque()) {
            System.out.printf("🟢 x%.2f%n", atual);
            esperar(500);
            atual += 0.10;
        }

        System.out.printf("💥 Crashou em x%.2f%n", crash);

        if (aposta.getMultiplicadorSaque() < crash) {
            double ganho = aposta.calcularGanho();
            System.out.printf("🎉 Você SACOU e ganhou: R$ %.2f%n", ganho);
        } else {
            System.out.println("❌ Você PERDEU tudo!");
            tocarSom("sounds/explosao.wav");
        }
    }

    private void esperar(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void tocarSom(String caminho) {
        try {
            File soundFile = new File(caminho);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("🔇 Erro ao tocar som: " + e.getMessage());
        }
    }
}
