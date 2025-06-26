package web;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class TelaExecucao {

    public static Scene criarCena(double valor, double saque) {
        VBox layout = new VBox(20);
        // Estilo inicial do fundo
        String estiloFundoInicial = "-fx-alignment: center; -fx-padding: 40; -fx-background-color: linear-gradient(to top, #3e3e3e, #121212);";
        layout.setStyle(estiloFundoInicial);

        Label multiplicadorLabel = new Label("x1.00");
        multiplicadorLabel.setFont(new Font("Arial", 36));
        multiplicadorLabel.setTextFill(Color.LIME);

        Label fogueteLabel = new Label("🚀");
        fogueteLabel.setFont(new Font(50));

        layout.getChildren().addAll(multiplicadorLabel, fogueteLabel);

        Scene cena = new Scene(layout, 400, 300);

        Timeline timeline = new Timeline();
        final double[] multiplicador = {1.0};

        timeline.getKeyFrames().add(
            new KeyFrame(Duration.millis(100), e -> {
                multiplicador[0] += 0.01;
                multiplicadorLabel.setText(String.format("x%.2f", multiplicador[0]));

                // Atualiza cor do fundo de acordo com multiplicador, mas mantém outras propriedades do estilo
                if (multiplicador[0] > 5.0) {
                    layout.setStyle("-fx-alignment: center; -fx-padding: 40; -fx-background-color: black;");
                } else if (multiplicador[0] > 2.0) {
                    layout.setStyle("-fx-alignment: center; -fx-padding: 40; -fx-background-color: darkblue;");
                } else {
                    layout.setStyle(estiloFundoInicial);
                }

                double crash = Math.random() * 5 + 1; // Valor entre 1.0 e 6.0

                if (multiplicador[0] >= crash) {
                    timeline.stop();
                    multiplicadorLabel.setText("💥 CRASH em x" + String.format("%.2f", multiplicador[0]));
                    fogueteLabel.setText("💣");
                    // Aqui pode tocar som de explosão
                } else if (multiplicador[0] >= saque) {
                    timeline.stop();
                    multiplicadorLabel.setText("✅ Sacou R$" + String.format("%.2f", valor * saque) + " em x" + String.format("%.2f", multiplicador[0]));
                    fogueteLabel.setText("💸");
                    // Aqui pode tocar som de sucesso
                }
            })
        );

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        return cena;
    }
}
