package sealingmechanism;

/**
 * @author Carolina Cretu
 */
public abstract sealed class SealedVehicleClass permits Car, Truck {

    protected final String registrationNumber;

    public SealedVehicleClass(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
