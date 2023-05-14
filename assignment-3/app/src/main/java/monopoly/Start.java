package monopoly;

import java.util.ArrayList;

/**
 * Represents the start tile. Player receives funds when passing the tile.
 */
public class Start extends Tile {
  // we can use object as we are only interested in the existance of an object
  // we will not use the objects for anything
  private ArrayList<Object> passingPlayers = new ArrayList<>();

  @Override
  public void visit(Player player) {
    // players must pass the start tile to get the bonus,
    // i.e. this should not happen when the player leaves the tile on the first lap
    if (passingPlayers.contains(player)) {
      player.addFunds(200);
    } else {
      passingPlayers.add(player);
    }
  }

  @Override
  public String toString() {
    return "Start";
  }

  @Override
  public boolean buy(Player player) {
    return false;
  }
}
