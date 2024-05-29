package serializationcaveats;

import java.io.Serializable;

/**
 * @author Carolina Cretu
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    static String country = "FRANCE";
    private int age;
    private String name;
    transient int height;

    private Address address; // must be serializable too

    // getters si setters


    public static String getCountry() {
        return country;
    }

    public static void setCountry(String country) {
        Person.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", address=" + address +
                '}';
    }
}
