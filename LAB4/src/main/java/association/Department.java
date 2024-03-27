package association;

import java.util.List;

/**
 * @author Carolina Cretu
 */
public class Department {

    private String name;
    private List<Student> student; // agregare -> o lista de studenti poate exista independent de departament; asociere mai slaba decat compozitia

    public Department(String name, List<Student> student) {
        this.name = name;
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
