package sets;

import java.util.Objects;

/**
 * @author Carolina Cretu
 */
public class Horse implements Animal {
    private String name;
    private int age;

    public Horse(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println("Horse eats hay !");
    }

    @Override
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Horse)) return false;
        Horse horse = (Horse) o;
        return getAge() == horse.getAge() && getName().equals(horse.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
