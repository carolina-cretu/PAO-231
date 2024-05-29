package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Carolina Cretu
 */
public class MainSortStreams {

    public static void main(String[] args) {
        Cat c1 = new Cat("Mili", "white", 3);
        Cat c2 = new Cat("Ellie", "orange", 6);
        Cat c3 = new Cat("Tom", "black", 2);
        Cat c4 = new Cat("Bobby", "stripped", 4);

        List<Cat> catList = Arrays.asList(c1, c2, c3, c4);
        catList.stream()
                .sorted() // sortam dupa ordinea naturala
                .forEach(System.out::println);
        System.out.println("<--------------------------------->");
        catList.stream()
                .sorted((cat1, cat2) -> cat1.getAge() - cat2.getAge()) // sortam pisicile dupa varsta folosind un comparator
                .forEach(System.out::println);

        // definim comparatori folosind metodele statice din interfata Comparator
        Comparator<Cat> byColor = Comparator.comparing(Cat::getColor);
        Comparator<Cat> byName = Comparator.comparing(Cat::getName);

        System.out.println("<--------------------------------->");
        // sortam pisicile dupa culoare, in ordine inversa
        catList.stream().sorted(byColor.reversed()).forEach(System.out::println);
    }
}
