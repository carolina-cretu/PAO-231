package enums;

/**
 * @author Carolina Cretu
 */
public enum CoffeeDeliverySystem {
    INSTANCE;


    // cod care sa suprascrie tura de livrare default
    private CoffeeDeliveryShift deliveryShift = CoffeeDeliveryShift.EARLY;

    public static CoffeeDeliverySystem getInstance() {
        return INSTANCE;
    }

    public CoffeeDeliveryShift getDeliveryShift() {
        return deliveryShift;
    }
}
