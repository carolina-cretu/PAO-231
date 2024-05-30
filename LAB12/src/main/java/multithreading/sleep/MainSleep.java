package multithreading.sleep;

import java.util.Arrays;
import java.util.List;

/**
 * @author Carolina Cretu
 */
public class MainSleep {

    public static void main(String[] args) throws InterruptedException {
        List<String> info = Arrays.asList("Hello", "there", "Hi", "again!");
        for (String s : info) {
            //Pauza 2 secunde
            Thread.sleep(2000);

            //Afisam un mesaj
            System.out.println(s);
        }
    }
}
