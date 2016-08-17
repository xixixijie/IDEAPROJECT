/**
 * Created by jay chen on 2016/4/27.
 */
import java.sql.*;
public class HELLO {
    public static void main(String[] args){
        try {

            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con;
            con= DriverManager.getConnection("jdbc:mysql://localhost/Mysql?useSSL=true", "root", "0000");


            PreparedStatement pstm=con.prepareStatement("insert into employee(Last_NAME) values(?)");

            for(int i=0;i<10;i++){
                pstm.setInt(1,i);
                pstm.execute();
            }

            pstm.close();








            con.close();




        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

