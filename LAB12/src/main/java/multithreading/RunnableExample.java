package multithreading;

/**
 * @author Carolina Cretu
 */
public class RunnableExample implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello from runnable impl thread!");
    }
}
