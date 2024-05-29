package streams;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Carolina Cretu
 */
public class MainStreams {

    public static void main(String[] args) {
        Integer[] myNums = {1, 2, 3};
        Stream<Integer> myStream = Arrays.stream(myNums); // sau
        Stream <Integer> myStreamAlternative = Stream.of(myNums); // putem sa omitem declaratie de myNums si sa adaugam direct valorile in metoda statica of()
        System.out.println(myStream); // doar o descriere criptica a obiectului care descrie cum sa ajungem la date
        long numElements = myStream.count(); // luam nr de elemente din stream; stream ul este terminat deoarece a fost transformat intr-un numar de catre operatia count() -> operatie terminala
        System.out.println(" Numarul de elemente din stream este: " + numElements);

        Integer[] myNums2 = {1, 2, 3};
        Stream<Integer> myStream2 = Arrays.stream(myNums);
        long numElements2 =
                myStream2
                        .filter((i) -> i > 1) // adaugam o operatie intermediara care filtreaza stream ul
                        .count(); // operatie terminala, numara elementele intr-un stream

        System.out.println("Numarul de elemente > 1: " + numElements2);

    }
}
