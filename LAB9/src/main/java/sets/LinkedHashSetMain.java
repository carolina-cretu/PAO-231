package sets;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Carolina Cretu
 */
public class LinkedHashSetMain {

    public static void main(String[] args) {
        Set<Animal> animals = new LinkedHashSet<>();

        Cat c1 = new Cat("Pufi");
        Cat c2 = new Cat("Bella");
        Dog d1 = new Dog("Max", "orange");
        Horse h1 = new Horse("Bill");

        animals.add(c1);
        animals.add(c2);
        animals.add(d1);
        animals.add(h1);

        for (Animal a: animals){
            System.out.println(a);
        }
    animals.remove(c2);
        for (Animal a: animals){
            System.out.println(a);
        }

    }
}
