package pdp.annotations.objects;

import pdp.annotations.custom.InjectRandomInt;

public class AnnotatedPerson {

    @InjectRandomInt(min = 18, max = 30)
    private Integer age;

    @InjectRandomInt(min = 155, max = 190)
    private Integer height;

    private String name;

    public AnnotatedPerson() {
        this("unnamed");
    }

    public AnnotatedPerson(String name) {
        this(name, 0, 0);
    }

    public AnnotatedPerson(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Integer getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return String.format("%s: %sy.o. %ssm", name, age);
    }
}
