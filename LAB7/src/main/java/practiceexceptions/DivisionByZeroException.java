package practiceexceptions;

/**
 * @author Carolina Cretu
 */

//exceptie custom checked
public class DivisionByZeroException  extends Exception{

    public DivisionByZeroException(String message) {
        super(message);
    }
}
