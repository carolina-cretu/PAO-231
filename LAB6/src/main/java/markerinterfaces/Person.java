package markerinterfaces;

import java.util.Objects;

/**
 * @author Carolina Cretu
 */

// exemplu de implementare interfata marker
public class Person implements Cloneable {
    private String name;
    private Integer age;
    private Job job;

    public Person(String name, Integer age, Job job) {
        this.name = name;
        this.age = age;
        this.job = job;
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

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

// prin conventie, o clasa care impl Cloneable, redefinest emetoda Object.clone()
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getName().equals(person.getName()) && getAge().equals(person.getAge()) && Objects.equals(getJob(), person.getJob());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getJob());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job=" + job +
                '}';
    }
}
