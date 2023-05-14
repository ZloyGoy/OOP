package assignment4;

import java.util.Scanner;

/**
  * Moon class that extends HeavenlyBody.
  */

public class Moon extends HeavenlyBody {

  private int avgOrbitRadius;
  Scanner scanner = new Scanner(System.in, "UTF-8");

  /**
  * Moon constructor.
  */

  public Moon(String name, int avgRadius, int avgOrbitRadius) {
    super(name, avgRadius);
    setName(name);
    setRadius(avgOrbitRadius);
    setAvgOrbitRadius(avgOrbitRadius);
  }

  public int getAvgOrbitRadius() {
    return avgOrbitRadius;
  }

  /**
  * Conditions for user to put, with limits that catch back, if the input is not satisfied.
  */

  public void setAvgOrbitRadius(int newOrbit) {
    while (true) {
      try {
        if (newOrbit < 7000) {
          throw new IllegalArgumentException("Orbit radius has to be above 7000. Please enter new radius: ");
        } else if (newOrbit > 400000) {
          throw new IllegalArgumentException("Orbit radius has to be less than 4000000. Please enter new radius: ");
        } else {
          this.avgOrbitRadius = newOrbit;
          break;
        }
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter an integer.");
        newOrbit = scanner.nextInt();
        scanner.nextLine();
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        newOrbit = scanner.nextInt();
        scanner.nextLine();
      }
    }
  }

  public void addHeavenlyBody(HeavenlyBody hb) {

  }

  public void removeHeavenlyBody(int index) {

  }

  @Override
  public String toString() {
    return this.getName() + ":" + this.getRadius() + ":" + this.getAvgOrbitRadius();
  }
}