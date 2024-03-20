package enums;

/**
 * @author Carolina Cretu
 */
public class Main {

    public static void main(String[] args) {


        Coffee coffee1 = new Coffee(Coffee.CoffeeOrder.SMALL, CoffeeType.BRAZIL);

        System.out.println("Is coffee order double ? " + coffee1.isDoubleCoffee());
        System.out.println("Order will take " + coffee1.getOrderInMinutes() + " minutes.");
        System.out.println(coffee1.getCoffeeType().name());
        System.out.println("Next coffee flavour to try is: " + coffee1.getNextCoffeeFlavour(CoffeeType.ECUADOR));
        System.out.println(Coffee.CoffeeOrder.SMALL); // toString() este deja suprascrisa in clasele de tip enum
    }

}
