package exercitii.blocurideinitializare;

/**
 * @author Carolina Cretu
 */
public class Main {

    public static void main(String[] args) {

        Student s1 = new Student(20);
        System.out.println(s1);
        System.out.println();
        Student s2 = new Student();
        s2.setVarsta(19);
        System.out.println(s2);
    }
}
