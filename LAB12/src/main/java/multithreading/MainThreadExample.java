package multithreading;

/**
 * @author Carolina Cretu
 */
public class MainThreadExample {

    // punctul de pornire al firului de executie main
    public static void main(String[] args) {
        System.out.println("Begin main");
        ThreadExample helloThread = new ThreadExample();
        helloThread.start(); //vrei ca threadul tau sa porneasca executia aici
        System.out.println("End main");
    }
}
