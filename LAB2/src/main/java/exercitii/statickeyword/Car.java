package exercitii.statickeyword;

/**
 * @author Carolina Cretu
 */
public class Car {
    private String brand;
    private Long maxSpeedInKmPerHour;

    public static int numberOfWheels = 4;           //putem adauga final pentru a face atributul constanta

    public static Double convertFromKmPerHourToMilesPerHour(Long speed) {
        return speed / 3.6;
    }

    public Long getMaxSpeedInKmPerHour() {
        return maxSpeedInKmPerHour;
    }

    public void setMaxSpeedInKmPerHour(Long maxSpeedInKmPerHour) {
        this.maxSpeedInKmPerHour = maxSpeedInKmPerHour;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
