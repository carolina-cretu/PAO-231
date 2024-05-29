package maps;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Carolina Cretu
 */
public class MainHashMap {

    public static void main(String[] args) {
        Map<Animal, Object> map1 = new HashMap<>();

        Cat c1 = new Cat("Tom"); // pastram aceasta referinta
        Cat c2 = new Cat("Max");
        Horse h1 = new Horse("Billy");
        Dog d1 = new Dog("Codi", "white");
        map1.put(c1, "cat 1"); map1.put(new Horse("Billy"), "horse 1"); map1.put(new Cat("Max"), Pets.CAT);
        map1.put(null,"null key"); map1.put(new Dog("Codi", "white"), Pets.DOG);

        System.out.println(map1.get(null));
        System.out.println(map1.get(c1));
        System.out.println(map1.get(c2));
        System.out.println(map1.get(d1));
        System.out.println(map1.get(h1));

        //iteram
        for (Map.Entry<Animal, Object> entry: map1.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }


}
