package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Carolina Cretu
 */
public class MainRentalGeneric {
    public static void main(String[] args) {
        Car c1 = new Car("12345566778", 2014, "Fiat");
        Car c2 = new Car("123455sdd66778", 2018, "Audi");

        List<Car> cars =  new ArrayList<>();

        cars.add(c1); cars.add(c2);

        RentalGeneric<Car> carRentalGeneric = new RentalGeneric<>(cars, 2);
        // scoatem o masina si nu avem nevoie de cast
        Car carToRent = carRentalGeneric.getRental();
        carRentalGeneric.returnRental(carToRent);

        // nu putem adauga altceva

       //cars.add(new Cat("Miti"));
    }
}
