package GUI;

import DataBase.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.ResourceBundle;

/** Класс контроллера главного окна приложения*/
public class AuthController implements Initializable {
    private boolean isLogin;
    final private ArrayList<XYChart.Series> list = new ArrayList<>();
    private DatabaseHandler dbHandl;
    private int count=0;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;


    @FXML
    private LineChart<?, ?> Graph;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    private Button exitBtm;

    @FXML
    private Button addBtm;

    /**
     * Обрабатывает все события
     * @param event имеет значение события
     */
    @FXML
    public void ClickHandler(ActionEvent event){

        if(event.getSource() == exitBtm){
            System.exit(0);
        }

        if(event.getSource() == addBtm){
            XYChart.Series sr = new XYChart.Series();
            sr.getData().add(new XYChart.Data(""+count+2,count));
            sr.setName("Cr"+count);
            list.add(sr);
            //sr.getData().clear();
            for(XYChart.Series ser : list){
                Graph.getData().add(ser);
            }
            count++;
        }
    }
}


