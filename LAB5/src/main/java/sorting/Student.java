package sorting;

/**
 * @author Carolina Cretu
 */

//ordine naturala de sortare cu Comparable
public class Student implements Comparable<Student> {

    private Double gpa;
    private String firstName;
    private String surName;
    private Department department;

    public Student(double gpa, String firstName, String surName, Department department) {
        this.gpa = gpa;
        this.firstName = firstName;
        this.surName = surName;
        this.department = department;

    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public int compareTo(Student o) {
        // daca Stringurile nu sunt egale, comparam dupa nume de familie
        if (this.surName.compareTo(o.surName) != 0) {
            return this.surName.compareTo(o.surName);
        } else {
            //altfel comparam dupa nume de prenume
            return this.firstName.compareTo(o.firstName);
        }
    }

    enum Department {
        MATH, CHEMISTRY, COMPUTER_SCIENCE, PHYSICS
    }


    @Override
    public String toString() {
        return "Student{" +
                "gpa=" + gpa +
                ", firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", department=" + department +
                '}';
    }
}
