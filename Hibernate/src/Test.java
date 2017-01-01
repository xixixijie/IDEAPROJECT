import org.hibernate.Session;
import test.HibernateUtil;
import test.ProductEntity;

import java.util.Date;

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
        //  数据  存
//        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
//        Session session=sessionFactory.openSession();
//        session.beginTransaction();
//        session.save(userEntity);
//        session.getTransaction().commit();
//
//
//        System.out.printf("1");
//
//
//        Session session=null;
//        ProductEntity p=new ProductEntity();
//        p.setId(2);
//        Object o=p;
//
//        try{
//            session= HibernateUtil.getSession();
//            session.beginTransaction();
//            session.save(o);
//            session.getTransaction().commit();
//        }catch (Exception e){
//            session.getTransaction().rollback();
//            System.out.printf("添加数据失败");
//            e.printStackTrace();
//        }finally {
//            HibernateUtil.closeSession();
//        }

        //数据查 get(）立刻访问数据库
        // load() 在返回对象被调用时才发出SQL语句查询数据库
//        Session session=null;
//        try{
//            session=HibernateUtil.getSession();
//            ProductEntity productEntity=(ProductEntity)session.get(ProductEntity.class,1);
//
  //      productEntity p=(ProductEntity)session.load(ProductEntity.class,new Integer("1"));
// System.out.printf(""+productEntity.getId());
//
//        }catch (Exception e){
//            System.out.printf("找不到");
//            e.printStackTrace();


//        }

        //数据删
        Session session=null;
        Date date=new Date("yy-mm-dddd");
        System.out.printf(date+"");

    }
}
