package records;

import java.util.Objects;

/**
 * @author Carolina Cretu
 */
public record Person(String name, String address, Integer age) {
    //declarare de campuri statice
    public static String UNKNOWN_ADDRESS = "Unknown address";
    public static Integer UNKNOWN_AGE = 0;

    public static String UNKNOWN_NAME = "Unknown name";

// customizare constructor public

    // nu putem genera un constructor cu aceeasi lista de parametri
    public Person {
        Objects.requireNonNull(name);
        Objects.requireNonNull(address);
        Objects.requireNonNull(age);
    }


    public static Person unnamed(String address, Integer age) {
        return new Person("Unnamed", address, age);
    }

// constructor aditional (non-canonic); trebuie sa cheme un alt constructor altfel ne da eroare de compilare
    public Person() {
        this(UNKNOWN_NAME, UNKNOWN_ADDRESS, UNKNOWN_AGE);
    }
}
