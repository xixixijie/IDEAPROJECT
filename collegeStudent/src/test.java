import Entity.NewsEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 * Created by xixi on 28/12/2016.
 */
public class test {
    public static void main(String[] args) {
        Session session=null;
        NewsEntity newsEntity=new NewsEntity();

        newsEntity.setId(103);
        newsEntity.setSrc("hahaha");
        newsEntity.setTitle("ganbadie");
        Object o=(Object)newsEntity;
        try{
            session= HibernateUtil.getSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
        }catch (HibernateException he){
            session.getTransaction().rollback();
            System.err.printf("add date failed");
            he.printStackTrace();
        }finally {
            HibernateUtil.closeSession();
        }

    }
}
