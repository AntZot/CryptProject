package DataBase;

import java.sql.*;
import java.util.HashMap;

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
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return content;
    }
}
