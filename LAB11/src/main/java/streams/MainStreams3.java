package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Carolina Cretu
 */
public class MainStreams3 {

    public static void main(String[] args) {
        // cream un stream folosind o cale
        try{
            Stream<String> stream = Files.lines(Paths.get(System.getProperty("user.home")));
            stream.forEach(line -> System.out.println(line));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
