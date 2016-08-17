/**
 * Created by jay chen on 2016/5/1.
 */
import java.sql.*;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/test?useSSL=true";

        Connection con=DriverManager.getConnection(url,"root","0000");

      Statement sta=con.createStatement();


     /*   ResultSet resule=sta.executeQuery("select name,age from employee");

        while(resule.next()){
            String name=resule.getString(1);
            int age=resule.getInt(2);//还可以 getInt("age");通过列名来获得数据
            System.out.println(name+"\t"+age);
        }*/




    }
}
