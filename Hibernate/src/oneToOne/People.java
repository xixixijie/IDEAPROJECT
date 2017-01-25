package oneToOne;

import javax.persistence.*;

/**
 * Created by xixi on 01/01/2017.
 */
@Entity
public class People {
    private int id;
    private String name;
    private String sex;
    private String age;
    private IdCard idCard;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "age")
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        People people = (People) o;

        if (id != people.id) return false;
        if (name != null ? !name.equals(people.name) : people.name != null) return false;
        if (sex != null ? !sex.equals(people.sex) : people.sex != null) return false;
        if (age != null ? !age.equals(people.age) : people.age != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    public void setIdCard(IdCard idCardById) {
        this.idCard = idCardById;
    }

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    public IdCard getIdCard() {
        return idCard;
    }

}
