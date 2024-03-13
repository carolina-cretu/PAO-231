package exercitii.oop;

/**
 * @author Carolina Cretu
 */
public class Animal {
    private AnimalType type;    //good practice: atributele trebuie sa fie private, iar pentru manipularea lor folosim metode de tip getter/setter
    private int noOfLegs;

    public Animal() {   //constructor
    }

    /**
     * Supraincarcare constructor (overloading)
     */
    public Animal(AnimalType type, int noOfLegs) {  //constructor
        this.type = type;
        this.noOfLegs = noOfLegs;
    }

    public void move() {
        System.out.println("I can move!");
    }

    public void eat() {
        System.out.println("I need food!");
    }

    public void eat(String whatIEat) {
        System.out.println("I eat " + whatIEat);
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public int getNoOfLegs() {
        return noOfLegs;
    }

    public void setNoOfLegs(int noOfLegs) {
        this.noOfLegs = noOfLegs;
    }
}
