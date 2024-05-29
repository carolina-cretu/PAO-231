package expresiilambda;

/**
 * @author Carolina Cretu
 */

//interfata functionala -> contine o singura metoda abstracta
@FunctionalInterface // nu este obligatoriu sa o declaram, dar ajuta sa stim sa nu adaugam cod si sa stricam interfata functionala
public interface AnimalTester {

    public boolean test(Dog d);
}
