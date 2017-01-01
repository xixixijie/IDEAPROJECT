package dao;

import DBOperation.DBOperation;
import DBconnect.DBconnect;
import Entity.UserEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jay chen on 2016/9/14.
 */
public class userAction {
    //登陆
    public static boolean login(UserEntity u){
        Session session=null;
        boolean flag=false;
        try{
            session= HibernateUtil.getSession();
            UserEntity userEntity=(UserEntity)session.get(UserEntity.class,u.getId());
            if(userEntity!=null){
                flag=true;
                u.setId(userEntity.getId());
                u.setName(userEntity.getName());
                u.setPwd(userEntity.getPwd());
                u.setUniversity(userEntity.getUniversity());
                u.setCollege(userEntity.getCollege());
                u.setMajor(userEntity.getMajor());
                u.setGrade(userEntity.getGrade());
                u.setGender(userEntity.getGender());
                u.setEmail(userEntity.getEmail());
                u.setAge(userEntity.getAge());
            }
        }catch (HibernateException he){
            session.getTransaction().rollback();
            System.err.printf("login failed");
            he.printStackTrace();
        }finally {
            HibernateUtil.closeSession();
            return flag;
        }
    }
    //注册
    public static boolean register(UserEntity u){
        return DBOperation.add(u);
    }
}
