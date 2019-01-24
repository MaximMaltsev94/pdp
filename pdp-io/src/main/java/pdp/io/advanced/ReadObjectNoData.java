package pdp.io.advanced;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class ReadObjectNoData implements Serializable {
    private String name;
    private Integer age;

    public ReadObjectNoData() {
    }

    public ReadObjectNoData(String name) {
        this.name = name;
    }

    private void readObjectNoData() throws ObjectStreamException {
        System.out.println("readObjectNoData()");
        this.age = 24;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ReadObjectNoData{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
