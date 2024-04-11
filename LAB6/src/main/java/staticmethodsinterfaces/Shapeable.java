package staticmethodsinterfaces;

/**
 * @author Carolina Cretu
 */
public interface Shapeable {

    String getShape();

    static int getArea(int height, int width) {
        return height * width;
    }
}
