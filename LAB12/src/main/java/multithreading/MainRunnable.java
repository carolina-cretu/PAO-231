package multithreading;

/**
 * @author Carolina Cretu
 */
public class MainRunnable {

    // punctul de pornire al firului de executie main
    public static void main(String[] args) {
        Thread helloThread = new Thread(new RunnableExample());
        helloThread.start();
        System.out.println("End main!");
    }
}
