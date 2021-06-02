package GUI;

import DataBase.DatabaseHandler;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

/** Класс контроллера главного окна приложения*/
public class BugController implements Initializable {
    private double xOffset,yOffset;
    private int count=0;
    private DatabaseHandler dbHandler;
    private HashMap user;

    void setAtribute(HashMap usr, DatabaseHandler dbHand){
        user = usr;
        dbHandler = dbHand;
    }

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    private TableView<User> table;

    @FXML
    private TableColumn<User, Button> bag;

    ObservableList<User> list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        table.setItems(list);
        bag.setCellValueFactory(new PropertyValueFactory<>("bag"));

    }

    @FXML
    private Button MainBtm;

    @FXML
    private Button addBtm;

    @FXML
    private Button exitBtm;

    @FXML
    private AnchorPane mainPain;

    /**
     * Обрабатывает все события
     * @param event имеет значение события
     */
    @FXML
    public void ClickHandler(ActionEvent event){

        if(event.getSource() == MainBtm){
            mainPain.setVisible(true);
        }

        if(event.getSource() == addBtm){
            try{
                FXMLLoader fxmldr = new FXMLLoader(getClass().getResource("AddBagPage.fxml"));
                Stage stage = new Stage();
                stage.setTitle("My New Stage Title");
                stage.initStyle(StageStyle.UNDECORATED);
                Parent root =fxmldr.load();
                stage.setScene(new Scene(root));
                AddController cntrl = fxmldr.getController();
                cntrl.setAtribute(user,dbHandler,list);
                stage.show();
                ChangePosition(root, stage);
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        if(event.getSource() == exitBtm){
            System.exit(0);
        }
    }

    void ChangePosition(Parent root, Stage stage){
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
    }
}


