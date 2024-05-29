package expresiilambda.foreach;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author Carolina Cretu
 */

// forEach() a fost adaugata in Java8 in interfata Iterable; forEach() asteapta un consumer
public class MainForEach {

    public static void main(String[] args) {
        List<String> dogs = Arrays.asList("Max", "Codi", "Mini");
        Consumer<String> printDogs = name -> System.out.println(name);
        dogs.forEach(printDogs); // pasam consumerul printDogs metodei forEach()
        System.out.println("<----------------------->");
        // prescurtat
        dogs.forEach(name -> System.out.println(name));

        //exemplu cu BiConsumer

        Map<String, String> env = System.getenv();
        BiConsumer<String, String> printEnv = (key, value) -> {
            System.out.println(key + ": " + value);
        };

        env.forEach(printEnv); // pentru Map folosim BiConsumer
    }
}
