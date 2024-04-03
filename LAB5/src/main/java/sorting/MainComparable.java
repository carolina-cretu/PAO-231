package sorting;

import java.util.Arrays;

/**
 * @author Carolina Cretu
 */
public class MainComparable {

    public static void main(String[] args) {

        Student s1 = new Student(9, "David", "Ilie", Student.Department.MATH);
        Student s2 = new Student(9.23, "Ana", "Bilde", Student.Department.COMPUTER_SCIENCE);
        Student s3 = new Student(8.60, "Ciprian", "Atanasoaie", Student.Department.PHYSICS);

        Student [] sortStudenti = {s1, s2, s3};
        System.out.println(Arrays.toString(sortStudenti)); // avem afisat array ul nesortat

        Arrays.sort(sortStudenti);

        System.out.println(Arrays.toString(sortStudenti)); // avem afisat array ul sortat dupa ordinea naturala



    }
}
