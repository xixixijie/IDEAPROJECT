package dao;

import DBConnect.DBConnect;
import bean.Student;
import org.w3c.dom.ls.LSException;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xixi on 16/04/2017.
 */
public class stuAction {
    //增
    public static boolean addToDB(Student u){
        System.out.println(u.getAcademy());
        Connection conn=DBConnect.getConn();
        String  sql="insert into student(id,pwd,academy,major,name,sex) values(?,?,?,?,?,?)";
        int judge=0;
        try {
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setString(1,u.getId());
            ps.setString(2,u.getPwd());
            ps.setString(3,u.getAcademy());
            ps.setString(4,u.getMajor());
            ps.setString(5,u.getName());
            ps.setString(6,u.getSex());

            judge=ps.executeUpdate();
            DBConnect.closeConn(conn,ps);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(judge!=0){
            return true;
        }else {
            return false;
        }
    }
    //删
    public static boolean deleteFromDB(String id){
        Connection conn=DBConnect.getConn();
        String sql="delete from student where id=?";
        int judge=0;
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,id);
            judge=ps.executeUpdate();
            DBConnect.closeConn(conn,ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(judge!=0){
            return true;
        }else{
            return false;
        }
    }
    //改
    public static boolean change(Student stu){
        Connection conn=DBConnect.getConn();
        String sql="update student set id=? pwd=? academy=? major=? name=? sex=? where id=?";
        int judge=0;
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,stu.getId());
            ps.setString(2,stu.getPwd());
            ps.setString(3,stu.getAcademy());
            ps.setString(4,stu.getMajor());
            ps.setString(5,stu.getName());
            ps.setString(6,stu.getSex());
            ps.setString(7,stu.getId());

            judge=ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(judge!=0){
            return true;
        }else {
            return false;
        }
    }

    //查
    public static Student selectFromDB(String id){
        Connection conn=DBConnect.getConn();
        Student student=new Student();
        String sql="select * from student where id=?";

        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs=ps.executeQuery();

            if(!rs.next()){
                return null;
            }
            student.setId(rs.getString(1));
            student.setPwd(rs.getString(2));
            student.setAcademy(rs.getString(3));
            student.setMajor(rs.getString(4));
            student.setName(rs.getString(5));
            student.setSex(rs.getString(6));

            DBConnect.closeConn(conn,ps,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public static List<Student> selectAll(){
        Connection conn=DBConnect.getConn();
        String sql="select * from student";
        List<Student> list=new ArrayList<>();
        try{
            Statement s = conn.createStatement();
            ResultSet rs=s.executeQuery(sql);
            while(rs.next()){
                Student student=new Student();
                student.setId(rs.getString(1));
                student.setPwd(rs.getString(2));
                student.setAcademy(rs.getString(3));
                student.setMajor(rs.getString(4));
                student.setName(rs.getString(5));
                student.setSex(rs.getString(6));
                list.add(student);
            }
        }catch (Exception e){

        }

        return list;
    }

}
