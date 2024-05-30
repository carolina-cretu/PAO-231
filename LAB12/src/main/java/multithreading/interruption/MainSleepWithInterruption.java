package multithreading.interruption;

import java.util.Arrays;
import java.util.List;

/**
 * @author Carolina Cretu
 */
public class MainSleepWithInterruption {

    public static void main(String[] args) throws InterruptedException {
        List<String> info = Arrays.asList("Hello", "there", "Hi", "again!");
        for (String s : info) {
            // Pauza 2 secunde
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // Am fost intrerupti; nu mai printam mesaje
                return;
            }
            // Printam un mesaj
            System.out.println(s);
        }
    }
}
