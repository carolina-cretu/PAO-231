package expresiilambda;

/**
 * @author Carolina Cretu
 */
public class Main {

    public static void main(String[] args) {
        //clasa interioara anonima pentru instantierea lui AnimalTester
        AnimalTester at = new AnimalTester() {
            @Override
            public boolean test(Dog d) {
                return d.getAge() > 5;
            }
        };

        //expresie lambda
        AnimalTester at2 = d -> d.getAge() > 5;
        Dog d = new Dog("Max", 6);
        System.out.println("Is dog older than 5 ? " + at2.test(d));

        //lambda cu mai multe instructiuni
        AnimalTester at3 = dog -> {
            System.out.println("Testam " + d.getName());
            return d.getAge() > 5;
        };
    }
}
