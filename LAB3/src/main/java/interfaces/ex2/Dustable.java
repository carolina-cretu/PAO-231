package interfaces.ex2;

/**
 * @author Carolina Cretu
 */
public interface Dustable {

    int DUST_AVAILABLE = 300;
    boolean ELEVATED = true;

    default boolean isElevated(int remainingDust) {
        return remainingDust >= DUST_AVAILABLE && ELEVATED;
    }

    String calculateDustOrigin(Origin origin);
}
