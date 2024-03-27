package records;

import java.sql.SQLOutput;

/**
 * @author Carolina Cretu
 */
public class Main {

    public static void main(String[] args) {
        Person p1 = Person.unnamed("Address one", 26);
        Person p2 = new Person("John Wayne", Person.UNKNOWN_ADDRESS, Person.UNKNOWN_AGE);
        Person p3 = new Person("John Wayne", Person.UNKNOWN_ADDRESS, Person.UNKNOWN_AGE);
        Person p4 = new Person("Dani Starr", Person.UNKNOWN_ADDRESS, Person.UNKNOWN_AGE);
        Person p5 = new Person();


        // toString generat
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p5);

        //equals generat; intoarce true daca obiectul e de acelasi tip si valorile campurilor pe care le contine sunt identice; daca unul dintre campuri difera, equals intoarce false
        System.out.println("Person2 equals Person3 ? " + p2.equals(p3));
        System.out.println("Person3 equals Person4 ? " + p3.equals(p4));
        // hashCode generat ne intoarce aceeasi valoare pentru 2 obiecte care au atributele identice; daca atributele a doua obiecte de acelais fel difera, probabil ca si hashCode ul generat este diferit, desi nu este garantat de contract
        System.out.println("Person2 hashCode: " + p2.hashCode() +  " and Person3 hashCode: " + p2.hashCode());

    }
}
