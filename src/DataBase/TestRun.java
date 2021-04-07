package DataBase;
import java.util.HashMap;

public class TestRun {
    public static void main(String[] args) {
        String log = "Gleb";
        String pass = "12345";
        String mail = "glebaiva@gmail.com";
        HashMap user = new HashMap<>();
        DatabaseHandler dbHandler = new DatabaseHandler();
        dbHandler.addBags(mail, "second");
        System.out.println(dbHandler.selectUserMail(mail));
        System.out.println(dbHandler.selectBags(mail));
        System.out.println(dbHandler.selectBags(mail, "first"));
    }
}
