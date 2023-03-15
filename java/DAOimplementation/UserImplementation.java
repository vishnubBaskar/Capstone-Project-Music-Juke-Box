package DAOimplementation;

import DAOinterface.UserInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class UserImplementation implements UserInterface {
    Scanner scanner=new Scanner(System.in);
    Connection connection=null;
    @Override
    public boolean createAccount() throws SQLException {
        try {
            System.out.println("ENTER NEW USERNAME");
            String username = scanner.next();
            System.out.println("ENTER NEW PASSWORD");
            String password = scanner.next();
            System.out.println("ENTER NEW MOBILENUMBER");
            String mobilenumber = scanner.next();
            connection = DBconnection.getconnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into jukebox.user(userid,password,mobilenumber)values(?,?,?)");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, mobilenumber);
            preparedStatement.executeUpdate();
            System.out.println("VALUES UPDATED");
        }
        catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean login() throws SQLException {
        try {
            System.out.println("ENTER USER NAME");
            String username = scanner.next();
            System.out.println("ENTER USER PASSWORD");
            String password = scanner.next();
            connection = DBconnection.getconnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user where userid=? and password=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                System.out.println("LOGIN SUCCESSFULLY");
                System.out.println("HELLO WELCOME"+username);
                return true;
            } else {
                System.out.println("INVALID  CREDENTIALS");
                System.out.println("GIVE THE CORRECT CREDENTIALS");
                System.exit(0);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
}
