package exercitii.innerclasses;

/**
 * @author Carolina Cretu
 */

class OuterClass {
    private static String msg = "Message";

    // Clasa statica interioara (nested static class)
    public static class NestedStaticClass {

        // Doar membrii statici ai clasei Outer pot fi apelati
        public void printMessage() {
            // Daca msg ar fi non static, am avea eroare de compilare
            System.out.println("Message from nested static class: " + msg);
        }
    }

    // Clasa interioara non-statica  (non-static nested class)
    public class InnerClass {

        //Are acces si la membri statici si la cei nonstatici ai clasei Outer
        public void display() {
            System.out.println("Message from non-static nested class: " + msg);
        }
    }
}

public class Main {     //maxim 1 clasa publica per fisier; numele trebuie sa coincida cu al fisierului

    public static void main(String args[]) {

        // Creare de instanta pentru clasa interioara statica
        OuterClass.NestedStaticClass staticClass = new OuterClass.NestedStaticClass();

        // Apel al metodei non statice a clasei statice interioare
        staticClass.printMessage();

        // Ca sa cream o instanta de InnerClass, ne trebuie una de OuterClass
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();

        // Apel al metodei non statice a clasei interioare
        inner.display();

        // Creare de instante de clasa nonstatica intr-o singura linie
        OuterClass.InnerClass innerObject = new OuterClass().new InnerClass();

        // Similar, apelul metodei
        innerObject.display();
    }
}