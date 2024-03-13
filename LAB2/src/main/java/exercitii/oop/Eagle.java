package exercitii.oop;

/**
 * @author Carolina Cretu
 */
public class Eagle extends Animal {
    private String colour;

    public Eagle(AnimalType type, int noOfLegs, String colour) {
        super(type, noOfLegs);          //call parent class constructor
        this.colour = colour;
    }

    /**
     * Suprascriere metoda (method overriding)
     */
    @Override
    public void move() {
        System.out.println("I can fly!");
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
