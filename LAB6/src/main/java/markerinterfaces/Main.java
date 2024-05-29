package markerinterfaces;

import java.math.BigDecimal;

/**
 * @author Carolina Cretu
 */
public class Main {

    public static void main(String[] args) throws CloneNotSupportedException { // declaram exceptia in semnatura main, e checked
        Person p1 = new Person("Andrei", 43, new Job("Profesor", new BigDecimal(5670)));
        Person p2 = (Person) p1.clone(); // face cast ca ne intaorce Object

        System.out.println(p1);
        System.out.println(p2);


        // setarea salariului pentru Obiectul Job din p2 se face si pentru p1, deoarece clone realizeaza clonarea referintei doar (prin intermediul careia se poate modifica obiectul (shallow cloning)
        // pentru deep cloning (evitarea campurilor Job sa aiba aceeasi referinta), trebuie sa implementam clone si in Job
        p2.getJob().setSalary(new BigDecimal(6300));

        System.out.println(p1);
        System.out.println(p2);
    }
}
