package exercitii.statickeyword;

/**
 * @author Carolina Cretu
 */
public class Main {

    public static void main(String[] args) {
        Double mps = Car.convertFromKmPerHourToMilesPerHour(10L); //call de metoda statica fara instanta; se poate face si cu instanta, dar nu este recomandat
        System.out.println(mps);

        System.out.println(Car.numberOfWheels);
    }
}
