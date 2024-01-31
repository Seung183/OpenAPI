import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String identification;
    private String name;
    private int age;

    public Person() {
    }

    public Person(String identification, String name, int age) {
        this.identification = identification;
        this.name = name;
        this.age = age;
    }


    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
