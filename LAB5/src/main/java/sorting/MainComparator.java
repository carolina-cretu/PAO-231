package sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Carolina Cretu
 */
public class MainComparator {

    public static void main(String[] args) {
        Student s1 = new Student(8.6, "Ciprian", "Atanasoaie", Student.Department.MATH);
        Student s2 = new Student(9.23, "Ana", "Bilde", Student.Department.COMPUTER_SCIENCE);
        Student s3 = new Student(9, "David", "Ilie", Student.Department.PHYSICS);

        Student[] sortStudenti = {s3, s1, s2};
        System.out.println(Arrays.toString(sortStudenti)); // avem afisat array ul nesortat

        Arrays.sort(sortStudenti, new StudentGPAComparator()); // dam ca parametru clasa care implementeaza Comparator pentru sort

        System.out.println(Arrays.toString(sortStudenti)); // avem afisat array ul sortat
    }
}
