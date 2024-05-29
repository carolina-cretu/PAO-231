package streams;

import java.util.Arrays;
import java.util.List;

/**
 * @author Carolina Cretu
 */
public class MainStreams2 {

    public static void main(String[] args) {
        List<Double> tempsInBuc = Arrays.asList(123.6, 118.0, 113.0, 112.5, 115.8, 117.0, 110.2, 110.1, 106.0, 106.4);
        System.out.println("Numarul de zile cu o temperatura mai mare de 110 intr-o perioada de 10 zile: " +
                tempsInBuc
                        .stream()
                        .filter(t -> t > 110.0)
                        .count());

        List<String> names = Arrays.asList("Codi", "Cleo", "Aiko", "Max", "Mini");
        names.stream() // cream streamul din colectia de nume ca sursa
                .filter(name -> name.startsWith("M") // filtram dupa prima litera
                        || name.startsWith("C"))
                .filter(name -> name.length() > 3) // filtram dupa lungime
                .forEach(System.out::println); // afidam
    }
}
