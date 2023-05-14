package monopoly;


/**
 * Represents a property tile that can be bought by a player.
 */
public class Property extends Tile {
  String name;
  Player owner;
  int price = 200;
  int rent = 300;

  /**
   * Creates a new property object with a name.
   */
  public Property(Tile prevTile, String name) {
    super(prevTile);
    this.name = name;
  }

  @Override
  public String toString() {
    String owner = this.owner == null ? "none" : this.owner.getName();
    return name + " (" + owner + ")";
  }

  @Override
  public void visit(Player player) {
  }

  @Override
  public void stoppedOn(Player player) {
    super.stoppedOn(player);

    if (owner != null && owner != player) {
      owner.addFunds(player.payRent(getRent()));
    }
  }

  /**
   * Call to buy a property.
   */
  public boolean buy(Player player) {
    // Done
    // you can only buy a property if it is not owned by anyone
    boolean onTile = isOnTile(player);
    boolean noOwner = isOwner(null);

    if (onTile && noOwner) {
      boolean hasPayed = player.deduceFunds(getPrice());
      if (hasPayed) {
        setOwner(player);
        return true;
      }
    }
    return false;
  }

  /**
   * Just sets the player as the owner.
   */
  private void setOwner(Player player) {
    owner = player;
  }

  /**
   * Gets the cost of stopping on the property.
   */
  public int getRent() {
    return rent;
  }

  /**
   * Gets the name of the property.
   */
  public String getName() {
    return name;
  }

  /**
   * Checks if a particular player is the owner of the property.
   */
  public boolean isOwner(Player player) {
    return owner == player;
  }

  /**
   * Returns the price to buy the property.
   */
  public int getPrice() {
    return price;
  }
}
