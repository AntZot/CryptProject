package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class GUI extends Application {
    Parent root;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("CryptMain.xml"));
        }catch (Exception e){

        }
    }
}
