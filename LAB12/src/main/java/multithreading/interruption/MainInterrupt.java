package multithreading.interruption;

import java.util.Arrays;
import java.util.List;

/**
 * @author Carolina Cretu
 */
public class MainInterrupt {

    public static void main(String[] args) {
        List<String> info = Arrays.asList("Hello", "there", "Hi", "again!");
        for (String s : info) {
            // Printam un mesaj
            System.out.println(s);
            if (Thread.interrupted()) {
                // Am fost intrerupti: nu mai printam
                return;
            }
        }
    }
}
