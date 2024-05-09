package generics;

import java.util.Objects;

/**
 * @author Carolina Cretu
 */
public class Car {

    private String vin;
    private int fabricationYear;
    private String make;

    public Car(String vin, int fabricationYear, String make) {
        this.vin = vin;
        this.fabricationYear = fabricationYear;
        this.make = make;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getFabricationYear() {
        return fabricationYear;
    }

    public void setFabricationYear(int fabricationYear) {
        this.fabricationYear = fabricationYear;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    // pentru o performanta mare, folosim cat mai putin atribute; in cazul acesta, doar seria de sasiu !
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getVin().equals(car.getVin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVin());
    }
}
