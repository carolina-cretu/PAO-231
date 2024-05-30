package multithreading.joining;

/**
 * @author Carolina Cretu
 */
public class ThreadJoining extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
                Thread.sleep(500);
                System.out.println("Current Thread: " + Thread.currentThread().getName());
            } catch (Exception ex) {
                System.out.println("Exception has been caught" + ex);
            }
            System.out.println(i);
        }
    }
}

class Main {

    public static void main(String[] args) {

        // cream 2 threaduri
        ThreadJoining t1 = new ThreadJoining();
        ThreadJoining t2 = new ThreadJoining();
        ThreadJoining t3 = new ThreadJoining();

        // thread t1 porneste
        t1.start();

        //porneste al doilea thread dupa ce thread1 nu mai este alive
        try {
            System.out.println("Current Thread: " + Thread.currentThread().getName());
            t1.join();
        } catch (Exception ex) {
            System.out.println("Exception has been caught" + ex);
        }

        // t2 porneste
        t2.start();

        // porneste t3 dupa ce thread t2 a nu mai este alive
        try {
            System.out.println("Current Thread: " + Thread.currentThread().getName());
            t2.join();
        } catch (Exception ex) {
            System.out.println("Exception has been caught" + ex);
        }

        t3.start();
    }
}
