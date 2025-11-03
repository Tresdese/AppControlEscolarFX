package appcontrolescolarfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppControlEscolarFX extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent vistaRaiz = FXMLLoader.load(getClass().getResource("vista/FXMLInicioSesion.fxml")); 
            Scene escena = new Scene(vistaRaiz);
            primaryStage.setTitle("Control Escolar - Inicio de Sesión");
            primaryStage.setScene(escena);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
