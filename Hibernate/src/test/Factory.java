package test;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by xixi on 01/01/2017.
 */
@Entity
public class Factory {
    private int factoryId;
    private String factoryName;

    @Id
    @Column(name = "factoryId")
    public int getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(int factoryId) {
        this.factoryId = factoryId;
    }

    @Basic
    @Column(name = "factoryName")
    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Factory factory = (Factory) o;

        if (factoryId != factory.factoryId) return false;
        if (factoryName != null ? !factoryName.equals(factory.factoryName) : factory.factoryName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = factoryId;
        result = 31 * result + (factoryName != null ? factoryName.hashCode() : 0);
        return result;
    }
}
