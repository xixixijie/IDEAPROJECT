package dao;

import DBconnect.DBconnect;
import bean.Student;

import java.sql.*;
import java.text.DateFormat;
import java.util.*;
import java.util.Date;

/**
 * Created by jay chen on 2016/9/17.
 */
public class stuAction {
    //学生发布信息
    public static boolean publish(Student stu){
        Connection conn=DBconnect.getConn();
        String sql="insert into student(name,age,gender,grade,subject,address,time,date,email) values(?,?,?,?,?,?,?,?,?)";
        int flag=0;
        Calendar now=Calendar.getInstance();
        String date=""+now.get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH)+1)+"-"+now.get(Calendar.DAY_OF_MONTH);

        try {
            PreparedStatement ps=conn.prepareStatement(sql);


            ps.setString(1,stu.getName());
            ps.setString(2,stu.getAge());
            ps.setString(3,stu.getGender());
            ps.setString(4,stu.getGrade());
            ps.setString(5,stu.getSubject());
            ps.setString(6,stu.getAddress());
            ps.setString(7,stu.getTime());
            ps.setString(8,date);
            ps.setString(9,stu.getEmail());

            flag=ps.executeUpdate();
            DBconnect.closeConn(conn,ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(flag>0){
            return true;
        }else{
            return false;
        }
    }
    //展示学生简要信息
    public static List<Student> search(){
        List<Student> list=new ArrayList<Student>();
        Connection conn=DBconnect.getConn();
        String sql="select id,name,grade,subject,date from student";

        try {
            Statement sm=conn.createStatement();
            ResultSet rs=sm.executeQuery(sql);


            while(rs.next()){
                Student stu=new Student();
                String date=rs.getString(5);

                //设置时间，如果超过一个月，就从数据库中删除该发布信息
                if(dateCompare(date)){
                    delete(rs.getInt(1)+"");
                }else {
                    stu.setId(rs.getInt(1));
                    stu.setName(rs.getString(2));
                    stu.setGrade(rs.getString(3));
                    stu.setSubject(rs.getString(4));
                    stu.setDate(rs.getString(5));
                    list.add(stu);
                }
            }

            DBconnect.closeConn(conn,sm,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;

    }
    //查看学生详细信息
    public static Student view(String id){
        Connection conn=DBconnect.getConn();
        Student stu=new Student();
        String sql="select * from student where id=?";

        try {

            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs=ps.executeQuery();
            rs.next();
            stu.setId(rs.getInt(1));
            stu.setName(rs.getString(2));
            stu.setAge(rs.getString(3));
            stu.setGender(rs.getString(4));
            stu.setGrade(rs.getString(5));
            stu.setSubject(rs.getString(6));
            stu.setAddress(rs.getString(7));
            stu.setTime(rs.getString(8));
            stu.setDate(rs.getString(9));

            DBconnect.closeConn(conn,ps,rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return stu;
    }
    //删除过期的学生发布
    Calendar now=Calendar.getInstance();
    private static boolean delete(String id){
        Connection conn=DBconnect.getConn();
        String sql1="select email from student where id=?";
        String sql2="delete from student where id=?";
        int flag=0;
        try {
            //再删除的同时往学生邮箱发送一封抱歉信
            PreparedStatement ps=conn.prepareStatement(sql1);
            ps.setString(1,id);
            ResultSet rs=ps.executeQuery();
            String email=rs.getString("email");
            //调用 发送功能 并传递email函数



            //删除学生信息
            ps=conn.prepareStatement(sql2);
            ps.setString(1,id);

            flag=ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(flag!=0){
            return true;
        }else{
            return false;
        }

    }

    //比较日期
    private static boolean dateCompare(String date){
        /*
        if (date == null) {
            return true;
        }
        */
        Calendar now=Calendar.getInstance();
        int year=Integer.parseInt(date.split("-")[0]);
        int month=Integer.parseInt(date.split("-")[1]);

        if(now.get(Calendar.YEAR)>year){
            return true;
        }else if(now.get(Calendar.MONTH)>month){
            return true;
        }else{
            return false;
        }
    }
}
