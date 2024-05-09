package equalsimp;

/**
 * @author Carolina Cretu
 */
public class MainEqualsTest {

    public static void main(String[] args) {
        Car c = new Car("1234566789b");
        Car c2 = new Car("1234566789b");

        System.out.println("c equals c2 ? "+ c.equals(c2));
    }
}
