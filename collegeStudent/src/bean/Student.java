package bean;

/**
 * Created by jay chen on 2016/9/17.
 */
public class Student {
 /*  <!-- 姓名:<input type="text" name="name"><br>
    年龄:<input type="text" name="old"><br>
    性别: <input  type="text" name="sex"><br>
    年级: <input type="text" name="grade"><br>
    科目:<input  type="text" name="subject"><br>
    地址: <input type="text" name="address"><br>
    上课时间:<input type="text" name="time"><br>-->*/
    private long id;
    private String name;
    private String age;
    private String gender;
    private String grade;
    private String subject;
    private String address;
    private String time;
    private String date;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
