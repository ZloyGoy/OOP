package monopoly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Functionality to print the game state and player messages to the console,
 * also some console input helpers.
 */
public class ConsoleUi {
  StringBuffer messages = new StringBuffer();
  StringBuffer gameState = new StringBuffer();

  /**
   * Represents the actions a player can perform.
   */
  public enum Action {
    ROLL,
    BUY,
    None
  }

  /**
   * Adds a player movement message.
   */
  public void playerMoves(String name, int d1, int d2) {
    addMessage(name, " moves " + d1 + " + " + d2 + " steps");
  }

  /**
   * Adds a property bought message.
   */
  public void playerBuysProperty(String name, String propertyName) {
    addMessage(name, "bought " + propertyName);
  }

  /**
   * Adds a rent payment message.
   */
  public void playerPaysRentFor(String name, String propertyDesc, int rent) {
    addMessage(name, "Pays rent for: " + propertyDesc + "($" + rent + ")");
  }

  /**
   * Adds a funds deduced message.
   */
  public void playerFundsDeduced(String name, int cost) {
    addMessage(name, "funds deduced with " + cost);
  }

  /**
   * Adds an insufficient funds message for a player.
   */
  public void playerUnableToPay(String name, int cost) {
    addMessage(name, "not enough funds to pay " + cost);
  }

  /**
   * Adds a received funds message.
   */
  public void playerReceivedFunds(String name, int sum) {
    addMessage(name, "received $" + sum);
  }

  /**
   * Adds a joined message.
   */
  public void playerJoined(String name) {
    addMessage(name, "joined the game");
  }

  /**
   * Adds the whole game state to be drawn.
   */
  public void addGameState(Tile start, Iterable<Player> players) {
    Tile t = start;

    do {
      addTile(t, players);

      t = t.getNext();
    } while (t != start);
  }

  /**
   * Adds a game tile to the current game state.
   */
  private void addTile(Tile t, Iterable<Player> players) {
    StringBuffer tileStr = new StringBuffer();

    tileStr.append(addSpaces(30, t.toString()));

    for (Player p : players) {
      if (t.isOnTile(p)) {
        tileStr.append("\t");
        tileStr.append(getPlayerString(p));
      }
    }
    tileStr.append(System.lineSeparator());

    gameState.append(tileStr);
  }

  protected String getGameState() {
    return gameState.toString();
  }

  protected void clearGameState() {
    gameState = new StringBuffer();
  }

  private String addSpaces(int max, String str) {
    String ret = str;

    while (ret.length() < max) {
      ret = " " + ret;
    }

    return ret;
  }

  private void clearConsole() {
    for (int i = 0; i < 30; i++) {
      System.out.println();
    }
  }

  /**
   * Clears the console and prints the current game state and messages.
   * Finally clears the messages and game state.
   */
  public void printState() {
    clearConsole();

    System.out.println(getGameState());
    System.out.println(getMessages());
    clearMessages();
    clearGameState();
  }

  /**
   * Prompts for and returns a new players name.
   */
  public String promptForNewPlayerName() {
    System.out.print("Player name (empty when done): ");


    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, Charset.defaultCharset().name()));
      return reader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
      return "";
    }
  }

  /**
   * Represents the actions a player can perform.
   */
  public void gameOver(Iterable<Player> players) {
    System.out.println("Game Over");
    ArrayList<Player> orderedPlayers = new ArrayList<>();
    players.forEach(p -> orderedPlayers.add(p));

    orderedPlayers.sort((p1, p2) -> p2.getFunds() - p1.getFunds());

    for (Player p : orderedPlayers) {
      System.out.println(getPlayerString(p));
    }

  }

  private String getPlayerString(Player p) {
    return p.getName() + " ($" + p.getFunds() + "$)";
  }



  private void addMessage(String playerName, String msg) {
    if (messages.length() > 0) {
      messages.append(System.lineSeparator());
    }
    messages.append("\tPlayer " + playerName + ":" + msg);
  }

  /**
   * Prompts the user for some input.
   */
  public Action promptForAction(String playerName) {
    System.out.println("It is your turn: " + playerName);
    System.out.print("r to roll dice, b to buy property");

    int c;

    do {
      c = getInputChar();
    } while (!(c == 'r' || c == 'b'));

    switch (c) {
      case 'r': return Action.ROLL;
      case 'b': return Action.BUY;
      default: break;
    }

    return Action.None;
  }

  protected String getMessages() {
    return messages.toString();
  }

  protected void clearMessages() {
    messages = new StringBuffer();
  }

  private int getInputChar() {
    try {
      int c = System.in.read();
      while (c == '\r' || c == '\n') {
        c = System.in.read();
      }
      return c;
    } catch (java.io.IOException e) {
      System.out.println("" + e);
      return 0;
    }
  }

  public void startingGame() {
  }
}
