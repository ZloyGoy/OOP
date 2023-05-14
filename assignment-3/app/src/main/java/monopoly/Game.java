package monopoly;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class for running the actual game.
 */
public class Game {
  private Board board;
  private ConsoleUi ui;
  private ArrayList<Player> players;
  private Dice d1;
  private Dice d2;

  Game() {
    board = new Board();
    ui = new ConsoleUi();
    Random r = new Random();
    d1 = new Dice(r);
    d2 = new Dice(r);
    players = new ArrayList<>();
  }

  private void play() {
    startGame();
    playGame();
    endGame();
  }

  private void endGame() {
    ui.gameOver(players);
  }

  private void playGame() {
    for (int round = 0; round < 10 && !gameOver(); round++) {
      for (Player currentPlayer : players) {
        boolean playerDone = false;
        do {
          playerDone = currentPlayer.yourTurn(d1, d2);
          ui.addGameState(board.getStartTile(), players);
          ui.printState();
        } while (!(playerDone && !d1.equals(d2)));
      }
    }
  }

  private boolean gameOver() {
    for (Player p : players) {
      if (p.getFunds() <= 0) {
        return true;
      }
    }

    return false;
  }

  private void startGame() {
    do {
      String playerName = ui.promptForNewPlayerName();
      if (playerName != null && playerName.length() > 0) {
        Player joined = new HumanPlayer(board.getStartTile(), playerName, ui);
        players.add(joined);
        ui.playerJoined(joined.getName());
      } else if (players.size() > 1) {
        // we have at least one player so we can start the game
        break;
      }
    } while (true);
    ui.printState();
    ui.addGameState(board.getStartTile(), players);
    ui.printState();
  }

  public static void main(String[] args) {
    Game g = new Game();
    g.play();
  }
}
