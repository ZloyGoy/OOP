package monopoly;

/**
 * Constructs and holds the game tiles.
 * This could be expanded to hold the game cards etc.
 * You could subclass this one to create different boards,
 * different layouts, streets etc.
 */
public class Board {

  private Tile start;


  /**
   * Creates the tiles.
   */
  public Board() {

    String [] streets = {"Seven Sisters Road", "Abbey Road", null,
      "Brick Lane", "Carnaby Street", "Piccadilly", null,
      "Baker Street", "Bond Street", "Regent Street", null,
      "Old Compton Street", "Shaftesbury Avenue", "Kings Road", null,
      "Oxford Street", "Downing Street"};

    start = create(streets);
    
  }

  protected Tile create(String [] streets) {
    Tile start = new Start();
    Tile n = start;
    for (String streetName : streets) {
      if (streetName != null) {
        n = new Property(n, streetName);
      } else {
        n = new Free(n);
      }
    }

    return start;
  }


  public Tile getStartTile() {
    return start;
  }
}
