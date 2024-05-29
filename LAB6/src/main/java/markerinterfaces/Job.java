package markerinterfaces;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Carolina Cretu
 */
public class Job {

    private String name;
    private BigDecimal salary;


    public Job(String name, BigDecimal salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getName().equals(job.getName()) && getSalary().equals(job.getSalary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSalary());
    }


    @Override
    public String toString() {
        return "Job{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
