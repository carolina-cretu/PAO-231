package lists;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Carolina Cretu
 */
public class MainLinkedList {

    public static void main(String[] args) {
        List<String> tools = new LinkedList<>();
        tools.add("ciocan");
        tools.add("cheie franceza");
        tools.add("flex");
        Employee emp1 = new Employee("Cristi Tabara", tools);

        System.out.println(emp1);
        System.out.println("Working tool element at index 0 is: " + emp1.getWorkingTools().get(0));
        tools.set(1, "bormasina");
        System.out.println(emp1);
    }
}
