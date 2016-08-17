import java.sql.*;

/**
 * Created by jay chen on 2016/5/1.
 */
public class InsertInfo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
        Connection con=DriverManager.getConnection(url,"root","0000");

        PreparedStatement pre=con.prepareStatement("insert into Student1(id,name,age) values(?," +
                "?," +
                "?)");


        for(int i=0;i<3;i++){
            pre.setInt(1,i);
            pre.setString(2,"张"+i);
            pre.setInt(3,18+i);
            pre.execute();
        }


        Statement sta=con.createStatement();

        ResultSet rs=sta.executeQuery("SELECT * FROM student1");

        while (rs.next()) {
            int id=rs.getInt(1);
            String name=rs.getString("name");
            int age=rs.getInt(3);
            System.out.println(id+"\t"+name+" "+age);//'\t'多几个空格  '\r'退格
        }
        con.close();




    }
}
