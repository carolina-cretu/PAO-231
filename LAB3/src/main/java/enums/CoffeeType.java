package enums;

/**
 * @author Carolina Cretu
 */
public enum CoffeeType {
    ECUADOR("Select Ecuador"),
    ETIOPIA("Rich Etiopia"),
    BRAZIL("Intense Brazil"); // ; este obligatoriu cand urmeaza cod dupa constante

    private String name;

    CoffeeType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public CoffeeType getNextType(CoffeeType type) {
        for (CoffeeType ct : CoffeeType.values()) {
            if (ct.compareTo(type) > 0) {
                return ct;
            }
        }
        return null;
    }

}
