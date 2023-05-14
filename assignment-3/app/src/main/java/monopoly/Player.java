package monopoly;

/**
 * Interface to implement for all types of players.
 */
public interface Player {
  /**
   * Returns the funds of the player.
   */
  public int getFunds();

  /**
   * Returns the name of the player.
   */
  public String getName();

  /**
   * Handles the interaction when it is the players turn to perform some actions.
   * Should perform one and only one action per call as we want the possibility to show the game.
   * Return true as long as the player can perform an action.
   * The last thing to be done is to roll the dice and move, then you return false.
   */
  public boolean yourTurn(Dice d1, Dice d2);


  /**
   * Call to make the player pay rent for a specific property.
   * Funds should be decuced
   * returns the amount payed
   */
  public int payRent(int amount);

  /**
   * Call to deduce funds from the player. For example when buying a property.
   * Changes should be reported to the ui.
   */
  public boolean deduceFunds(int cost);

  /**
   * Call to add funds to a player for example when passing the start tile.
   * Changes should be reported to the ui.
   */
  public void addFunds(int amount);
}
