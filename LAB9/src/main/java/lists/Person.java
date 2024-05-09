package lists;

import java.util.List;
import java.util.Objects;

/**
 * @author Carolina Cretu
 */
public class Person {
    private String name;
    private List<String> wardrobeItems;

    public Person(String name, List<String> wardrobeItems) {
        this.name = name;
        this.wardrobeItems = wardrobeItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getWardrobeItems() {
        return wardrobeItems;
    }

    public void setWardrobeItems(List<String> wardrobeItems) {
        this.wardrobeItems = wardrobeItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getName().equals(person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", wardrobeItems=" + wardrobeItems +
                '}';
    }
}
