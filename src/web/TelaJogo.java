package web;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TelaJogo {

    public static Scene criarCena(Stage primaryStage) {
        Label titulo = new Label("Crash TH Foguete 🚀");
        titulo.setFont(new Font(20));

        Label valorLabel = new Label("Valor da Aposta:");
        TextField valorField = new TextField();

        Label saqueLabel = new Label("Multiplicador de Saque:");
        TextField saqueField = new TextField();

        Button iniciarBtn = new Button("Iniciar");

        iniciarBtn.setOnAction(e -> {
            String valorText = valorField.getText().trim();
            String saqueText = saqueField.getText().trim();

            if (valorText.isEmpty() || saqueText.isEmpty()) {
                mostrarAlerta("Preencha todos os campos.");
                return;
            }

            try {
                double valor = Double.parseDouble(valorText);
                double saque = Double.parseDouble(saqueText);

                if (saque < 1.0) {
                    mostrarAlerta("O multiplicador de saque deve ser maior ou igual a 1.");
                    return;
                }

                Scene execucaoCena = TelaExecucao.criarCena(valor, saque);
                primaryStage.setScene(execucaoCena);

            } catch (NumberFormatException ex) {
                mostrarAlerta("Digite números válidos (ex: 10 ou 2.5).");
            }
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(
            titulo,
            valorLabel,
            valorField,
            saqueLabel,
            saqueField,
            iniciarBtn
        );

        return new Scene(layout, 400, 300);
    }

    private static void mostrarAlerta(String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Aviso");
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}
