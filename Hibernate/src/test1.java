import org.hibernate.Session;
import test.Factory;
import test.HibernateUtil;
import test.Product;

/**
 * Created by xixi on 01/01/2017.
 */
public class test1 {
    public static void main(String[] args) {
        Session session = null;
//        many to one map uni-directional associations 单向关联
//        try{
//            session= HibernateUtil.getSession();
//            session.beginTransaction();
//            Product product=session.get(Product.class,1);
//            System.out.println("name "+product.getName());
//            System.out.println("price "+product.getPrice());
//            System.out.printf("factory "+product.getFactoryByFactoryId().getFactoryName());
//            session.getTransaction().commit();
//        }catch (Exception e){
//            System.err.println("save failed");
//            session.getTransaction().rollback();
//        }finally {
//            HibernateUtil.closeSession();
//        }

        //many to one Bidirectional associations 双向关联
        //在上面的基础上加个外键关联 productid


    }
}
