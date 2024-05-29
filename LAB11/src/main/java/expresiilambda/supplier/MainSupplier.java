package expresiilambda.supplier;
import java.util.Map;
import java.util.Random;
import java.util.function.IntSupplier;
import java.util.function.Supplier;


/**
 * @author Carolina Cretu
 */

// supplier: nu ia niciun argument si intoarce un obiect
    // variatii de supplier: IntSupplier, DoubleSupplier, LongSupplier
public class MainSupplier {

    public static void main(String[] args) {
        // supplier cu clasa interioara
        Supplier<Integer> supplierInnerClass = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 42;
            }
        };

        //supplier cu lambda

        Supplier<Integer> supplier = () -> 42;

        // metoda get() din Supplier<T> intoarce valoarea lui T (un rezultat)
        System.out.println("Raspunsul este: " + supplier.get());

        // supplier cu cu mai multe instructiuni, folosim o versiune mai lunga de lambda in care avem si return
        Supplier<String> userSupplier = () -> {
            Map<String, String> env = System.getenv();  // luam un map cu system env
            return env.get("USERNAME"); // luam valoarea cu cheia si o intoarcem (pe windows este USERNAME, alfel este USER)
        };

        System.out.println("Userul este: " + userSupplier.get());


        Random random = new Random();
        IntSupplier randomIntSupplier = () -> random.nextInt(10);
        System.out.println("Numarul aleatoriu este: " + randomIntSupplier.getAsInt());
    }


}
