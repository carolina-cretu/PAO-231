package expresiilambda;

/**
 * @author Carolina Cretu
 */
public class MainPassLambdaToMethod {

    public static void main(String[] args) {
        AnimalTester at = new AnimalTester() {
            @Override
            public boolean test(Dog d) {
                return d.getAge() > 5;
            }
        };

        // putem pasa AnimalTester ca parametru din clasa anonima interioara
        DogsActivities da = new DogsActivities(at);

        // sau putem pasa direct o expresie lambda
        DogsActivities da1 = new DogsActivities(d -> d.getAge() > 5);

        System.out.println("Are Tuck mai mult de 5 ani ? " + da1.doTest(new Dog("Tuck", 4)));
    }
}
