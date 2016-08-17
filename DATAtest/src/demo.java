import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by jay chen on 2016/5/8.
 */
public class demo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn= DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/test?useSSL=false",
                "root",
                "0000");
        Statement sta= conn.createStatement();

        sta.executeQuery("show tables");
    }

}
