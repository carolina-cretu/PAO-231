package customserialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Carolina Cretu
 */
public class MainCustomSerialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person p = new Person();
        p.setAge(20);
        p.setName("Joe");

        Address a = new Address();
        a.setHouseNumber(1);

        Employee e = new Employee();
        e.setPerson(p);
        e.setAddress(a);

        FileOutputStream fileOutputStream
                = new FileOutputStream("yourfile2.txt");
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(e);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream
                = new FileInputStream("yourfile2.txt");
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);
        Employee e2 = (Employee) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(" Age before is the same with age after? " + (e2.getPerson().getAge() == e.getPerson().getAge()));
        System.out.println("Address house number before is the same with the address house number before? " + (e2.getAddress().getHouseNumber() == e.getAddress().getHouseNumber()));

    }


}
