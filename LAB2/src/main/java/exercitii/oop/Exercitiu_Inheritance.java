package exercitii.oop;

/**
 * @author Carolina Cretu
 */
public class Exercitiu_Inheritance {

    public static void main(String[] args) {
        Animal animal = new Animal(AnimalType.HERBIVORE, 4); //instantiere
        animal.move();

        Eagle bird = new Eagle(AnimalType.HERBIVORE, 2, "white");
        bird.move();
    }
}
