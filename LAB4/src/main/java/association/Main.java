package association;

import java.util.List;

/**
 * @author Carolina Cretu
 */
public class Main {

    public static void main(String[] args) {
        List<Student> studentList = List.of(new Student("Ion Popescu", "Java"), new Student("Maria Dinu", "C++"), new Student("Andrei Dobre", "Sisteme de operare"));
        Department department = new Department("Informatica", studentList);

        Volvo.VolvoEngine volvoEngine = new Volvo().new VolvoEngine(256, "titanium");

        Volvo volvo = new Volvo(1956, "red", volvoEngine);

        System.out.println(volvo);
        System.out.println(department);
    }
}
