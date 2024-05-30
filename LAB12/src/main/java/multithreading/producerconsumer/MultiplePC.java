package multithreading.producerconsumer;

/**
 * @author Carolina Cretu
 */

import java.util.LinkedList;

/**
 * Problema descrie 2 procese, producator si consumator, care impart un buffer de marime fixa
 * folosit ca o coada.
 * <p>
 * Datoria producatorului este sa genereze date, sa le puna in buffer si sa inceapa din nou
 * In acelasi timp, consumatorul consuma date (le scoate din buffer), una dupa alta
 * <p>
 * Potentiale probleme:
 * Sa ne asiguram ca producerul nu va incerca sa adauge date in buffer daca e plin
 * Sa ne asiguram ca nici consumatorul nu va incerca sa scoata date dintr-un buffer gol
 */
public class MultiplePC {

    public static void main(String[] args) throws InterruptedException {
        //Obiectul unei clase care are si produce()
        // si consume() ca metode
        final PC pc = new PC();

        // Cream threadul producer
        Thread t1 = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Cream thread ul consumer
        Thread t3 = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t4 = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Pornim ambele threaduri
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // t1 termina inaintea lui t2
        //cu conditia de oprire
        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }

    // Clasa aceasta are o lista, producer (adauga obiecte in lista)
    // si consumer (scoate din lista obiecte)
    public static class PC {

        // Cream o lista impartita de producator/consumator
        // Marimea listei = 4
        LinkedList<Integer> list = new LinkedList<>();
        int capacity = 4;

        // Functie apelata de threadul producer
        public void produce() throws InterruptedException {
            int value = 0;
            while (true) {
                synchronized (this) {
                    // thread ul producer asteapta cat lista este plina
                    while (list.size() == capacity) {
                        wait();
                    }

                    System.out.println("Producer produced-" + Thread.currentThread().getName() + " " + value);

                    // inseram joburile in lista
                    list.add(value++);

                    // notifica consumatorul ca acum poate sa inceapa sa consume din lista
                    notifyAll();

                    // sleep
                    Thread.sleep(1000);
                }
            }
        }

        // Functie apelata de threadul consumer
        public void consume() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    // threadul consumer asteapta cat lista este goala
                    while (list.size() == 0) {
                        wait();
                    }
                    // luam primul job din lista
                    int val = list.removeFirst();


                    System.out.println("Consumer consumed-" + Thread.currentThread().getName() + " " + val);

                    //Trezim threadul producer
                    notifyAll();

                    // si dormim
                    Thread.sleep(1000);
                }
            }
        }
    }
}
