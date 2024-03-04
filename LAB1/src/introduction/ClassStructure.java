package introduction;
/**
 * 'class' = cuvant cheie ce semnaleaza definitia unei clase
 * De obicei, clasa este definita intr-un fisier cu acelasi nume (insa nu intotdeauna)
 * Ex1_Structure = numele clasei
 * Reguli:
 * - nu poate incepe cu numere (dar poate contine numere)
 * - nu poate coincide cu cuvinte cheie (eg: 'package')
 * - nu poate contine spatii si caractere speciale (exceptie "$" si "_")
 * Conventii
 * - camel case
 * - incepe cu litera mare
 * - substantive
 * <p>
 * Clasele din Java sunt organizate in pachete.
 * Cuvantul cheie 'package' => de obicei pe prima linie, si defineste pachetul in care se afla clasa
 * Clasa HelloWorld nu are nici un package definit => este inclusa in pachetul implicit, numit "default"
 * Ca si buna practica, este bine sa denumim intotdeauna pachetele.
 * <p>
 * Pentru a folosi clase din alte pachete fata de cel curent => folosim cuvantul cheie import
 * Nu importam niciodata tot pachetul; importam fiecare clasa pe rand pentru a evita eventualele defecte ce pot aparea: daca pachetul A si pachetul B contin amandoua o clasa C si avem ambele pachete importate folosind wildcardul *, ce credeti ca se poate intampla ?
 * java.lang => pachet special din Java ce nu trebuie importat
 * (de exemplu, clasa System folosita pentru a printa mesaje in consola, face parte din acest pachet)
 */

import java.util.Random;
import java.util.random.RandomGenerator;

/**
 * @author Carolina Cretu
 */
public class ClassStructure {

    //reading input from args parameter
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }

    public void generateRandomInteger() {
        RandomGenerator randomGenerator = new Random();
        System.out.println("Random generated value is: " + randomGenerator);
    }
}
