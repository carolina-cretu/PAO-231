package optionals;

import java.util.Optional;

/**
 * @author Carolina Cretu
 */
public class MainCreateOptional {

    public static void main(String[] args) {
        Dog dog = new Dog("Codi", 12);
        Optional<Dog> optionalDog = Optional.of(dog);
        optionalDog.ifPresent(System.out::println);
    }
}
