package assignment4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
  * Main.
  * the ui of what person types.
  * methods from userInterface.
  */

public class Main {
  
  FileHandling registry;

  public Main() {
    registry = new FileHandling("solarsystems.data");
  }

  /**
  * StartProgram.
  * starts the whole program.
  */

  public void startProgram() throws IOException {
    ArrayList<Star> stars;
    Scanner scanner = new Scanner(System.in, "UTF-8");
  
    try {
      FileHandling registry = new FileHandling("solarsystems.data");
      stars = registry.readFile();
    } catch (Exception e) {
      stars = new ArrayList<>();
    }
  
    UserInterface ui = new UserInterface(stars);

    boolean run = true;
    do {
      System.out.println("\n==================================");
      System.out.println("||  ***   SOLAR SYSTEM   ***   ||");
      System.out.println("==================================");
      System.out.println("\nSELECT 1 - 7 ");
      System.out.println("1 SELECT SOLAR SYSTEM");
      System.out.println("2 ADD BODY");
      System.out.println("3 REMOVE BODY");
      System.out.println("4 LIST SYSTEMS");
      System.out.println("5 SORT BY SIZE");
      System.out.println("6 SORT BY ORBITAL SIZE");
      System.out.println("7 QUIT AND SAVE");

      try {
        int choice = scanner.nextInt();
        switch (choice) {
          case 1:
            ui.selectBody();
            break;
          case 2:
            ui.addBody();
            break;
          case 3:
            ui.removeBody();
            break;
          case 4:
            ui.printBody();
            break;
          case 5:
            ui.sortByRadius();
            break;
          case 6:
            ui.sortByOrbitalRadius();
            break;
          case 7:
            try {
              registry.writeFile(ui.getBodies());
            } catch (Exception e) {
              // catch block
            }
            run = false;
            break;

          default:
            System.out.println("Select between 1-7");
        } 
      } catch (InputMismatchException e) {
        System.out.println("Make sure you entered an integer!");
      }   
    } while (run);
  }
}
