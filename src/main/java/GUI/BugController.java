package GUI;

import DataBase.DatabaseHandler;
import Stock.StockTest;
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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.commons.lang3.tuple.Pair;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

/** Класс контроллера главного окна приложения*/
public class BugController implements Initializable {
    private double xOffset,yOffset;
    private int count=0;
    private DatabaseHandler dbHandler;
    private HashMap user;

    ObservableList<User> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        table.setItems(list);
        bag.setCellValueFactory(new PropertyValueFactory<>("bag"));
        //loadBag();
    }

    /**
     * Функция передачи данных в контроллер
     * @param usr
     * @param dbHand
     */
    void setAtribute(HashMap usr, DatabaseHandler dbHand){
        user = usr;
        dbHandler = dbHand;
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

    @FXML
    private Button BagAddInList;

    @FXML
    private ListView<String> BagList;

    @FXML
    private TextField SearchField;


    @FXML
    private AnchorPane BagPain;

    @FXML
    private TableView<User> table;

    @FXML
    private TableColumn<User, Button> bag;

    @FXML
    private Button MainBtm;

    @FXML
    private Button addBtm;

    @FXML
    private Button exitBtm;

    @FXML
    private AnchorPane mainPain;

    @FXML
    private Text BagLabelName;

    /**
     * Обрабатывает все события
     * @param event имеет значение события
     */
    @FXML
    public void ClickHandler(ActionEvent event){

        for(User us : list){
            if(event.getSource() == us.getBag()) {
                BagLabelName.setText(us.getBag().getText());
                BagList.getItems().clear();
                SearchField.clear();
                loadBag(us);
                mainPain.setVisible(false);
                BagPain.setVisible(true);
                break;
            }
        }

        //Добавление акции
        if(event.getSource() == BagAddInList){
            if(BagList == null){
                BagList = new ListView<>();
            }
            BagList.getItems().add(SearchField.getText());
            for(User us: list) {
                if(us.bag.getText().equals(BagLabelName.getText())){
                    StockTest stock = new StockTest();
                    us.paperName.put(SearchField.getText(),(ArrayList) stock.getStock().get(SearchField.getText()));
                    break;
                }
            }
        }

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
                cntrl.setAtribute(user,dbHandler,list,this);
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

    /**
     * Метод, который загружает из бд портфели по e-mail пользователя
     */
    void loadBag(User us){
        if(us!=null) {
            if (us.paperName != null) {
                for (String st : us.paperName.keySet()) {
                    BagList.getItems().add(st);

                }
            }
        }
        /*
        for(ArrayList list : (ArrayList<ArrayList>) dbHandler.selectBags((String) user.get("mail")) ){
        list.add(new User(this,""));
        }*/
    }
}


