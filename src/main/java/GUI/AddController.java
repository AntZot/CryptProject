package GUI;

import DataBase.DatabaseHandler;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class AddController {
    BugController bagController;
    DatabaseHandler dbHandler;
    HashMap user;
    ObservableList<User> list;

    void setAtribute(HashMap usr, DatabaseHandler dbHand, ObservableList list,BugController bagController){
        user = usr;
        dbHandler = dbHand;
        this.list = list;
        this.bagController = bagController;
    }

    @FXML
    private Text WrongName;
    @FXML
    private Button closeBtm;

    @FXML
    private Button SetBagNameBtn;

    @FXML
    private TextField BagName;

    @FXML
    void ClickHandler(ActionEvent event) {
        if(event.getSource() == closeBtm){
            Stage stg = (Stage) closeBtm.getScene().getWindow();
            stg.close();
        }
    }

    public void SetBagNameHandler(ActionEvent event){
        if(event.getSource() == SetBagNameBtn){
            if(!BagName.getText().isEmpty()) {
                list.add(new User(bagController,BagName.getText()));
                dbHandler.addBags((String) user.get("mail"), BagName.getText());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Stage stg = (Stage) closeBtm.getScene().getWindow();
                stg.close();
            }
            else{
                WrongName.setText("Bad name, set other name");
                WrongName.setVisible(true);
            }
        }
    }

}
