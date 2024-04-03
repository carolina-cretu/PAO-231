package sorting;

import java.util.Comparator;

/**
 * @author Carolina Cretu
 */
public class StudentGPAComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return  (o1.getGpa().compareTo(o2.getGpa()));
    }
}
