package GUI;

import DataBase.DatabaseHandler;
import com.sun.source.tree.TryTree;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/** Класс контроллера окна логина*/
public class LoginController {
    private double xOffset,yOffset;
    //база данных
    private DatabaseHandler dbHandler = new DatabaseHandler();

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

    @FXML
    private Text WrongLogMessage;

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
        HashMap user = dbHandler.selectUserMail(LoginTextField.getText());
        //Код смены окон
        try {
            //Не пустой если пользователь существует
            if (!user.isEmpty()) {
                if(user.get("password").equals(HidePasswordTextField.getText())||
                        user.get("password").equals(ShowPasswordTextField.getText())) {
                    try {
                        FXMLLoader fxmldr = new FXMLLoader(getClass().getResource("CryptMain.fxml"));
                        Stage stage = new Stage();
                        stage.setTitle("Bag Helper");
                        stage.initStyle(StageStyle.UNDECORATED);
                        Parent root = fxmldr.load();
                        stage.setScene(new Scene(root));
                        //
                        BugController controller = fxmldr.getController();
                        controller.setAtribute(user,dbHandler);
                        TimeUnit.SECONDS.sleep(1);
                        stage.show();
                        ((Node) (event.getSource())).getScene().getWindow().hide();
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
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{
                    WrongLogMessage.setText("Wrong login or password!");
                    WrongLogMessage.setVisible(true);
                }
            } else {
                WrongLogMessage.setText("Wrong login or password!");
                WrongLogMessage.setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
            WrongLogMessage.setText("Database is not available now");
            WrongLogMessage.setVisible(true);
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
