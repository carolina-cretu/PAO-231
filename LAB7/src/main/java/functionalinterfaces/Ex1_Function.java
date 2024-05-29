package functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.DoubleFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.ToDoubleBiFunction;
import java.util.stream.Collectors;

/**
 * @author Carolina Cretu
 */
public class Ex1_Function {

    public static void main(String[] args) {
        String stringsBiFunction = concatStringsBiFunction("Hello ", "World");
        System.out.println(stringsBiFunction);

        int multiplyTwoIntsBiFunction = multiplyTwoIntsBiFunction(12, 34);
        System.out.println(multiplyTwoIntsBiFunction);

        int toIntFunction = convertDoubleToIntDoubleToIntFunction(234.5);
        System.out.println(toIntFunction);

        String stringDoubleFunction = convertDoubleToStringDoubleFunction(234.5);
        System.out.println(stringDoubleFunction);

    }


    public static void convertStringToIntegerFunction() {
        Function<String, Integer> convertToWordCount = a -> a.length();
        List<String> words = Arrays.asList("The", "That", "John", "Thanks");

        List<Integer> wordsCounts = words.stream().map(convertToWordCount).collect(Collectors.toList());

        for (int n : wordsCounts) {
            System.out.println(n);
        }
    }

    public static String concatStringsBiFunction(String s1, String s2) {
        BiFunction<String, String, String> concat = (a, b) -> a + b;
        return concat.apply(s1, s2);
    }

    public static int multiplyTwoIntsBiFunction(int i1, int i2) {
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        return multiply.apply(i1, i2);
    }

    public static String convertDoubleToStringDoubleFunction(double d) {
        DoubleFunction<String> doubleToString = num -> Double.toString(num);
        return doubleToString.apply(d);
    }

    public static int convertDoubleToIntDoubleToIntFunction(double d) {
        DoubleToIntFunction doubleToInt = num -> (int) num;
        return doubleToInt.applyAsInt(d);
    }

    public static double powerTwoIntToDoubleBiFunction(int i1, int i2) {
        ToDoubleBiFunction<Integer, Integer> concat = (a, b) -> Math.pow(a, b);
        double powerRet = concat.applyAsDouble(i1, i2);
        return powerRet;
    }
}
