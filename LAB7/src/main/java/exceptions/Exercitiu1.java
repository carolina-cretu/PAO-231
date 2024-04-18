package exceptions;

import java.util.List;

/**
 * @author Carolina Cretu
 */
public class Exercitiu1 {

    public static void main(String[] args) {

        try {
            thisAlwaysThrowsAnException();
        } catch (RuntimeException e) {
            System.out.println("First catch");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Second catch");
            e.printStackTrace();
        }

    }

    public static void thisAlwaysThrowsAnException() throws Exception {
        List<String> list = getList();
        if (list == null) {
            throw new Exception("List is null");
        }
        if (list.isEmpty()) {
            throw new RuntimeException("List is empty");
        }
    }

    private static List<String> getList() {
        return null;
    }
}
