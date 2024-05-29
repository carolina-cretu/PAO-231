package expresiilambda.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * @author Carolina Cretu
 */

// Predicate contine metoda functionala test() care intoarce un boolean
// un exemplu de uz pentru predicate: ArrayList contine metoda removeIf() care asteapta un predicat
//Interfata Predicate are metode default care ne pot ajuta sa inlantuim predicatele: and(), or(), negate()
// Exista variatii de predicate ca BiPredicate, DoublePredicate, IntPredicate si LongPredicate
public class MainPredicate {

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();

        Dog codi = new Dog("Codi", 6, 30);
        Dog mini = new Dog("Mini", 1, 12);
        Dog cleo = new Dog("Cleo", 3, 15);
        Dog max = new Dog("Max", 4, 29);

        Predicate<Dog> predicate = d -> d.getAge() > 5;
        System.out.println("Are Codi mai mult de 5 ani? " + predicate.test(codi));
        System.out.println("Are Mini mai mult de 5 ani? " + predicate.test(mini));

        dogs.add(codi);
        dogs.add(mini);
        dogs.add(cleo);
        dogs.add(max);
        Predicate<Dog> findCs = d -> d.getName().startsWith("C");
        dogs.removeIf(findCs);
        System.out.println("----Dupa ce am sters cateii al caror nume incepe cu 'C'----");
        dogs.forEach(d -> System.out.println(d.getName()));

        Predicate<Dog> age = d -> d.getAge() == 6;
        System.out.println("Are Codi alta varsta decat 6 ? " + age.negate().test(codi));

        // exemplu de IntPredicate care nu mai are nevoie de type T pentru ca primeste ca parametru un int
        IntPredicate answer = i -> i == 42;
        System.out.println("Este raspunsul 42? " + answer.test(42));
    }
}
