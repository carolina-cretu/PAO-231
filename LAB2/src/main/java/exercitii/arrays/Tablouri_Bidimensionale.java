package exercitii.arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Carolina Cretu
 */


//Un array multidimensional in Java este un array format din  array uri de lungimi diferite ca elemente. Mai este denumit si un array de array uri.
public class Tablouri_Bidimensionale {

    //declarare
    Integer[][] biIntArray; // tablou bidimensional ce tine obiecte de tip Integer; forma de declarare nu difera de taboul unidimensional
    double[] doubleBiDimensionalArray[]; //corect, dar greu de citit
    float[][] floatBiDimensionalArray = new float[3][]; // declarare si initializare prima dimensiune reprezentand lungimea array ului; am omis a doua dimensiune deoarece poate varia in lungime


    public void initializeMultidimensionalArrays() {
        floatBiDimensionalArray[0] = new float[]{1f, 2f}; //initializarea celei de a 2 a dimensiuni; nota, indexul este al primei dimnesiuni !
        floatBiDimensionalArray[1] = new float[]{2.5f}; //initializarea celei de a 2 a dimensiuni; nota, indexul este al primei dimnesiuni !
        floatBiDimensionalArray[2] = new float[]{10f, 20f, 3f}; //initializarea celei de a 2 a dimensiuni; nota, indexul este al primei dimnesiuni !
        // ------------------------------------------------------------------------------------------------------------------------------
        biIntArray = new Integer[2][];
        biIntArray[0] = new Integer[1]; // declarare lungime pentru a 2 a dimensiune; se poate initializa mai jos
        biIntArray[1] = new Integer[3]; // declarare lungime pentru a 2 a dimensiune; se poate initializa mai jos

        String[][] object2DArray = {{"one"}, {"two", "three"}}; // declarare si intializare array 2d intr-o singura linie
    }

    void initialize2DArray(int[][] multiDimensionalArray) {
        for (int[] array : multiDimensionalArray) {
            Arrays.fill(array, 2); // intializare cu valoarea 2 a tuturor elementelor
        }
    }


    void initializeElements(String[][] multiDimensionalArr) {
        Scanner sc = new Scanner(System.in); //luam input de la tastatura
        for (int outer = 0; outer < multiDimensionalArr.length; outer++) { // prima dimensiune
            for (int inner = 0; inner < multiDimensionalArr[outer].length; inner++) { // a 2 a dimensiune
                multiDimensionalArr[outer][inner] = sc.next();
            }
        }
    }

    void printElements(String[][] multiDimensionalArr) {
        for (int index = 0; index < multiDimensionalArr.length; index++) {
            System.out.println(Arrays.toString(multiDimensionalArr[index]));
        }
    }

    void printElements(int[][] multiDimensionalArr) {
        for (int index = 0; index < multiDimensionalArr.length; index++) {
            System.out.println(Arrays.toString(multiDimensionalArr[index]));
        }
    }

    public static void main(String[] args) {
        String[][] exampleArray = new String[2][3];
        Tablouri_Bidimensionale tb = new Tablouri_Bidimensionale();
        tb.initializeElements(exampleArray);
        tb.printElements(exampleArray);

        int[][] example2Array = {{1, 7, 6}, {0}, {99, 1000, 5, 89, 11}};
        System.out.println("<-------------------->" + "\n");
        tb.printElements(example2Array);
    }
}
