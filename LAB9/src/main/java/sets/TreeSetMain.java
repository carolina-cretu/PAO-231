package sets;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author Carolina Cretu
 */
public class TreeSetMain {

    public static void main(String[] args) {
        TreeSet<Cat> cats = new TreeSet<>();
        Set<Animal> animals = new TreeSet<>();

        Cat c1 = new Cat("Bibi");
        Cat c2 = new Cat("Tom");
        Cat c3 = new Cat("Max");
        Horse h1 = new Horse("Billy");
        cats.add(c1);
        cats.add(c2);
        cats.add(c3);

        animals.add(c1);
        animals.add(c2);
        animals.add(c3);
       // animals.add(h1); ce se intampla daca decomentam ?

        for (Cat c: cats){
            System.out.println("Cat in the list is: " + c);
        }

        System.out.println("Cheia mai mica de c3 este: " + cats.lower(c3));
    }
}
