package multithreading;

/**
 * @author Carolina Cretu
 */
public class ThreadExample extends Thread {

    @Override
    public void run() {
        System.out.println("Hello from thread extending impl!");
    }
}
