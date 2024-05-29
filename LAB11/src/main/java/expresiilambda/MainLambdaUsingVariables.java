package expresiilambda;

/**
 * @author Carolina Cretu
 */
public class MainLambdaUsingVariables {

    public static void main(String[] args) {
        int numDogs = 3; // effectively final
        //numBalls = 1; //numBalls declarat in scop; nu va compila codul daca decomentam linia asta, deoarece se considera redeclarare mai jos
        AnimalTester atWithDogs = d -> {
            int numBalls = 2;  // o variabila complet noua
            numBalls++; //putem sa o modificam
            //numDogs++; // nu compileaza daca decomentam; putem folosi valoarea, dar nu o putem schimba nici in lambda, nici in scop
            System.out.println("Numarul de mingi: " + numBalls); //putem accesa numBalls
            System.out.println("numarul de catei " + numDogs); // putem accesa numDogs
            return d.getAge() > 5;
        };

        DogsActivities da = new DogsActivities(atWithDogs);

        System.out.println("Are Max mai mult de 5 ani ? " + da.doTest(new Dog("Max", 7)));
    }
}
