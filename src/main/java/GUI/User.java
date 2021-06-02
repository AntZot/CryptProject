package GUI;


import javafx.scene.control.Button;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class User {
    Button bag;

    User(String butText){
        bag = new Button(butText);
        bag.prefWidth(200);
        bag.setId("BagsVariant");
    }

    public Button getBag() {
        return bag;
    }

    public void setBag(Button bag) {
        this.bag = bag;
    }
}
