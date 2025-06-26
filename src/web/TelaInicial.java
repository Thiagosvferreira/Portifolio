package web;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TelaInicial extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button jogarAgoraBtn = new Button("Jogar Agora");

        jogarAgoraBtn.setOnAction(e -> {
            Scene jogoCena = TelaJogo.criarCena(primaryStage); // <-- atualizado
            primaryStage.setScene(jogoCena);
        });

        StackPane layout = new StackPane(jogarAgoraBtn);
        Scene telaInicial = new Scene(layout, 400, 300);

        primaryStage.setTitle("Crash TH Foguete");
        primaryStage.setScene(telaInicial);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
