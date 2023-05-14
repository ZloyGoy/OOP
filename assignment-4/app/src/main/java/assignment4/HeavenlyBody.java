package assignment4;

import java.util.Scanner;

/**
   * Heavenlybody.
   * abstract class.
   */

public abstract class HeavenlyBody {
  private String name;
  private int avgRadius;
  Scanner scanner = new Scanner(System.in, "UTF-8");


  public HeavenlyBody(String name, int avgRadius) {
    this.name = name;
    this.avgRadius = avgRadius;
  }

  public String getName() {
    return name;
  }

  /**
  * Checking, if name is empty.
  */

  public void setName(String newName) {
    String input = newName.trim();
    while (input.isEmpty()) {
      System.out.println("Name cannot be empty. Please enter new name: ");
      input = scanner.nextLine().trim();
    }
    this.name = input;
  }


  public int getRadius() {
    return avgRadius;
  }

  /**
  * setRadius will throw excpetion if wrong radius inputted.
  */

  public void setRadius(int newRadius) {
    while (true) {
      try {
        if (newRadius < 1000) {
          throw new IllegalArgumentException("Radius has to be above 1000. Please enter new radius: ");
        } else if (newRadius > 100000) {
          throw new IllegalArgumentException("Radius has to be less than 100000. Please enter new radius:");
        } else {
          this.avgRadius = newRadius;
          break;
        }
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter an integer.");
        newRadius = scanner.nextInt();
        scanner.nextLine();
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        newRadius = scanner.nextInt();
        scanner.nextLine();
      }
    }
  }

  public abstract void addHeavenlyBody(HeavenlyBody hb);

  public abstract void removeHeavenlyBody(int hindex);

}
