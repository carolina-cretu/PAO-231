package exceptions;

/**
 * @author Carolina Cretu
 */
public class Exercitiu2 {

    public static void main(String[] args) {
        System.out.println(f());
    }

    private static int f() {
        try {
            throw new RuntimeException("Exception");
        } catch (RuntimeException e) {
            return 1;
        } finally {
            //bad practice!
            return 2;
        }
    }
}
