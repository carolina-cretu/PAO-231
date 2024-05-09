package sets;

import java.util.Objects;

/**
 * @author Carolina Cretu
 */
public class Dog implements Animal {

    private String name;
    private String furColour;

    public Dog(String name, String furColour) {
        this.name = name;
        this.furColour = furColour;
    }

    @Override
    public void eat() {
        System.out.println("Dog eats meat !");
    }

    @Override
    public String getName() {
        return name;
    }

    public String getFurColour() {
        return furColour;
    }

    public void setFurColour(String furColour) {
        this.furColour = furColour;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog)) return false;
        Dog dog = (Dog) o;
        return getName().equals(dog.getName()) && Objects.equals(getFurColour(), dog.getFurColour());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFurColour());
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", furColour='" + furColour + '\'' +
                '}';
    }
}
