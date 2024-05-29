package expresiilambda.consumer;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author Carolina Cretu
 */
public class MainConsumer {

    // Exista variatii de consumer, la fel ca si la supplier, IntConsumer, DoubleConsumer, LongConsumer; metoda accept() a acestor variatii poate lua un argument de tip primitiva
    // In plus, mai avem ObjIntConsumer, ObjDoubleConsumer si ObjLongConsumer: etoda accept() a acestor variatii poate lua un argument de tip obiect T si un int, double, long
    //BiConsumer: metoda sa accept() ia 2 argumente de tip obiect, T si U
    public static void main(String[] args) {
        Consumer<String> greenOrBrown = grass -> {
            if (grass.equals("green")) {
                System.out.println("Spring is here!");
            } else if (grass.equals("brown")) {
                System.out.println("Autumn is coming..");
            }
        };

        //Consumer are metoda functionala accept, deci il folosim asa:
        greenOrBrown.accept("green");

        //exemplu cu BiConsumer

        Map<String, String> env = System.getenv();
        BiConsumer<String, String> printEnv = (key, value) -> {
            System.out.println(key + ": " + value);
        };
        printEnv.accept("USERNAME", env.get("USERNAME")); // USERNAME pe windows; USER pe linux
    }
}
