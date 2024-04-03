package callback;

/**
 * @author Carolina Cretu
 */
public class Prahova  implements CountyTax {

    //clasa care implementeaza metoda generica
    @Override
    public double CountyTax() {
        return 3000.0;
    }
}
