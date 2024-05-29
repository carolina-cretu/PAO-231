package optionals;

import java.util.Objects;

/**
 * @author Carolina Cretu
 */
public class Readings {

    private int month;
    private int year;
    private double value;

    public Readings(int month, int year, double value) {
        this.month = month;
        this.year = year;
        this.value = value;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Readings)) return false;
        Readings readings = (Readings) o;
        return getMonth() == readings.getMonth() && getYear() == readings.getYear() && getValue() == readings.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMonth(), getYear(), getValue());
    }
}
