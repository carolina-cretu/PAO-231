package lists;

import java.util.List;
import java.util.Vector;

/**
 * @author Carolina Cretu
 */
public class MainVector {

    public static void main(String[] args) {
        List<String> wardrobeItems = new Vector<>();
        wardrobeItems.add("Palarie");
        wardrobeItems.add("Rochie");
        wardrobeItems.add(1, "Maiou");
        wardrobeItems.add(2, "Slipi");
        Person p1 = new Person("Ana Ion", wardrobeItems);
        Person p2 = new Person("Ciprian Vega", List.of("Tricou", "pantaloni", "slipi", "sosete", "hanorac")); // on the fly

        System.out.println("Size for p1 wardrobe items is: " + p1.getWardrobeItems().size());
        System.out.println("Size for p1 wardrobe items is: " + p2.getWardrobeItems().size());

        wardrobeItems.remove("Maiou");
        System.out.println("Size for p1 wardrobe items after removal is: " + p1.getWardrobeItems().size());
        for (String item : p1.getWardrobeItems()) {
            System.out.println("P1's wardrobe items are: " + item);
        }


    }
}
