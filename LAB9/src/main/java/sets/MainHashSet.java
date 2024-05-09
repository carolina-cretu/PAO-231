package sets;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Carolina Cretu
 */
public class MainHashSet {

    public static void main(String[] args) {
        Set<Cat> cats = new HashSet<>();
        Cat c1 = new Cat("Pufi");
        Cat c2 = new Cat("Pufi");
        Cat c3 = new Cat("Mili");
        Cat c4 = new Cat("Bella");

        cats.add(c1);
        cats.add(c2); //intoarce false
        cats.add(c3);
        cats.add(c4);

        System.out.println("Cate pisici avem ? " + cats.size());

        for (Cat c : cats) {
            System.out.println(c); // ordinea nu este garantata !
        }

    }
}
