import java.sql.*;
import java.util.Random;

/**
 * Created by jay chen on 2016/5/1.
 */
public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/test";
        Connection con=DriverManager.getConnection(url,"root","0000");


        PreparedStatement ps_s=con.prepareStatement("INSERT into student(id,name,age) VALUES (?," +
                "?,?)");
        PreparedStatement ps_c=con.prepareStatement("INSERT into course(id,name) VALUES (?,?)");
        PreparedStatement ps_sc=con.prepareStatement("INSERT into score(studentid, courseid, " +
                "grade) VALUES (?,?,?)");

        for(int i=0;i<5;i++){
            int id=new Random().nextInt()%5;
            ps_s.setInt(1,id);
            ps_s.setString(2,"name"+i);
            ps_s.setInt(3,18+i);
            ps_s.execute();

            ps_c.setInt(1,id);
            ps_c.setString(2,"course"+id);
            ps_c.execute();

            ps_sc.setInt(1,id);
            ps_sc.setInt(2,id);
            ps_sc.setDouble(3,id/(i+1));
            ps_c.execute();


        }

        Statement sta=con.createStatement();
        ResultSet rs_s=sta.executeQuery("SELECT * from student");

        System.out.println("这是学生表");
        while (rs_s.next()) {
            System.out.println(rs_s.getInt(1)+"\t"+rs_s.getString(2)+"\t"+rs_s.getInt(3));
        }





    }
}
