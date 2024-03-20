package equalshashcode;

import equalshashcode.symmetryviolation.Money;
/**
 * @author Carolina Cretu
 */
public class Voucher2 {


    private Money money;  //fix pentru incalcarea simetriei din equals prin mostenire; relatie de tip HAS-A (asociere)
    private String store;

    public Voucher2(Money money, String store) {
        this.money = money;
        this.store = store;
    }

    @Override
    public int hashCode() {
        return 31 * getMoney().hashCode() + getStore().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Voucher2))
            return false;
        Voucher2 other = (Voucher2) o;
        boolean moneyEquals = (this.getMoney() == null && other.getMoney() == null)
                || (this.getMoney() != null && this.getMoney().equals(other.getMoney()));
        boolean storeEquals = (this.getStore() == null && other.getStore() == null)
                || (this.getStore() != null && this.getStore().equals(other.getStore()));
        return moneyEquals && storeEquals;
    }

    @Override
    public String toString() {
        return "Voucher2{" +
                "money=" + money +
                ", store='" + store + '\'' +
                '}';
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }
}
