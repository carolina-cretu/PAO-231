package defaultmethodsinterfaces;

/**
 * @author Carolina Cretu
 */
public interface Radio {

    default String turnRadioOn() {
        return "Turning the radio on.";
    }

    default String turnRadioOff() {
        return "Turning the radio off.";
    }
}
