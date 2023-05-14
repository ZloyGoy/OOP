package monopoly;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

// These tests are to be uncommented for the passing grade
// preferably solve the tests in order
public class TierOneTests {

  // implement the constructor in Tile so that it sets the next and prev links to this
  @Test
  public void tileConstructionTest_1() {
    // implement the constructor in Tile so that it sets the next and prev links correctly
    DummyTile sut = new DummyTile();

    // (1) <- 1 -> (1)
    assertEquals(sut, sut.getNext(), "Link to next tile not set correctly");
    assertEquals(sut, sut.getPrev(), "Link to prev tile not set correctly.");

  }

  @Test
  public void tileConstructionTest_2() {
    // implement the constructor in Tile so that it sets the next and prev links correctly
    DummyTile sut1 = new DummyTile();
    DummyTile sut2 = new DummyTile(sut1);

    // the list should look like this
    // (2) <- 1 <-> 2 -> (1)
    assertEquals(sut2, sut1.getNext(), "Link to sut1 next tile not set correctly");
    assertEquals(sut2, sut1.getPrev(), "Link to sut1 prev tile not set correctly");
    assertEquals(sut1, sut2.getPrev(), "Link to sut2 prev tile not set correctly");
    assertEquals(sut1, sut2.getNext(), "Link to sut2 next tile not set correctly");
  }

  @Test
  public void tileConstructionTest_3() {
    // implement the constructor in Tile so that it sets the next and prev links correctly
    DummyTile sut1 = new DummyTile();
    DummyTile sut2 = new DummyTile(sut1);
    DummyTile sut3 = new DummyTile(sut2);

    // the list should look like this
    // (3) <- 1 <-> 2 <-> 3 -> (1)
    assertEquals(sut1, sut3.getNext(), "Link to sut3 next tile not set correctly");
    assertEquals(sut2, sut3.getPrev(), "Link to sut3 prev tile not set correctly");
    assertEquals(sut1, sut2.getPrev(), "Link to sut2 prev tile not set correctly");
  }

  @Test
  public void tileConstructionTest_4() {
    // implement the constructor in Tile so that it sets the next and prev links correctly
    DummyTile sut1 = new DummyTile();
    DummyTile sut2 = new DummyTile(sut1);
    DummyTile sut3 = new DummyTile(sut1);

    // (2) <- 1 <-> 3 <-> 2 -> (1)
    assertEquals(sut2, sut3.getNext(), "Link to sut3 next tile not set correctly");
    assertEquals(sut1, sut3.getPrev(), "Link to sut3 prev tile not set correctly");
    assertEquals(sut3, sut1.getNext(), "Link to sut1 prev tile not set correctly");
    assertEquals(sut2, sut1.getPrev(), "Link to sut1 prev tile not set correctly");
    assertEquals(sut3, sut2.getPrev(), "Link to sut2 prev tile not set correctly");
    assertEquals(sut1, sut2.getNext(), "Link to sut2 prev tile not set correctly");
  }

  @Test
  public void tileConstructionTest_5() {
    // implement the constructor in Tile so that it sets the next and prev links correctly
    DummyTile sut1 = new DummyTile();
    DummyTile sut2 = new DummyTile(sut1);
    DummyTile sut3 = new DummyTile(sut1);
    DummyTile sut4 = new DummyTile(sut1);

    // (2) <- 1 <-> 4 <-> 3 <-> 2 -> (1)
    assertEquals(sut2, sut1.getPrev(), "Link to sut1 prev tile not set correctly");
    assertEquals(sut2, sut3.getNext(), "Link to sut3 next tile not set correctly");
    assertEquals(sut1, sut2.getNext(), "Link to sut2 next tile not set correctly");
    assertEquals(sut1, sut4.getPrev(), "Link to sut4 prev tile not set correctly");
    assertEquals(sut3, sut2.getPrev(), "Link to sut2 prev tile not set correctly");
    assertEquals(sut3, sut4.getNext(), "Link to sut4 prev tile not set correctly");
    assertEquals(sut4, sut1.getNext(), "Link to sut1 next tile not set correctly");
    assertEquals(sut4, sut3.getPrev(), "Link to sut3 prev tile not set correctly");
  }

