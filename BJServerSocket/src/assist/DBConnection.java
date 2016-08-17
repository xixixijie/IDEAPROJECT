package assist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String DBDRIVER="com.mysql.jdbc.Driver";
    private static final String DBURL="jdbc:mysql://localhost:3306/baijia?useSSL=false";
    private static final String DBUSER="root";
    private static final String DBPASSWORD="0000";
    private Connection conn=null;
    public DBConnection() throws SQLException {
        try{
            Class.forName(DBDRIVER);
            this.conn= DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return this.conn;
    }

    public void close() {
        if(this.conn!=null) {
            try {
                this.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
