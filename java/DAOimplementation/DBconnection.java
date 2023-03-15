package DAOimplementation;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
    public static Connection getconnection(){
        Connection connection=null;
        try{
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox","root","Vishnu007@");
//            System.out.println(" connection done");
        }
        catch(Exception e){
            System.out.println(e);
        }
        return connection;
    }


}
