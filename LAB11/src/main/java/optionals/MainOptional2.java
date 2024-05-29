package optionals;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Carolina Cretu
 */
public class MainOptional2 {

    public static void main(String[] args) {
        Stream<Double> doubleStream = Stream.of(1.0, 2.0, 3.0, 4.0, 5.0); // stream de doubles
        Optional<Double> num = doubleStream.findFirst(); // gasim primul double
        if (num.isPresent()) { // verificam sa vedem daca are valoare
            System.out.println("Primul numar din streamul de double este: " + num.get());
        } else {
            System.out.println("Streamul de double este gol !");
        }

        // sau putem folosi o expresie lambda
        num.ifPresent( n -> System.out.println("Primul numar din streamul de double este: " + n));
    }
}
