package staticmethodsinterfaces;

/**
 * @author Carolina Cretu
 */
public class Main {

    public static void main(String[] args) {
        Triangle shapeable = new Triangle(10, 5);

        //aria unui triunghi oarecare calculata folosind o metoda utilitara din interfata
        Shapeable.getArea(shapeable.getSemiPerimeter(), shapeable.getHeight());
    }
}
