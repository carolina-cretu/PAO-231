package expresiilambda;

/**
 * @author Carolina Cretu
 */


public class DogsActivities {

    AnimalTester animalTester;

    public DogsActivities(AnimalTester animalTester) {
        this.animalTester = animalTester;
    }

    public boolean doTest(Dog d) {
        return animalTester.test(d);
    }

    public AnimalTester getAnimalTester() {
        return animalTester;
    }

    public void setAnimalTester(AnimalTester animalTester) {
        this.animalTester = animalTester;
    }

    // equals, hashcode..
}
