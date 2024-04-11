package privatemethodsinterfaces;

/**
 * @author Carolina Cretu
 */
public interface Calculate {

    default int calculate1() {
        int value = 10;
        additionalCalculation(value);
        return value;
    }

    default int calculate2(int value) {
        additionalCalculation(value);
        return value;
    }


    //codul comun este pus in metoda privata
    private void additionalCalculation(int value) {
        if (value >= 10) {
            value -= 2;
        } else {
            value *= 2;
        }
    }
}
