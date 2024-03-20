package interfaces;

import interfaces.ex1.Circle;
import interfaces.ex1.Shapeable;
import interfaces.ex1.Square;
import interfaces.ex2.OrcPlayer;
import interfaces.ex2.Origin;
import interfaces.ex2.Player;

/**
 * @author Carolina Cretu
 */
public class Main {

    public static void main(String[] args) {
        Shapeable shapeable = new Circle();
        Shapeable shapeable2 = new Square();

        System.out.println(shapeable.getName());
        System.out.println(shapeable2.getName());

        System.out.println("----------------------------------------");

        Player player1 = new OrcPlayer(0, 150);

        System.out.println(player1.calculateDustOrigin(Origin.DEMIGOD));
        System.out.println(player1.isElevated(200));
    }


}
