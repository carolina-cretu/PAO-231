package externalization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Carolina Cretu
 */
public class MainExternalization {

    private static final String OUTPUT_FILE = "localext.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Country c = new Country();
        c.setCode(374);
        c.setName("Armenia");

        FileOutputStream fileOutputStream
                = new FileOutputStream(OUTPUT_FILE);
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        c.writeExternal(objectOutputStream);

        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();

        FileInputStream fileInputStream
                = new FileInputStream(OUTPUT_FILE);
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);

        Country c2 = new Country();
        c2.readExternal(objectInputStream);

        objectInputStream.close();
        fileInputStream.close();


        System.out.println("Get code before ext is the same as getCode after ext? " + (c2.getCode() == c.getCode()));
        System.out.println("Get name before ext is the same as getName after ext? " + (c2.getName().equals(c.getName())));


    }
}
