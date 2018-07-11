package mode.Bean;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Size;

/**
 * Created by xixi on 2018/7/6.
 */
public class User {

    private int id;

    //校验规则
    @Size(min=5,max=12,message = "{user.username.length.error}")
    private String username;
    private int age;

    @Email(message = "{user.email.error}")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
