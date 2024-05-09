package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Carolina Cretu
 */
public class MainLegacyCollections {

    public static void main(String[] args) {
        List myList = new ArrayList();

        myList.add("Ana");
        myList.add(32);
        myList.add(new Car("123456", 2011, "Toyota"));

        //sa luam stringul...

        String s = (String) myList.get(0); // facem cast, desi ar putea crapa la runtime..

    }


}
