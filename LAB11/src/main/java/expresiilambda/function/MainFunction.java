package expresiilambda.function;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author Carolina Cretu
 */

// Metoda apply() a interfetei Function ia o valoare si o transforma in alta; cele 2 valori nu trebuie sa aiba acelasi tip de date
// exista variatii de Function (exemplu, BiFunction, DoubleFunction, IntFunction, LongFunction, DoubleToIntFunction, IntToLongFunction, LongToDoubleFunction, etc)
// exemple din JDK pentru function: metodele din Map computeIfAbsent() si replaceAll()
public class MainFunction {

    public static void main(String[] args) {
        Function<Integer, String> answer = a -> {
            if (a == 42) return "forty-two";
            else return "No answer !";
        };
        System.out.println(answer.apply(32));
        System.out.println(answer.apply(42));

        // ia 2 String uri ca argumente si intoarce un String
        BiFunction<String, String, String> firstLast = (first, last) -> first + " " + last;
        System.out.println("First and last name: " + firstLast.apply("Ana", "Popescu"));

        // exemple din JDK
        Map<String, String> juneWinner = new TreeMap<>();
        juneWinner.put("June 2020", "Alex");
        juneWinner.put("June 2021", "Ioana");
        juneWinner.put("June 2022", "Daniel");

        System.out.println("---Lista inainte de a verifica Iunie 20219---");
        juneWinner.forEach((k, v) -> System.out.println(k + ": " + v));

        //nu exista cheie pentru iunie 2019, deci Ana este adaugata in map
        juneWinner.computeIfAbsent("June 2019", (k) -> "Ana");

        // exista cheie pentru iunie 2019, deci Andrei nu este adaugat in map
        juneWinner.computeIfAbsent("June 2019", (k) -> "Andrei");

        System.out.println("---Lista dupa ce am verificat Iunie 20219---");
        juneWinner.forEach((k, v) -> System.out.println(k + ": " + v));
        // folosim o BiFunction pentru a inlocui toate valorile din map cu valori uppercase
        juneWinner.replaceAll((key, oldValue) -> oldValue.toUpperCase());
        System.out.println("---Lista dupa ce am modificat valorile sa fie uppercase---");
        juneWinner.forEach((k, v) -> System.out.println(k + ": " + v));

    }
}
