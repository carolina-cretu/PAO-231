package expresiilambda.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Carolina Cretu
 */
public class MainConsumerChaining {

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        Dog max = new Dog("Max", 5, 30);
        Dog codi = new Dog("Codi", 12, 35);
        Dog mini = new Dog("Mini", 1, 15);

        dogs.add(max);
        dogs.add(codi);
        dogs.add(mini);

        Consumer<Dog> nume = d -> System.out.println(d.getName() + " ");
        dogs.forEach(nume);
        System.out.println("<---------------------->");
        // daca vrem sa afisam si metoda bark() dupa, putem sa facem inlantuire folosind andThen()
        dogs.forEach(nume.andThen(d -> d.bark()));
    }
}
