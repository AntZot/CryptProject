package DataBase;
import java.util.ArrayList;
import java.util.HashMap;

public class TestRun {
    public static void main(String[] args) {
        String log = "Gleb";
        String pass = "12345";
        String mail = "glebaiva@gmail.com";
        HashMap user = new HashMap<>();
        ArrayList<HashMap> bag = new ArrayList<>();
        DatabaseHandler dbHandler = new DatabaseHandler();
        bag = dbHandler.selectBagsContent(mail,"Se");
        System.out.println(bag);
//        dbHandler.addBagsContent(mail, "SBER", "SBERBANK", 5, "FirstBag");
//        dbHandler.deleteBagsContent(mail, "first", "tink");
//        dbHandler.addUser(log,pass, mail);
//        dbHandler.addUser("anton", pass, "anton");
//        dbHandler.addBags(mail, "first");
//        dbHandler.addBags("anton", "first");
//        dbHandler.addBagsContent(mail, "first", "SBER", "SBERBANK", 1);
//        dbHandler.addBagsContent("anton", "first", "SBER", "SBERBANK", 1);

    }
}
