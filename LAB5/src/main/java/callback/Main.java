package callback;

/**
 * @author Carolina Cretu
 */
public class Main {

    public static void main(String[] args) {
        CountyTax ct1 = new Prahova();
        CountyTax ct2 = new Bucuresti();

        // implementare callback in Java
        PrelucrareTaxe.calculateTax(ct1);
        PrelucrareTaxe.calculateTax(ct2);
    }
}
