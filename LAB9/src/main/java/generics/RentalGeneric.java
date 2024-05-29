package generics;

import java.util.List;

/**
 * @author Carolina Cretu
 */
public class RentalGeneric<T>{ // t =  type

    private List<T> rentalPool; // folosim tipul clasei pentru tipul listei

    private int maxNum;

    public RentalGeneric(List<T> rentalPool, int maxNum) { // constructorul foloseste si el o lista de tipul clasei
        this.rentalPool = rentalPool;
        this.maxNum = maxNum;
    }

    public T getRental() {  //inchiriem T
       // blocam pana ceva este disponibil
        return rentalPool.get(0);
    }

    public void returnRental (T returnedThing) { // intoarce T
        rentalPool.add(returnedThing);
    }

    public int getMaxNum() {
        return maxNum;
    }


}
