package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Carolina Cretu
 */
public class MainCollectStreams {

    public static void main(String[] args) {
        Cat c1 = new Cat("Mili", "white", 3);
        Cat c2 = new Cat("Ellie", "orange", 6);
        Cat c3 = new Cat("Tom", "black", 2);
        Cat c4 = new Cat("Bobby", "stripped", 4);

        List<Cat> catList = Arrays.asList(c1, c2, c3, c4);

        List<Cat> oldCatsList = catList.stream()
                .filter(c -> c.getAge() >= 4) // filtram pisicile m>= 4 ani
                .collect(Collectors.toList()); // colectam intr-o noua lista

        oldCatsList.forEach(System.out::println); // printam lista
    }


}
