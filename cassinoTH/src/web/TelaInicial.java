package web;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TelaInicial extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button botaoJogar = new Button("Jogar Agora");

        botaoJogar.setOnAction(e -> {
            System.out.println("🚀 Jogar Agora clicado!");
            TelaJogo.exibir(primaryStage); // Correto: stage passado como parâmetro
        });

        StackPane root = new StackPane(botaoJogar);
        Scene cenaInicial = new Scene(root, 400, 200);

        primaryStage.setScene(cenaInicial);
        primaryStage.setTitle("TH Foguete - Início");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
