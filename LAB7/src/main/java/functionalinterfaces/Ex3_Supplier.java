package functionalinterfaces;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

/**
 * @author Carolina Cretu
 */
public class Ex3_Supplier {

    public boolean getAsBoolean() {
        BooleanSupplier booleanSupplier = () -> true;
        return booleanSupplier.getAsBoolean();
    }

    public double getAsDouble() {
        DoubleSupplier pi = () -> Math.PI;
        return pi.getAsDouble();
    }

    public int getAsInt() {
        IntSupplier maxInteger = () -> Integer.MAX_VALUE;
        return maxInteger.getAsInt();
    }

    public long getAsLong() {
        LongSupplier maxLongValue = () -> Long.MAX_VALUE;
        return maxLongValue.getAsLong();
    }

    public String asString(boolean empty) {
        Supplier<String> message = () -> {
            if (empty) {
                return "";
            } else {
                return "Get a string";
            }
        };
        return message.get();
    }
}
