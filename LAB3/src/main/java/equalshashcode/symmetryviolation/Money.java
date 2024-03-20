package equalshashcode.symmetryviolation;

import java.util.Objects;

/**
 * @author Carolina Cretu
 */
public class Money {


    // exemplu de equals si hashCode
    int amount;
    String currencyCode;

    public Money(int amount, String currencyCode) {
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Money))
            return false;
        Money other = (Money)o;
        boolean currencyCodeEquals = (this.currencyCode == null && other.currencyCode == null)
                || (this.currencyCode != null && this.currencyCode.equals(other.currencyCode));
        return this.amount == other.amount && currencyCodeEquals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currencyCode);

/*       int hash = 30;
       int hashAmount = hash * amount;
       return hashAmount;*/


      //  return 1;
    }
}
