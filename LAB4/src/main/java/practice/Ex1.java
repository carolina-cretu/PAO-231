package practice;

/**
 * @author Carolina Cretu
 */
public class Ex1 {

    /**
     * Write a Java program to compare two strings lexicographically, ignoring case differences.
     */

    public static void main(String[] args) {
        String s1 = "This is a string";
        String s2 = "This is a different string";

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        if (s1.equals(s2)) {
            System.out.println("Strings are equals");
        } else if (s1.compareTo(s2) < 0) {
            System.out.println("s1 < s2");
        } else {
            System.out.println("s1 > s2");
        }
    }
}
