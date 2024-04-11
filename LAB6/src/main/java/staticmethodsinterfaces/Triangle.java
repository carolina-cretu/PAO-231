package staticmethodsinterfaces;

/**
 * @author Carolina Cretu
 */
public class Triangle implements Shapeable {
    private int semiPerimeter;

    private int height;

    public Triangle(int semiPerimeter, int height) {
        this.semiPerimeter = semiPerimeter;
        this.height = height;
    }

    public int getSemiPerimeter() {
        return semiPerimeter;
    }

    public void setSemiPerimeter(int semiPerimeter) {
        this.semiPerimeter = semiPerimeter;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String getShape() {
        return "Triangle";
    }

}
