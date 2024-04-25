package externalization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Carolina Cretu
 */
public class MainExternalizationInheritance {


    private static final String OUTPUT_FILE = "fileextinheritance.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Region r = new Region();
        r.setCode(374);
        r.setName("Armenia");
        r.setClimate("Warm");
        r.setPopulation(30000d);

        FileOutputStream fileOutputStream
                = new FileOutputStream(OUTPUT_FILE);
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        r.writeExternal(objectOutputStream);

        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();

        FileInputStream fileInputStream
                = new FileInputStream(OUTPUT_FILE);
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);

        Region r2 = new Region();
        r2.readExternal(objectInputStream);

        objectInputStream.close();
        fileInputStream.close();

        System.out.println("Get code before ext is the same as getCode after ext? " + (r2.getCode() == r.getCode()));
        System.out.println("Get name before ext is the same as getName after ext? " + (r2.getName().equals(r.getName())));


    }
}
