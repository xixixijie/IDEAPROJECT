import org.hibernate.Session;
import test.HibernateUtil;
import test.ProductEntity;

/**
 * Created by xixi on 14/12/2016.
 */
public class Test {
    public static void main(String[] args) {
//        UserEntity userEntity=new UserEntity();
//        userEntity.setId(2);
//        userEntity.setName("123");
//        userEntity.setPassword("111");
//
//        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
//        Session session=sessionFactory.openSession();
//        session.beginTransaction();
//        session.save(userEntity);
//        session.getTransaction().commit();
//
//
//        System.out.printf("1");

//        Session session=null;
//        ProductEntity p=new ProductEntity();
//        p.setId(1);
//
//
//        try{
//            session= HibernateUtil.getSession();
//            session.beginTransaction();
//            session.save(p);
//            session.getTransaction().commit();
//        }catch (Exception e){
//            session.getTransaction().rollback();
//            System.out.printf("添加数据失败");
//            e.printStackTrace();
//        }finally {
//            HibernateUtil.closeSession();
//        }
        Session session=null;
        try{
            session=HibernateUtil.getSession();
            ProductEntity productEntity=(ProductEntity)session.get(ProductEntity.class,1);
            System.out.printf(""+productEntity.getId());

        }catch (Exception e){
            System.out.printf("找不到");
            e.printStackTrace();
        }
    }
}
