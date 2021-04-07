package DataBase;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.jdbc.ScriptRunner;


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
    public void deleteUser(String mail)
    {
        try {
            String del = "DELETE FROM " + Const.USER_TABLE + " WHERE " + Const.USER_MAIL + " = ?";
            PreparedStatement prSt = getDbConnection().prepareStatement(del);
            prSt.setString(1, mail);
            prSt.execute();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public HashMap selectUserMail(String mail)
    {
        String sel = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_MAIL + " = ?";
        HashMap<String, String> content = new HashMap<>();
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sel);
            prSt.setString(1, mail);
            ResultSet res = prSt.executeQuery();
            res.next();
            content.put(Const.USER_LOGIN, res.getString(Const.USER_LOGIN));
            content.put(Const.USER_PASSWORD, res.getNString(Const.USER_PASSWORD));
            content.put(Const.USER_MAIL, res.getNString(Const.USER_MAIL));
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

    public void addBags(String mail , String bagName)
    {
        HashMap user;
        user = this.selectUserMail(mail);
        String insert = "INSERT INTO " + Const.BAGS_TABLE + "(" +
                Const.BAG_NAME + "," + Const.BAG_USERS_MAIL + "," +
                Const.BAG_PROFIT + ")" + "VALUES(?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, bagName);
            prSt.setString(2, (String) user.get(Const.USER_MAIL));
            prSt.setInt(3,  0);
            prSt.execute();
        } catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public void deleteBags(String mail, String bagName){
        HashMap user;
        user = this.selectUserMail(mail);
        try {
            String del = "DELETE FROM " + Const.BAGS_TABLE + " WHERE " + Const.BAG_USERS_MAIL +  " = ?"
                    + " AND " + Const.BAG_NAME + " = ?";
            PreparedStatement prSt = getDbConnection().prepareStatement(del);
            prSt.setString(1, Const.BAG_USERS_MAIL);
            prSt.setString(2, bagName);
            prSt.execute();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public HashMap selectBags(String mail, String bagName){
        HashMap user;
        user = this.selectUserMail(mail);
        String sel = "SELECT * FROM " + Const.BAGS_TABLE + " WHERE " + Const.BAG_USERS_MAIL + " = ?"+
                " AND " + Const.BAG_NAME + " = ?";
        HashMap<String, String> content = new HashMap<>();
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sel);
            prSt.setString(1, Const.BAG_USERS_MAIL);
            prSt.setString(2, bagName);
            ResultSet res = prSt.executeQuery();
            res.next();
            content.put(Const.BAG_USERS_MAIL, res.getString(Const.BAG_USERS_MAIL));
            content.put(Const.BAG_NAME, res.getString(Const.BAG_NAME));
            content.put(Const.BAG_PROFIT, res.getString(Const.BAG_PROFIT));
            content.put(Const.BAG_ID, res.getString(Const.BAG_ID));
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return content;
    }

    public ArrayList selectBags(String mail){
        HashMap user;
        user = this.selectUserMail(mail);
        String sel = "SELECT * FROM " + Const.BAGS_TABLE + " WHERE " + Const.BAG_USERS_MAIL + " = ?";
        ArrayList<HashMap<String, String>> content = new ArrayList<>();
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sel);
            prSt.setString(1, (String) user.get(Const.BAG_USERS_MAIL));
            ResultSet res = prSt.executeQuery();
            while (res.next())
            {
                HashMap<String, String> bag = new HashMap<>();
                bag.put(Const.BAG_ID, res.getString(Const.BAG_ID));
                bag.put(Const.BAG_NAME, res.getString(Const.BAG_NAME));
                bag.put(Const.BAG_PROFIT, res.getString(Const.BAG_PROFIT));
                bag.put(Const.BAG_USERS_MAIL, res.getString(Const.BAG_USERS_MAIL));
                content.add(bag);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return content;
    }

    public void updateProfitBags(String mail, String bagName, int profit)
    {
        HashMap user;
        user = this.selectUserMail(mail);
        try {
            String update = "UPDATE " + Const.BAGS_TABLE + " SET " + Const.BAG_PROFIT +  " = ? "+
                    "WHERE " + Const.BAG_USERS_MAIL + " = ?" + "AND " + Const.BAG_NAME + " = ?";
            PreparedStatement prSt = getDbConnection().prepareStatement(update);
            prSt.setInt(1, profit);
            prSt.setString(2, Const.BAG_USERS_MAIL);
            prSt.setString(3, bagName);
            prSt.execute();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
