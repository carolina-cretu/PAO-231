package enums;

/**
 * @author Carolina Cretu
 */
public enum CoffeeDeliveryShift {
    EARLY("7:00 - 10:00"),
    LATE("10:00 = 12:30");

    private String deliveryHours;

    CoffeeDeliveryShift(String deliveryHours) {
        this.deliveryHours = deliveryHours;
    }

    public String getDeliveryHours() {
        return deliveryHours;
    }
}
