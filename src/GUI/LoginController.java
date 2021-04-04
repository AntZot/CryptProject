package GUI;

import com.sun.source.tree.TryTree;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.concurrent.TimeUnit;

public class LoginController {
    /**
     * Login text field
     */
    @FXML
    private TextField LoginTextField;
    /**
     * Hide password text field
     */
    @FXML
    private PasswordField HidePasswordTextField;

    /**
     * Show password text fiela
     */
    @FXML
    private TextField ShowPasswordTextField;

    /**
     *  Login buttom
     */
    @FXML
    public Button LoginButtom;

    /**
     * Buttom change show/hide password
     */
    @FXML
    private CheckBox ToggleButtom;

    /**
     * Check click events on toggleButtom
     * @param event checking click events
     */
    @FXML
    void TogglePasAnAction(ActionEvent event){
        if(ToggleButtom.isSelected()){
            ShowPasswordTextField.setText(HidePasswordTextField.getText());
            ShowPasswordTextField.setVisible(true);
            HidePasswordTextField.setVisible(false);
            return;
        }
        else{
            HidePasswordTextField.setText(ShowPasswordTextField.getText());
            HidePasswordTextField.setVisible(true);
            ShowPasswordTextField.setVisible(false);
        }
    }

    /**
     * Data entry buttom
     * @param event
     */
    @FXML
    void LoginButtomAnAction(ActionEvent event) {
        System.out.println(LoginTextField.getText());
        //Код смены окон
        /*
        if(если в бд есть пользователь){
            try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Resources/CryptMain.fxml"));
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root));
            TimeUnit.SECONDS.sleep(2);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            //Попробуйте залогиниться снова
        }
        */
    }

    /**
     * Close program
     * @param event
     */
    @FXML
    void CloseButtomAnAction(ActionEvent event){
        System.exit(0);
    }

}
