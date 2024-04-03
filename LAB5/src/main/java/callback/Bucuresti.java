package callback;

/**
 * @author Carolina Cretu
 */
public class Bucuresti implements CountyTax {

    //clasa care implementeaza metoda generica
    @Override
    public double CountyTax() {
        return 5500.0;
    }
}
