package queues;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Carolina Cretu
 */
public class PriorityQueueMain {

    public static void main(String[] args) {
        Queue<Cat> p1 = new PriorityQueue<>();

        p1.add(new Cat("Jonny"));
        p1.add(new Cat("Fluffy"));
        p1.add(new Cat("Timmy"));
        //afisam elementul de la cap
        System.out.println(p1.peek());
        //afisam elementul de la cap si il sergem
        System.out.println(p1.poll());

        //afisam elementul de la cap din nou
        System.out.println(p1.peek());

        Cat c = new Cat("Jonny");
        // stergem pisica
        System.out.println(p1.remove(c));
        System.out.println(p1); // afisam ce mai e in colectie

        p1.add(new Cat("Cici"));


        p1.offer(new Cat("Mimi"));
        p1.offer(null); // inseram null, npe..


        Iterator iterator = p1.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }


    }
}
