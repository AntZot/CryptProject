package GUI;


import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class User {
    Button bag;

    User(BugController controller,String butText){
        bag = new Button(butText);
        bag.prefWidth(200);
        bag.setId("BagsVariant");
        bag.addEventHandler(ActionEvent.ANY, event -> controller.ClickHandler(event));
    }

    public Button getBag() {
        return bag;
    }

    public void setBag(Button bag) {
        this.bag = bag;
    }
}
