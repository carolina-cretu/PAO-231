package immutable;

/**
 * @author Carolina Cretu
 */
public final class ImmutableStudent {

    private final int id;
    private final String name;
    private final Age age;

    public ImmutableStudent(int id, String name, Age age) {
        this.name = name;
        this.id = id;
        Age cloneAge = new Age();
        cloneAge.setDay(age.getDay());
        cloneAge.setMonth(age.getMonth());
        cloneAge.setYear(age.getYear());
        this.age = cloneAge;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Age getAge() {
        Age cloneAge = new Age();
        cloneAge.setDay(this.age.getDay());
        cloneAge.setMonth(this.age.getMonth());
        cloneAge.setYear(this.age.getYear());

        return cloneAge;
    }
}
