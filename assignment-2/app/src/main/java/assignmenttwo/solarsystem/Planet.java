package assignmenttwo.solarsystem;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class Planet methods with array, constructor with conditions and method to add planet.
 */

public class Planet extends HeavenlyBody {

  private double avgOrbitRadiusInKm;
  ArrayList<Moon> moons = new ArrayList<Moon>();

  /**
 * Planet constructor with parameters.
 * Checks conditions for name, radius and orbit radius.
 */

  protected Planet(String name, int avgRadiusInKm, double avgOrbitRadiusInKm) {
    super(name, avgRadiusInKm);
    this.avgOrbitRadiusInKm = avgOrbitRadiusInKm;
    getAvgOrbitRadiusInKm();
    this.moons = new ArrayList<>();
  }

  /**
 * addMoon method that adds an object moon with parameters to the ArrayList.
 * Condititions check, if moon is half size of the planet.
 */

  public Moon addMoon(String name, int avgRadiusInKm, double avgOrbitRadiusInKm) {
    Moon moon = new Moon(name, avgRadiusInKm, avgOrbitRadiusInKm);

    if (moon.getAvgRadiusInKm() > this.getAvgRadiusInKm() / 2) {
      throw new IllegalArgumentException("Moon cannot be half the size or larger than the planet.");
    }
    moons.add(moon);
    return moon;
  }

  /**
 * getAvgOrbitRadiusInKm method that returns double.
 */

  public double getAvgOrbitRadiusInKm() {
    if (avgOrbitRadiusInKm < 18000) {
      throw new IllegalArgumentException("The minimum orbit radius of a Planet is 18 000km");
    }
    return avgOrbitRadiusInKm;
  }

  /**
 * getHeavenlyBodies method that gets the arraylist size and makes a unique copy.
 */

  public HeavenlyBody[] getHeavenlyBodies() {
    HeavenlyBody[] obj = new HeavenlyBody[moons.size() + 1];
    Planet copy = new Planet(getName(), avgRadiusInKm, avgOrbitRadiusInKm);
    obj[0] = copy;
    
    for (int i = 0; i < moons.size(); i++) {
      Moon moon = moons.get(i);
      Moon moonCopy = new Moon(moon.getName(), moon.getAvgRadiusInKm(), moon.getAvgOrbitRadiusInKm());
      obj[i + 1] = moonCopy;
    }
    return Arrays.copyOf(obj, obj.length);
  }

  public String toString() {
    return "\tPlanet: " + this.getName() + ", " + "average radius " + this.getAvgRadiusInKm() 
           + "km," + " average orbit radius " + getAvgOrbitRadiusInKm() + "km";
  }
}
