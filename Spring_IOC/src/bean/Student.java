package bean;

/**
 * Created by xixi on 2018/7/5.
 */
public class Student {
    private int sid;
    private String sname;
    private int age;
    private Classes cla;

    public void setCla(Classes cla) {
        this.cla = cla;
    }

    public void show(){
        System.out.println(sid+" "+sname+" "+age);
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
