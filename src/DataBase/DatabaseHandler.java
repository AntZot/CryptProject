package DataBase;

import java.io.*;
import java.sql.*;
import java.util.HashMap;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.commons.io.IOUtils;


public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException
    {
      String connectionString = "jdbc:mysql://" + dbHost + ":"
              + dbPort + "/" + dbName;

      dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

      return dbConnection;
    }

    public void addUser(String login, String password, String mail)
    {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.USER_LOGIN + "," + Const.USER_PASSWORD + "," +
                Const.USER_MAIL + ")" + "VALUES(?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, login);
            prSt.setString(2, password);
            prSt.setString(3, mail);

            prSt.execute();
        } catch (SQLException | ClassNotFoundException e)
        {
         e.printStackTrace();
        }


    }
    public void deleteUser(String login)
    {
        try {
            String del = "DELETE FROM " + Const.USER_TABLE + " WHERE login = ?";
            PreparedStatement prSt = getDbConnection().prepareStatement(del);
            prSt.setString(1, login);
            prSt.execute();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public HashMap selectUserLogin(String login)
    {
        String sel = "SELECT * FROM " + Const.USER_TABLE + " WHERE LOGIN = ?";
        HashMap<String, String> content = new HashMap<>();
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sel);
            prSt.setString(1, login);
            ResultSet res = prSt.executeQuery();
            res.next();
            content.put("log", res.getString("login"));
            content.put("password", res.getNString("password"));
            content.put("mail", res.getNString("mail"));
            content.put("id", res.getString("idusers"));
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return content;
    }

    public void createDataBase()
    {
        try {
            Connection con = getDbConnection();
            Reader reader = new BufferedReader(new FileReader("src/DataBase/my_first_db.sql"));
            ScriptRunner sr = new ScriptRunner(con);
            sr.runScript(reader);

        } catch (SQLException | ClassNotFoundException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addBags(String login , String bagName)
    {
        HashMap user;
        user = this.selectUserLogin(login);
        String insert = "INSERT INTO " + Const.BAGS_TABLE + "(" +
                Const.BAG_NAME + "," + Const.BAG_USERS_ID + "," +
                Const.BAG_PROFIT + ")" + "VALUES(?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, bagName);
            prSt.setString(2, (String) user.get("id"));
            prSt.setString(3,  "0");
            prSt.execute();
        } catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
