package generics;

import queues.Cat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Carolina Cretu
 */
public class MainGenerics {

    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("Ana");
        //myList.add(new Car("123456", 2011, "Toyota"));// eroare de compilare
        // myList.add(42); // eroare de compilare

        String s = myList.get(0); // fara cast, avem garantia ca este String

        // orice subtip de animal (se aplica si la clase tot extends)
        List<? extends Animal> list1 = new ArrayList<Dog>();
        //list1.add(new Dog("Blue", "black")); // nu merge sa facem add cu declaratia parametrizata de mai sus; daca nu facem add, merge

        // lista parametrizata pe Dog sau orice supertip de Dog
        List<? super Dog> list2 = new ArrayList<>();
        list2.add(new Dog("Blue", "black")); // merge sa facem add asa

    }

    // generics cu orice subtip de Object ca parametru
    void foo(List<? extends Object> list) {
        // cod
    }
    // generics cu orice supertip de Dog sau Dog ca parametru
    public void addAnimal (List<? super Dog> list) {//cod
    }



}
