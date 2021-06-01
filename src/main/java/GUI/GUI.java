package GUI;

import DataBase.DatabaseHandler;
import DataBase.TestRun;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;

/** Класс запуска графического интерфейса*/
public class GUI extends Application {
    Parent root;
    private double xOffset,yOffset;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Стартовая точка запуска GUI
     * @param primaryStage параметры окна
     */
    @Override
    public void start(Stage primaryStage) {
        //TestRun.main();//Заполнение бд
        try{
            root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("CryptBox");
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);
            primaryStage.setScene(scene);
            primaryStage.show();
            root.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = primaryStage.getX() - event.getScreenX();
                    yOffset = primaryStage.getY() - event.getScreenY();
                }
            });
            root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    primaryStage.setX(event.getScreenX() + xOffset);
                    primaryStage.setY(event.getScreenY() + yOffset);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
