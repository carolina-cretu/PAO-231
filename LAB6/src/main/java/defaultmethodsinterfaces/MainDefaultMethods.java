package defaultmethodsinterfaces;

/**
 * @author Carolina Cretu
 */
public class MainDefaultMethods {

    public static void main(String[] args) {
        Vehicle car = new Car("Toyota");

        System.out.println(car.getBrand());
        System.out.println(car.speedUp());
        System.out.println(car.slowDown());

        // metodele default sunt disponibile automat in clasa care implementeaza interfata
        System.out.println(car.turnRadioOn());
        System.out.println(car.turnRadioOff());

    }
}
