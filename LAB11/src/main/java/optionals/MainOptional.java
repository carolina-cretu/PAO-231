package optionals;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

/**
 * @author Carolina Cretu
 */
public class MainOptional {

    public static void main(String[] args) {
        Readings r1 = new Readings(1, 2019, 99);
        Readings r2 = new Readings(2, 2019, 99.5);
        Readings r3 = new Readings(3, 2019, 99.6);
        Readings r4 = new Readings(4, 2019, 98.67);
        Readings r5 = new Readings(5, 2019, 101.45);
        Readings r6 = new Readings(6, 2019, 100.01);

        List<Readings> readingsList = new ArrayList<>();

        readingsList.add(r1);
        readingsList.add(r2);
        readingsList.add(r3);
        readingsList.add(r4);
        readingsList.add(r5);
        readingsList.add(r6);
        OptionalDouble average =
                readingsList.stream()
                        .mapToDouble(reading -> reading.getValue())
                        .filter(value -> value >= 99 && value <= 100)
                        .average();

        System.out.println("Average of 99 readings: " + average);
       // System.out.println("Average of 99 readings: " + average.getAsDouble()); // exceptie daca acest optional este gol; de aceea trebuie apelat intai isPresent()

        // modul corect de a obtine valoarea double
        if (average.isPresent()) {
            System.out.println("Average of 99 readings: " + average.getAsDouble());
        } else {
            System.out.println("Optional is empty.");
        }
    }
}
