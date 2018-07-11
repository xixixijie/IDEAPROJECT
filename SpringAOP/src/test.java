import bean.Speaker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xixi on 2018/7/5.
 */
public class test {
    public static void main(String[] args) {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        Speaker speaker= (Speaker) app.getBean("otherSpeaker");
        speaker.speak();

    }
}
