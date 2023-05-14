package monopoly;

/**
 * Represents a free tile that does nothing.
 */
public class Free extends Tile {

  public Free(Tile prevTile) {
    super(prevTile);
  }

  @Override
  public void visit(Player player) {

  }

  @Override
  public boolean buy(Player player) {
    return false;
  }

  @Override
  public String toString() {
    return "Free";
  }
}
