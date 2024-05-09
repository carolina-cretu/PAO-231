package generics;

import java.util.List;

/**
 * @author Carolina Cretu
 */
public class GenericsExample {

    private List <Car> cars;

    // parametru
    public GenericsExample(List<Car> cars) {
        this.cars = cars;
    }

    // tip returnat
    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
