package defaultmethodsinterfaces;

/**
 * @author Carolina Cretu
 */
public class Car implements Vehicle {

    private String brand;


    public Car(String brand) {
        this.brand = brand;
    }


    // getteri si setteri, equals, hashCode, toString()....

    @Override
    public String getBrand() {
        return null;
    }

    @Override
    public String speedUp() {
        return "The car is increasing its speed !";
    }

    @Override
    public String slowDown() {
        return "The cars is slowing down !";
    }
}
