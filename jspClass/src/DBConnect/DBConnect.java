package DBConnect;

import java.sql.*;

/**
 * Created by jay chen on 2016/9/14.
 */
public class DBConnect {
    public static Connection getConn(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","ODFjM2IwODB");
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

    public static void closeConn (Connection connection, Statement statement) {
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
    public static void closeConn (Connection connection, Statement statement, ResultSet rs){
        try {
            if (!connection.isClosed()) {
                connection.close();
            }
            if (!statement.isClosed()) {
                statement.close();
            }
            if(!rs.isClosed()){
                rs.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

