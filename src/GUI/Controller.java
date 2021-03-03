package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private Button exitBtm;

    @FXML
    public void ClickHandler(ActionEvent event){
        if(event.getSource() == exitBtm){
            System.exit(0);
        }
    }
}


