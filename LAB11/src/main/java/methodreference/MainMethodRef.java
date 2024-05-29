package methodreference;

import java.util.Arrays;
import java.util.List;

/**
 * @author Carolina Cretu
 */
public class MainMethodRef {

    public static void main(String[] args) {
        // folosim expresii lambda pentru a lua numele copacului, s, si pentru a il pasa lui System.out.println()
        List<String> trees = Arrays.asList("alun", "brad", "molid");
        trees.forEach(s -> System.out.println(s));

        // si mai prescurtat folosind method reference
        trees.forEach(System.out::println);

        trees.forEach(MainMethodRef::printTreeStatic); // afisam cu propria noastra metoda referita
    }

    public static void printTreeStatic (String t) {
        System.out.println("Numele copacului: " + t);
    }
}
