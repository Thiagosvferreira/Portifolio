package web;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Configura o título da janela
        primaryStage.setTitle("Crash TH Foguete 🚀");

        // Cria a cena inicial da interface gráfica com o form de aposta
        Scene cenaInicial = TelaJogo.criarCena(primaryStage);

        // Define a cena inicial na janela
        primaryStage.setScene(cenaInicial);

        // Mostra a janela
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Lança a aplicação JavaFX (chama start)
        launch(args);
    }
}
