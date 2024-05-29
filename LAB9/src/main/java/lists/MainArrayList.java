package lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Carolina Cretu
 */
public class MainArrayList {

    public static void main(String[] args) {
        Student s1 = new Student("Ion Popescu", 19);
        List<Integer> grades = new ArrayList<>(); // declarare fara sa ii dam capacitate initiala
        grades.add(10); grades.add(9); grades.add(7);
        System.out.println("List of initial grades for student " + s1.getName() + " is " + grades);

        s1.setGrades(grades);

        System.out.println("Index 1 of student's grades is " + s1.getGrades().get(1)); // indexul incepe de la 0 !
        System.out.println("Size of student grades is: " + s1.getGrades().size());
        System.out.println("Does student grades contain a String ? " + s1.getGrades().contains("hihi"));

        s1.getGrades().remove(1);

        for (Integer grade: s1.getGrades()) {
            System.out.println("Grade is " + grade);
        }

        System.out.println("List of grades for student " + s1.getName() + " after removal is " + grades);

        s1.getGrades().add(6); // nu adaugam primitive, autoboxingul se ocupa de infasurat primitiva intr-un Integer !

        System.out.println(s1);



    }

}
