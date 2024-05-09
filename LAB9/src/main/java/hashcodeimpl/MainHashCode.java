package hashcodeimpl;

/**
 * @author Carolina Cretu
 */
public class MainHashCode {

    public static void main(String[] args) {
        Car c1 = new Car("12456dcdg", 2017, "Skoda");
        Car c2 = new Car("12456dcdg", 2020, "BMW");
        Car c3 = new Car("12456dcdc", 2017, "Skoda");

        System.out.println("Car1 equals car2 ? " + c1.equals(c2));
        System.out.println("Car1 equals car3 ? " + c1.equals(c3));
        System.out.println("Car2 equals car3 ? " + c2.equals(c3));
        System.out.println("<-------------------------------------------------------------->");
        System.out.println( "Car1 hashCode is: " + c1.hashCode() + " Car2 hashCode is: " + c2.hashCode());
        System.out.println("Car1 hashCode is: " + c1.hashCode() + " Car3 hashCode is: " + c3.hashCode());
        System.out.println("Car2 hashCode is: " + c2.hashCode() + " Car1 hashCode is: " + c3.hashCode());
    }


}
