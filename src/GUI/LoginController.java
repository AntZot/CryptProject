package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {

    /**
     * Login text field
     */
    @FXML
    private TextField LoginTextField;
    /**
     * Password text field
     */
    @FXML
    private TextField PasswordTextField;

    /**
     * Data entry buttom
     * @param event
     */
    @FXML
    void LoginButtomAnAction(ActionEvent event) {
        System.out.println(LoginTextField.getText());

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