  @Test
  public void tileConstructiontest_6() {
    DummyTile start = new DummyTile();
    ArrayList<Tile> tiles = new ArrayList<>();
    int nodeCount = 15 + 1;

    Tile n = start;
    tiles.add(n);
    for (int i = 0; i < nodeCount; i++) {
      Tile nNew = new DummyTile(n);
      tiles.add(nNew);

      assertEquals(tiles.get(tiles.size() - 1), start.getPrev(), "start.prev does not link to the last tile after adding tile no: " + i);
      assertEquals(tiles.get(1), start.getNext(), "start.next does not link to tile no 1 after adding tile no: " + i);

      assertEquals(start, nNew.getNext(), "tile" + i + ".next is not correctly set to start");
      assertEquals(n, nNew.getPrev(), "tile" + i + ".prev is not correctly set to tile" + (i - 1));

      n = nNew;
    }
  }


  @Test
  public void propertyTest_buy_ok() {
    // implement the Property buy operation according to the Design document sequence diagram
    Start s = new Start();
    final String streetName = "Downing Street";
    Property sut = new Property(s, streetName);

    DummyPlayer p = new DummyPlayer(sut, "Dummy Player");
    int originalFunds = p.getFunds();

    boolean ret = sut.buy(p);

    assertEquals(true, sut.isOwner(p), "Property owner not correct set");
    assertEquals(originalFunds - sut.getPrice(), p.getFunds(), "Funds not correctly deduced");
    assertEquals(true, ret, "buy should return true if the property is bought");
  }

  @Test
  public void propertyTest_buy_hasOwner() {
    // implement the Property buy operation according to the Design document sequence diagram
    Start s = new Start();
    final String streetName = "Downing Street";
    Property sut = new Property(s, streetName);

    DummyPlayer p = new DummyPlayer(sut, "Dummy Player");
    DummyPlayer someOtherPlayer = new DummyPlayer(sut, "Someone else");

    sut.buy(someOtherPlayer);

    int originalFunds = p.getFunds();

    boolean ret = sut.buy(p);

    
    assertEquals(true, sut.isOwner(someOtherPlayer), "Property owner should not change");
    assertEquals(false, sut.isOwner(p), "Property owner should not change");

    assertEquals(originalFunds, p.getFunds(), "Funds should not be deduced");
    assertEquals(false, ret, "buy should return false if the property is not bought");
  }

  @Test
  public void propertyTest_buy_notOnTile() {
    // implement the Property buy operation according to the Design document sequence diagram
    Start s = new Start();
    final String streetName = "Downing Street";
    Property sut = new Property(s, streetName);

    DummyPlayer p = new DummyPlayer(s, "Dummy Player");
    int originalFunds = p.getFunds();

    boolean ret = sut.buy(p);

    assertEquals(false, sut.isOwner(p), "Property owner should not be set");
    assertEquals(originalFunds, p.getFunds(), "Funds should not be deduced");
    assertEquals(false, ret, "buy should return false if the property is not bought");
  }

  @Test
  public void propertyTest_buy_noFunds() {
    // implement the Property buy operation according to the Design document sequence diagram
    Start s = new Start();
    final String streetName = "Downing Street";
    Property sut = new Property(s, streetName);

    DummyPlayer p = new DummyPlayer(sut, "Dummy Player");
    int originalFunds = p.getFunds();
    p.deduceFunds(originalFunds - 1);

    boolean ret = sut.buy(p);

    assertEquals(false, sut.isOwner(p), "Property owner should not be set");
    assertEquals(false, ret, "buy should return false if the property is not bought");
  }

  
  
  
  // These are some internal classes used to facilitate testing. You do not need to bother with them

  class DummyPlayer extends HumanPlayer {

    public DummyPlayer(Tile a_currentTile, String a_name) {
      super(a_currentTile, a_name, new ConsoleUi());
    }
  }

  class DummyTile extends Tile {

    DummyTile() {
      super();
    }

    DummyTile(Tile a_prev) {
      super(a_prev);
    }

    @Override
    public void startOn(Player player) {

    }

    @Override
    public void visit(Player player) {

    }

    @Override
    public void stoppedOn(Player player) {

    }

    @Override
    public boolean buy(Player player) {
      return false;
    }
  }

}
