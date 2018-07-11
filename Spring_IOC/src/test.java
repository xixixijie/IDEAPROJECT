import bean.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by xixi on 2018/7/5.
 */
public class test {
    public static void main(String[] args) {
        //加载配置文件
//        Resource resource=new ClassPathResource("applicationContext.xml");
//        BeanFactory factory=new XmlBeanFactory(resource);
//
        /*
           applicationContext 和 beanFactory的区别：
           applicationConText 是 beanFactory的子接口，比较高级，
           默认非延迟初始化的容器，尽可能早的发现错误
         */
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student= (Student) app.getBean("student");
        student.show();
//
//        FirstBean firstBean= (FirstBean) factory.getBean("first");
//        firstBean.sayHello();
//        FirstBean firstBean1= (FirstBean) factory.getBean("first");
//
//        System.out.println(firstBean==firstBean1);
//        SecondBean sb= (SecondBean) factory.getBean("second");

//        ExampleBean exampleBean= (ExampleBean) factory.getBean("example");
//        exampleBean.print();

//        newExampleBean example= (newExampleBean) factory.getBean("newExample");
//        example.print();
//        Student student= (Student) factory.getBean("student");
//        student.show();

    }

}
