package assignment4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
  * Planet class that extends HeavenlyBody and has moon array.
  */

public class Planet extends HeavenlyBody {
  Scanner scanner = new Scanner(System.in, "UTF-8");
  ArrayList<Moon> arrMoon = new ArrayList<Moon>();
  private int avgOrbitRadius;

  /**
  * Planet constructor.
  */

  public Planet(String name, int avgRadius, int avgOrbitRadius) {
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
        if (newOrbit < 10000) {
          throw new IllegalArgumentException("Orbit radius has to be above 10000. Please enter new radius: ");
        } else if (newOrbit > 2500000) {
          throw new IllegalArgumentException("Orbit radius has to be less than 2500000. Please enter new radius:");
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

  public void addMoon(Moon moon) {
    this.arrMoon.add(moon);
  }
    
  protected List<Moon> getMoons() {
    return arrMoon;
  }

  /**
  * Checks whether it is an instance of Moon. 
  * If it is, it casts the HeavenlyBody object to a Moon object and adds it to the arrMoon list.
  */

  public void addHeavenlyBody(HeavenlyBody hb) {
    if (hb instanceof Moon) {
      this.arrMoon.add((Moon) hb);
    }
  }

  public void removeHeavenlyBody(int index) {
    this.arrMoon.remove(index);
  }
    
  @Override
  public String toString() {
    return this.getName() + ":" + this.getRadius() + ":" + this.getAvgOrbitRadius();
  }
}
