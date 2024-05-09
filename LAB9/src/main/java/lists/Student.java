package lists;

import java.util.List;
import java.util.Objects;

/**
 * @author Carolina Cretu
 */
public class Student {
    private String name;
    private int age;
    private String studyDepartment;
    private List<Integer> grades;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStudyDepartment() {
        return studyDepartment;
    }

    public void setStudyDepartment(String studyDepartment) {
        this.studyDepartment = studyDepartment;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getAge() == student.getAge() && getName().equals(student.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", studyDepartment='" + studyDepartment + '\'' +
                ", grades=" + grades +
                '}';
    }
}
