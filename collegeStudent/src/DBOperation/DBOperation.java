package DBOperation;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 * Created by xixi on 28/12/2016.
 */
public class DBOperation {
    public static boolean add(Object o){
        Session session=null;
        boolean flag=false;
        try{
            session= HibernateUtil.getSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            flag=true;
        }catch (Exception e){
            session.getTransaction().rollback();
            System.err.printf("add failed");
            e.printStackTrace();
        }finally {
            HibernateUtil.closeSession();
            return flag;
        }
    }


    public static boolean delete(Object object){
        boolean flag=false;
        Session session=null;
        try{
            session=HibernateUtil.getSession();
            session.delete(object);
            session.flush();
            flag=true;
        }catch (HibernateException he){
            session.getTransaction().rollback();
            System.err.printf("delete failed");
            he.printStackTrace();
        }finally {
            HibernateUtil.closeSession();
            return flag;
        }
    }
}
