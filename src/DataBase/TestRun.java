package DataBase;
import java.util.HashMap;

public class TestRun {
    public static void main(String[] args) {
        String log = "Gleb";
        String pass = "12345";
        String mail = "glebaiva@gmail.com";
        HashMap user = new HashMap<>();
        DatabaseHandler dbHandler = new DatabaseHandler();
        dbHandler.addBagsContent(mail, "first", "fgj", "ABfgjSDF", 5);
//        dbHandler.deleteBagsContent(mail, "first", "tink");
//        dbHandler.addUser(log,pass, mail);
//        dbHandler.addUser("anton", pass, "anton");
//        dbHandler.addBags(mail, "first");
//        dbHandler.addBags("anton", "first");
//        dbHandler.addBagsContent(mail, "first", "SBER", "SBERBANK", 1);
//        dbHandler.addBagsContent("anton", "first", "SBER", "SBERBANK", 1);

    }
}
