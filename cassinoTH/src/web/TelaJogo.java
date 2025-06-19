package web;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.geometry.Pos;

public class TelaJogo {

    private static double multiplicador = 1.0;
    private static Label labelMultiplicador;
    private static Timeline timeline;

    public static void exibir(Stage stage) {
        multiplicador = 1.0;

        labelMultiplicador = new Label("🚀 1.00x");
        labelMultiplicador.setTextFill(Color.LIMEGREEN);
        labelMultiplicador.setFont(Font.font("Consolas", 48));

        TextField campoAposta = new TextField();
        campoAposta.setPromptText("Valor da aposta");

        TextField campoRetirada = new TextField();
        campoRetirada.setPromptText("Multiplicador para retirada (ex: 2.5)");

        Button botaoApostar = new Button("Apostar");

        botaoApostar.setOnAction(e -> {
            try {
                double valorAposta = Double.parseDouble(campoAposta.getText());
                double retiradaEm = Double.parseDouble(campoRetirada.getText());

                if (valorAposta <= 0 || retiradaEm <= 1.0) {
                    throw new NumberFormatException();
                }

                iniciarSimulacao(valorAposta, retiradaEm);

                // Desativa inputs após início da aposta
                campoAposta.setDisable(true);
                campoRetirada.setDisable(true);
                botaoApostar.setDisable(true);

            } catch (NumberFormatException ex) {
                Alert alert = new Alert(AlertType.ERROR, "Insira valores válidos:\n- Aposta > 0\n- Retirada > 1.0");
                alert.show();
            }
        });

        VBox layout = new VBox(20, labelMultiplicador, campoAposta, campoRetirada, botaoApostar);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #121212;");

        Scene cena = new Scene(layout, 800, 600);
        stage.setScene(cena);
        stage.setTitle("TH Foguete - Jogo");
    }

    private static void iniciarSimulacao(double valorAposta, double retiradaEm) {
        timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> atualizarMultiplicador(valorAposta, retiradaEm)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private static void atualizarMultiplicador(double valorAposta, double retiradaEm) {
        multiplicador += 0.05;
        labelMultiplicador.setText("🚀 " + String.format("%.2f", multiplicador) + "x");

        if (multiplicador >= retiradaEm) {
            timeline.stop();
            double ganho = valorAposta * retiradaEm;
            Platform.runLater(() -> labelMultiplicador.setText("✅ Retirado! Lucro: R$" + String.format("%.2f", ganho)));
        } else if (multiplicador >= 10.00) {
            timeline.stop();
            Platform.runLater(() -> labelMultiplicador.setText("💥 CRASH! Você perdeu R$" + String.format("%.2f", valorAposta)));
        }
    }
}
