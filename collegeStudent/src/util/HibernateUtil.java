package util;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by xixi on 28/12/2016.
 */
public class HibernateUtil {
    private static final ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
    private static SessionFactory sessionFactory=null;

    static {
        rebuildSessionFactory();
    }

    public static Session getSession() throws HibernateException {
        Session session=(Session)threadLocal.get();
        if(session==null||!session.isOpen()){
            if(sessionFactory==null){
                rebuildSessionFactory();
            }
            session=(sessionFactory!=null)?sessionFactory.openSession():null;
            threadLocal.set(session);
        }
        return session;
    }

    public static void rebuildSessionFactory(){
        try{
            Configuration cfg=new Configuration().configure();
            sessionFactory=cfg.buildSessionFactory();
        }catch(Exception e){
            System.err.printf("creat factory failed");
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void closeSession() throws HibernateException{
        Session session=(Session)threadLocal.get();
        threadLocal.set(null);
        if (session != null) {
            session.close();
        }

    }
}
