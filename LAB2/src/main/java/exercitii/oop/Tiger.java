package exercitii.oop;

import java.util.Objects;

/**
 * @author Carolina Cretu
 */
public class Tiger extends Animal {

    private boolean isSiberian;

    @Override
    public void move() {
        System.out.println("I can jump!");
    }

    public Tiger(AnimalType type, int noOfLegs, boolean isSiberian) {
        super(type, noOfLegs);
        this.isSiberian = isSiberian;
    }

    @Override
    public boolean equals(Object o) {   //overridden from Object class
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tiger tiger = (Tiger) o;
        return this.isSiberian == tiger.isSiberian
                && this.getType() == tiger.getType()
                && this.getNoOfLegs() == tiger.getNoOfLegs();
    }

    @Override
    public int hashCode() {
        return Objects.hash(isSiberian, getNoOfLegs(), getType());
    }
}
