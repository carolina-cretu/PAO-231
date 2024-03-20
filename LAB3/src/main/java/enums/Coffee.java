package enums;

/**
 * @author Carolina Cretu
 */
public class Coffee {

    enum CoffeeOrder {
        TALL, GRANDE, SMALL // se poate declara si in interiorul unei clase si separat
    }

    private CoffeeOrder order;
    private CoffeeType coffeeType;

    public Coffee(CoffeeOrder order, CoffeeType coffeeType) {
        this.order = order;
        this.coffeeType = coffeeType;
    }

    public boolean isDoubleCoffee() {
        if (getOrder() == CoffeeOrder.GRANDE) {
            return true;
        }

        return false;
    }

    public int getOrderInMinutes() {
        switch (getOrder()) {
            case SMALL:
                return 3;
            case TALL:
                return 5;
            case GRANDE:
                return 7;
        }
        return 0;
    }

    public CoffeeOrder getOrder() {
        return order;
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public CoffeeType getNextCoffeeFlavour (CoffeeType type) {
        return coffeeType.getNextType(type);
    }
}
