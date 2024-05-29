package customfunctional;

/**
 * @author Carolina Cretu
 */
public class MainCustomFunctional {


    // implementare pentru interfata noastra functionala
    public static void main(String[] args) {
        TriPredicate<String, Integer, Integer> theTest =
                (s, n, w) -> {
                    if (s.equals("Nothing beats escaping reality") && n > 2 && w < n) {
                        return true;
                    } else {
                        return false;
                    }
                };
        System.out.println("Trece testul? " + theTest.test("It's raining man", 2, 3));
        System.out.println("Trece testul? " + theTest.test("Nothing beats escaping reality", 99, 3));
    }
}
