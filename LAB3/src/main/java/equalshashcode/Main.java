package equalshashcode;

import equalshashcode.symmetryviolation.Money;
import equalshashcode.symmetryviolation.Voucher;

/**
 * @author Carolina Cretu
 */
public class Main {

    public static void main(String[] args) {
        Money m1 = new Money(45, "EUR");
        Money m2 = new Money(45, "EUR");
        System.out.println(m1.equals(m2));
        System.out.println("---------------------->");

        Money cash = new Money(42, "USD");
        Voucher voucher = new Voucher(42, "USD", "Amazon");

        System.out.println("voucher equals cash: " + voucher.equals(cash)); //=> false corect
        System.out.println("cash equals voucher: " + cash.equals(voucher));//=>true // incorect, incalcarea simetriei equals
    }
}
