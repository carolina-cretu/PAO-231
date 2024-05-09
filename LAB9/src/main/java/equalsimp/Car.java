package equalsimp;

import java.util.Objects;

/**
 * @author Carolina Cretu
 */
public class Car {

    private String vin;

    public Car(String vin) {
        this.vin = vin;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        //intotdeauna facem instanceof pentru a fi siguri ca la runtime nu avem ClassCastException !
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getVin().equals(car.getVin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVin());
    }
}
