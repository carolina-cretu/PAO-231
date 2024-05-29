package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Carolina Cretu
 */
public class MainStreams4 {

    public static void main(String[] args) {

        //implmentare cu java 7
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        long result = 0;
        for (Integer n : nums) {
            int square = n * n;
            if (square > 20) {
                result = result + 1;
                System.out.println("Square of " + n + " is: " + square);
            }
        }
        System.out.println("Result: " + result);

        List<Integer> numsStream = Arrays.asList(1, 2, 3, 4, 5, 6);
        long resultStream = numsStream.stream()
                .map(n -> n * n) //mapam valorile in stream ca patrate (op intermediara)
                .filter(n -> n > 20) // pastram doar patratele > 20
                .count(); // numaram patratele > 20 (operatie terminala)
        System.out.println("ResultStream is: " + resultStream);

        // sortam datele care curg
        Stream.of("Ioana", "Marius", "Andrada", "George", "Elena")
                .sorted()
                .forEach(System.out::println);
    }
}
