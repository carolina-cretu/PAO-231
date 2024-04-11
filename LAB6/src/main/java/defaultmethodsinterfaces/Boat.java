package defaultmethodsinterfaces;

/**
 * @author Carolina Cretu
 */

//codul acesta nu compileaza pana nu implementam metodele default
public class Boat implements Radio, Vehicle{

    private String brand;

    public Boat(String brand) {
        this.brand = brand;
    }


    //getteri, setteri, etc..
    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String speedUp() {
        return "The boat is increasing its speed !";
    }

    @Override
    public String slowDown() {
        return "The boat is sowing down !";
    }
// implementare metode default cu apel de super la implementarile din interfete
    @Override
    public String turnRadioOn() {
        return Radio.super.turnRadioOn() + Vehicle.super.turnRadioOn();
    }

    @Override
    public String turnRadioOff() {
        return Radio.super.turnRadioOff();
    }
}
