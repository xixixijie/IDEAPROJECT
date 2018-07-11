package bean;

/**
 * Created by xixi on 2018/7/5.
 */
public class newExampleBean {
    public FirstBean getFirstBean() {
        return firstBean;
    }

    public void setFirstBean(FirstBean firstBean) {
        this.firstBean = firstBean;
    }

    private FirstBean firstBean;

    private SecondBean secondBean;

    public void setSecondBean(SecondBean secondBean) {
        this.secondBean = secondBean;
    }

    public void print(){
        firstBean.sayHello();;
        secondBean.sayHello();
    }
}
