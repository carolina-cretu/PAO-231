package serializationcaveats;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Carolina Cretu
 */
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // oare va compila acest exwmplu ?!
        Person p = new Person();
        Address address = new Address();
        // adresa
        address.setName("Unirii");
        address.setNumber(20);
        // persoana
        p.setAge(21);
        p.setName("Alex");
        p.setAddress(address);

        FileOutputStream fileOutputStream
                = new FileOutputStream("yourfile.txt");
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(p);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream
                = new FileInputStream("yourfile.txt");
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);
        Person p2 = (Person) objectInputStream.readObject();
        objectInputStream.close();


        System.out.println("Age before serialization and after deserialization is the same ? "+ (p.getAge() == p2.getAge()));
       // System.out.println("Address before serialization and after deserialization is the same ? "+ (p.getAddress() == p2.getAddress()));
    }
}
