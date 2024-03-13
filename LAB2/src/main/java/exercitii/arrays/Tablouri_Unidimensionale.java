package exercitii.arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Carolina Cretu
 */
public class Tablouri_Unidimensionale {


    //declarare
    int[] array; // forma cea mai folosita (mai usor de citit)
    float array2[] = new float[2]; // declarare corecta, dar mai greu de urmarit + initializare pe aceeasi linie
    boolean[] a, b; //  declarare pe aceeasi linie
    int c[], d[]; // similar

    String[] e; // declarare pe linie separata
    Object[] f; // declarare pe linie separata


    //initializare

    public void initializeAndLoopArrays() {
        int[] array3 = new int[3]; //aloca spatiu in memorie pentru 3 valori de tip int

        float arrayFloat[] = new float[2];
        arrayFloat[0] = 12.1f; //accessare folosind index, numerotare de la zero
        arrayFloat[1] = 11f;


        //for loop
        for (int i = 0; i < array3.length; i++) {
            System.out.println(array3[i]);
        }

        //for each loop
        for (int value : array3) {
            System.out.println(value);
        }

        System.out.println("Length: " + array3.length);      //lungimea alocata array ului => 3

        int[] emptyArray = new int[4];
        Object[] emptyObjectArray = new Object[4];
        System.out.println("Length: " + emptyArray.length);     // => 4
        System.out.println("Not initialised value for int array, index 0:" + emptyArray[0]);  // => valoare default: 0 pentru int
        System.out.println("Not intialised value for object array, index 0:" + emptyObjectArray[0]); // => valoare default: null pentru obiecte

    }

    public Integer[] initializeIntArray() {
        Integer[] ints = new Integer[10];

        System.out.println("Initialise array:"); // initializare cu numere random
        Random random = new Random();
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(10);
            System.out.print(ints[i] + " ");
        }
        return ints; // intoarcem array ul
    }

    private void sortIntArray(Integer[] integerArray) {
        Arrays.sort(integerArray);      //java.util.Arrays -> metode utile pentru manipulare array uri
        System.out.println("\n" + "Sorted array:"); // linie noua + Stringul "Sorted array:"
        for (int i = 0; i < integerArray.length; i++) {
            System.out.print(integerArray[i] + " ");
        }
    }

    public static void main(String[] args) {
        // array = new int[3]; // eroare de compilare... oare de ce ?
        Tablouri_Unidimensionale tu = new Tablouri_Unidimensionale();
        Integer[] ints = tu.initializeIntArray(); // initializam un array intr-un obiect array
        tu.sortIntArray(ints); // il pasam ca parametru pentru iterare si afisare
    }
}
