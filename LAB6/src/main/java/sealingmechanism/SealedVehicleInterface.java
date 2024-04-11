package sealingmechanism;

/**
 * @author Carolina Cretu
 */
public  sealed interface SealedVehicleInterface permits Car, Truck{

    String getEngineType();
}
