package sealingmechanism;

/**
 * @author Carolina Cretu
 */

// subclasele permise trebuie sa fie final, sealed sau non-sealed
public non-sealed class Truck extends SealedVehicleClass implements SealedVehicleInterface {

    public Truck(String registrationNumber) {
        super(registrationNumber);
    }

    @Override
    public String getEngineType() {
        return null;
    }
}
