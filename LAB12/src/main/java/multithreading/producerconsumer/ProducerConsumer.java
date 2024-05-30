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
public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {
        ///Obiectul unei clase care are si produce()
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

        // Cream thread ul consumer
        Thread t2 = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // pornim ambele threaduri
        t1.start();
        t2.start();

        // t1 termina inaintea lui t2
        //cu conditia de oprire
        t1.join();
        t2.join();
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
                    while (value == 3) { //conditia de oprire - o scoatem pentru producere infinita
                        break;
                    }
                    // producer thread waits while list
                    // is full
                    if (list.size() == capacity) {
                        wait();
                    }

                    System.out.println("Producer produced-" + value);

                    // inseram joburile in lista
                    list.add(value++);

                    // notifica consumatorul ca acum poate sa inceapa sa consume din lista
                    notifyAll();

                    // doarme threadul
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


                    System.out.println("Consumer consumed-" + val);

                    //Trezim threadul producer
                    notifyAll();

                    // si dormim
                    Thread.sleep(1000);

                    if (val == 2) { //conditie de oprire - o scoatem pentru consum infinit
                        break;
                    }
                }
            }
        }
    }
}
