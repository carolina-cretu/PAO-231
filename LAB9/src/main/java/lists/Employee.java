package lists;

import java.util.List;
import java.util.Objects;

/**
 * @author Carolina Cretu
 */
public class Employee {

    private String name;
    private List<String> workingTools;

    public Employee(String name, List<String> workingTools) {
        this.name = name;
        this.workingTools = workingTools;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getWorkingTools() {
        return workingTools;
    }

    public void setWorkingTools(List<String> workingTools) {
        this.workingTools = workingTools;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getName().equals(employee.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", workingTools=" + workingTools +
                '}';
    }
}
