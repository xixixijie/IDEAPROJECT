package dao;

import DBOperation.DBOperation;
import DBconnect.DBconnect;
import Entity.StudentEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;

import java.sql.*;
import java.text.DateFormat;
import java.util.*;
import java.util.Date;

/**
 * Created by jay chen on 2016/9/17.
 */
public class stuAction {
    //学生发布信息
    public static boolean publish(StudentEntity stu){
        Calendar now=Calendar.getInstance();
        String date=""+now.get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH)+1)+"-"+now.get(Calendar.DAY_OF_MONTH);
        stu.setDate(date);
        return DBOperation.add(stu);
    }
    //展示学生简要信息
    public static List<StudentEntity> search(){
        List<StudentEntity> list=new ArrayList<StudentEntity>();
        Connection conn=DBconnect.getConn();
        String sql="select id,name,grade,subject,date from student";

        try {
            Statement sm=conn.createStatement();
            ResultSet rs=sm.executeQuery(sql);


            while(rs.next()){
                StudentEntity stu=new StudentEntity();
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
    public static StudentEntity view(String id){
        Session session=null;
        StudentEntity studentEntity=null;
        try{
            session= HibernateUtil.getSession();
            studentEntity=(StudentEntity)session.load(StudentEntity.class,id);

        }catch (HibernateException he){
            session.getTransaction().rollback();
            System.err.printf("view studentInfo failed");
            he.printStackTrace();
        }finally {
            return  studentEntity;
        }
    }
    //删除过期的学生发布
    private static boolean delete(String id){
        Session session=null;
        boolean flag=false;
        try {
            session=HibernateUtil.getSession();
            StudentEntity studentEntity=(StudentEntity)session.get(StudentEntity.class,id);
            //再删除的同时往学生邮箱发送一封抱歉信
            String email=studentEntity.getEmail();
            //调用 发送功能 并传递email函数

            //删除学生信息
            session.delete(studentEntity);
            session.flush();
            flag=true;
        } catch (HibernateException he) {
            System.err.printf("delete student failed");
            he.printStackTrace();
        }finally {
            HibernateUtil.closeSession();
            return flag;
        }


    }
    //比较日期
    private static boolean dateCompare(String date){
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
