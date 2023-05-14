package monopoly;

import java.util.Random;

/**
 * Works as a six sided dice that you can roll and get the value from.
 */
public class Dice {
  Random rnd;
  private int value;

  @edu.umd.cs.findbugs.annotations.SuppressFBWarnings(value = "EI_EXPOSE_REP2", 
        justification = "We want to share the same random object in many dices so we get good randomization.")
  public Dice(Random r) {
    rnd = r;
    roll(); // it would be odd to have an unrolled dice
  }

  /**
   * rolls the dice returns a value between 1-6 also available via get value.
   */
  public int roll() {
    value = rnd.nextInt(6) + 1;
    return value;
  }

  /**
   * Returns the last rolled value.
   */
  public int getValue() {
    return value;
  }

  /**
   * Returns true if o is a Dice object with the same value.
   */
  @Override
  public boolean equals(Object o) {
    if (o instanceof Dice) {
      return value == ((Dice) o).value;
    } else {
      return super.equals(o);
    }
  }

  /**
   * Returns the hash code for the dice.
   * In java there is an invariant assumption that objects that return true on equals also return the same hashcode.
   * In the case of the dice the value can be used as the hash.
   * hashing is interesting in general and you can read more about it here: https://www.baeldung.com/java-hashcode
   */
  @Override
  public int hashCode() {

    return value;
  }

}
