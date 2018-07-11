package bean;

/**
 * Created by xixi on 2018/7/5.
 */
public class ExampleBean {
    private FirstBean firstBean;
    private SecondBean secondBean;
    public ExampleBean(FirstBean firstBean,SecondBean secondBean) {
        this.firstBean=firstBean;
        this.secondBean=secondBean;
    }

    public void print(){
        firstBean.sayHello();
        secondBean.sayHello();
    }
}
