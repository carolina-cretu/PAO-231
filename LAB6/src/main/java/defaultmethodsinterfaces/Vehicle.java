package defaultmethodsinterfaces;

/**
 * @author Carolina Cretu
 */
public interface Vehicle {
    String getBrand();

    String speedUp();

    String slowDown();

    default String turnRadioOn() {
        return "Turning the radio on.";
    }

    default String turnRadioOff() {
        return "Turning the radio off.";
    }
}
