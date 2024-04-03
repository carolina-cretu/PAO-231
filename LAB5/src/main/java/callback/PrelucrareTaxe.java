package callback;

/**
 * @author Carolina Cretu
 */
public class PrelucrareTaxe {

    // clasa si metoda care prelucreaza metoda generica din interfata; primeste ca parametru interfata, pentru a apela cu orice implementare
    static void calculateTax(CountyTax taxa) {

        // calculam taxa default, ca deh... :)
        double centralTax = 2000.0;


        //calculare taxa judeteana
        double countyTax = taxa.CountyTax();

        System.out.println("Taxa totala pe 2024 = " + (centralTax + countyTax));

    }
}
