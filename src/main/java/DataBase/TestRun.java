package DataBase;
import java.util.HashMap;

public class TestRun {
    public static void main() {
        String log = "1";
        String pass = "1";
        String mail = "1";
        HashMap user = new HashMap<>();
        DatabaseHandler dbHandler = new DatabaseHandler();
        //dbHandler.createDataBase();
        //dbHandler.addUser(log,pass, mail);
        dbHandler.addBags(mail, "first");
        dbHandler.addBagsContent(mail, "SBER", "SBERBANK", 5, "FirstBag");
//        dbHandler.deleteBagsContent(mail, "first", "tink");
//        dbHandler.addUser("anton", pass, "anton");
//        dbHandler.addBags(mail, "first");
//        dbHandler.addBags("anton", "first");
//        dbHandler.addBagsContent(mail, "first", "SBER", "SBERBANK", 1);
//        dbHandler.addBagsContent("anton", "first", "SBER", "SBERBANK", 1);

    }
}
