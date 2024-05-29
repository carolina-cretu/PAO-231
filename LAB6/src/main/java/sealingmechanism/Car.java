package sealingmechanism;

/**
 * @author Carolina Cretu
 */

// subclasele permise trebuie sa fie final, sealed sau non-sealed
public final class Car extends SealedVehicleClass implements SealedVehicleInterface {
    private String engine;


    public Car(String registrationNumber, String engine) {
        super(registrationNumber);
        this.engine = engine;
    }

    @Override
    public String getEngineType() {
        return engine;
    }
}
