package multithreading.synchronize;

/**
 * @author Carolina Cretu
 */
public class SynchronizedCounter implements Runnable {

    private Integer count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            increment();
        }
    }

    public synchronized void increment() {
        count++;
        System.out.println(count);
    }
}
