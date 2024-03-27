package association;

/**
 * @author Carolina Cretu
 */
public class Student {

    private String name;
    private String disciplina;


    public Student(String name, String disciplina) {
        this.name = name;
        this.disciplina = disciplina;
    }

    // getteri si setteri


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", disciplina='" + disciplina + '\'' +
                '}';
    }
}
