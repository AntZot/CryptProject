package GUI;


import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class User {
    Button bag;
    HashMap<String,ArrayList<Pair<Date,Double>>> paperName = new HashMap<>();
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
