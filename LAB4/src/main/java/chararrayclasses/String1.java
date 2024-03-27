package chararrayclasses;

/**
 * @author Carolina Cretu
 */
public class String1 {

    public static void main(String[] args) {
        // literal  String
        String s1 = "this is a string";
        System.out.println(s1);

        // folosinf operatorul new
        String s2 = new String("this is another string");
        System.out.println(s2);

        //iterate over string
        for (int i = 0; i < s1.length(); i++) {
            System.out.print(s1.charAt(i));
        }

        //s1.charAt(100);  //arunca StringIndexOutOfBoundsException
    }
}
