package exercitii.blocurideinitializare;

/**
 * @author Carolina Cretu
 */
public class Student {
    private int varsta;
    private static String nationalitate;
    private static Integer nrStudenti = 0;


    // blocurile statice se executa o singura data, cand clasa este incarcata de JVM
    static {
        System.out.println("In bloc static");
        nationalitate = "romana";
    }

    // blocurile de instanta se executa de fiecare data cand se cheama constructorul, inaintea acestuia
    {
        System.out.println("In bloc nonstatic");
        nrStudenti = ++nrStudenti;
    }


    public Student(int varsta) {
        this.varsta = varsta;
        System.out.println("In constructorul cu parametru");
    }


    public Student() {
        System.out.println("In constructorul fara parametru");
    }



    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public static String getNationalitate() {
        return nationalitate;
    }

    public static void setNationalitate(String nationalitate) {
        Student.nationalitate = nationalitate;
    }

    public static Integer getNrStudenti() {
        return nrStudenti;
    }

    public static void setNrStudenti(Integer nrStudenti) {
        Student.nrStudenti = nrStudenti;
    }

    @Override
    public String toString() {
        return "Student{" +
                "varsta=" + varsta +
                '}';
    }
}
