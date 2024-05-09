package maps;

import java.util.Objects;

/**
 * @author Carolina Cretu
 */
public class Cat implements Animal, Comparable<Cat> {
    private String name;


    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println("Cats eat mice !");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;
        Cat cat = (Cat) o;
        return getName().equals(cat.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Cat o) {
        return this.name.compareTo(o.getName());
    }
}
