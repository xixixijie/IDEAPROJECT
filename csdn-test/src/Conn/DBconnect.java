package Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by jay chen on 2016/8/28.
 */
public class DBconnect {
    public static Connection getConn(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/csdn","root","00000000");
                if (connection == null) {
                    System.out.println(1);
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConn (Connection connection, Statement statement){
        try {
            if (!connection.isClosed()) {
                connection.close();
            }
            if (!statement.isClosed()) {
                statement.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
