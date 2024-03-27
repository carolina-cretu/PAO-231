package chararrayclasses;

/**
 * @author Carolina Cretu
 */
public class StringBuilder1 {

    public static void main(String[] args) {
        String s1 = "fdkjf";
        StringBuilder sb = new StringBuilder(s1);
        sb.append("A journey of a thousand miles ");
        sb.append("begins with a single step");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        sb.setCharAt(2, 'c');
    }
}
