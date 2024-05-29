package expresiilambda.operatori;

import java.util.function.UnaryOperator;

/**
 * @author Carolina Cretu
 */

// Operatorii sunt versiuni usor mdificate ale altor interfete functionale
public class MainOperators {

    public static void main(String[] args) {
        // accepta si intoarce acelasi tip T, spre deosebire de Function<T, R>, de aceea scrie doar un singur tip
        UnaryOperator<Double> log2 = v -> Math.log(v) / Math.log(2);
        System.out.println(log2.apply(8.0));
    }
}
