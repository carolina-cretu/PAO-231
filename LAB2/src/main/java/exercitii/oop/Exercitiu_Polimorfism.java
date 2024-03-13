package exercitii.oop;

/**
 * @author Carolina Cretu
 */
public class Exercitiu_Polimorfism {

    public static void main(String[] args) {
        Animal a1 = new Animal();
        Animal a2 = new Eagle(AnimalType.OMNIVORE, 2, "white");
        Animal a3 = new Tiger(AnimalType.CARNIVORE, 4, false);

        moveAndEat(a1);
        moveAndEat(a2);
        moveAndEat(a3);
    }

    public static void moveAndEat(Animal animal) {
        animal.move();
        animal.eat();
    }
}
