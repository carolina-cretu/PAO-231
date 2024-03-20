package interfaces.ex2;

/**
 * @author Carolina Cretu
 */
public class OrcPlayer extends Player implements Magical {
    private int noOfDeaths;
    private int hp;

    private Origin myOrigin = Origin.ORC;


    public OrcPlayer(int noOfDeaths, int hp) {
        this.noOfDeaths = noOfDeaths;
        this.hp = hp;
    }

    @Override
    public String calculateDustOrigin(Origin origin) {

        return myOrigin == origin ? "Orcland" : "DarkLand";
    }

    @Override
    public boolean hasPowers() {
        return true;
    }

    @Override
    Integer getHealth() {
        return getInitialHp() - this.hp;
    }

    public int getNoOfDeaths() {
        return noOfDeaths;
    }

    public void setNoOfDeaths(int noOfDeaths) {
        this.noOfDeaths = noOfDeaths;
    }
}
