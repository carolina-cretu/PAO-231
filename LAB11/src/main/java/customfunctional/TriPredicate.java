package customfunctional;

/**
 * @author Carolina Cretu
 */
// un TriPredicate acdepta trei tipuri si intoarce un boolean
@FunctionalInterface
public interface TriPredicate<T, U, V> {

    boolean test(T t, U u, V v);
}
