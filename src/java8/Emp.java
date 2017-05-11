package java8;

/**
 * Created by fan on 2017/4/30.
 */
public class Emp {

    private String name;
    private Integer age;
    private Double sal;

    public Emp(String name, Integer age, Double sal) {
        this.name = name;
        this.age = age;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "java8.Emp{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sal=" + sal +
                '}';
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

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }
}
