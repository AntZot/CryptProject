package GUI;

import DataBase.DatabaseHandler;
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
/** Класс контроллера окна логина*/
public class LoginController {
    //база данных
    private DatabaseHandler dbHandler;

    @FXML
    private TextField LoginTextField;

    @FXML
    private PasswordField HidePasswordTextField;

    @FXML
    private TextField ShowPasswordTextField;

    @FXML
    public Button LoginButtom;

    @FXML
    private CheckBox ToggleButtom;

    /**
     * Проверяет событие на toggleButtom
     * @param event имеет значение события
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
     * Кнопка ввода данных
     * @param event
     */
    @FXML
    void LoginButtomAnAction(ActionEvent event) {
        System.out.println(LoginTextField.getText());
        //Код смены окон
        if(true){
            try {
            Parent root = FXMLLoader.load(getClass().getResource("CryptMain.fxml"));
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
    }

    /**
     * Кнопка закрытия программы
     * @param event
     */
    @FXML
    void CloseButtomAnAction(ActionEvent event){
        System.exit(0);
    }

}
