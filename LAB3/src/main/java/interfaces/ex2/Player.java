package interfaces.ex2;

/**
 * @author Carolina Cretu
 */
public abstract class Player implements Upgradable {
    private int initialHp = 150;

  abstract Integer getHealth();

  boolean isHealthy (int hp) {
     return initialHp - hp > 0;
  }

   public int getInitialHp() {
      return initialHp;
   }
}
