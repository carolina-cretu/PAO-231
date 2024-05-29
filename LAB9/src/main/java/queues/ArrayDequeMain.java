package queues;

import java.util.ArrayDeque;

/**
 * @author Carolina Cretu
 */
public class ArrayDequeMain {

    public static void main(String[] args) {
        ArrayDeque<Dog> ad1 = new ArrayDeque<>();

        ad1.addLast(new Dog("Charlie", "brown"));
        ad1.offer(new Dog("Lily", "black"));
        ad1.addFirst(new Dog("Ali", "orange"));
        ad1.push(new Dog("Nina", "white with black stripes")); // adauga in fata

        System.out.println(ad1);

        // afiseaza elementul de la cap
        System.out.println(ad1.element());
        // intoarce ultimul element
        System.out.println(ad1.getLast());


        //iteram
        for (Dog d: ad1) {
            System.out.println("Catel: " + d);
        }

        System.out.println(ad1.pop()); // stergem primul element
        System.out.println(ad1);

        ad1.clear();

        System.out.println("Ad1 dupa clear este: " + ad1);
    }
}
