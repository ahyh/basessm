package java8.test;

/**
 * Created by yanhuan1 on 2018/1/25.
 */
public class Person {

    private Long id;

    private Integer age;

    private String name;

    private Double salary;

    private Boolean sex;

    private Byte status;

    public Person(Long id,Integer age, String name, Double salary, Boolean sex, Byte status) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.sex = sex;
        this.status = status;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", sex=" + sex +
                ", status=" + status +
                '}';
    }
}
