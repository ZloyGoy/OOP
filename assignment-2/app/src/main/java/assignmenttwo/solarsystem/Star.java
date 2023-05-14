package assignmenttwo.solarsystem;

import java.util.ArrayList;

/**
 * Class Star methods with array, constructor with conditions and method to add planet.
 */

public class Star extends HeavenlyBody {

  ArrayList<Planet> planets = new ArrayList<Planet>();

  /**
 * Star constructor with conditions.
 */

  public Star(String name, int avgRadiusInKm) {
    super(name, avgRadiusInKm);
  }

  /**
 * addPlanet method that adds an object planet with parameters to the ArrayList.
 */

  public Planet addPlanet(String name, int avgRadiusInKm, double avgOrbitRadiusInKm) {
    Planet planet = new Planet(name, avgRadiusInKm, avgOrbitRadiusInKm);

    if (planet.getAvgRadiusInKm() > this.getAvgRadiusInKm() / 2) {
      throw new IllegalArgumentException("Moon cannot be half the size or larger than the planet.");
    }
    planets.add(planet);
    return planet;
  }

  /**
 *  getHeavenlyBodies method that gets the arraylist size and makes a unique copy.
 */


  public HeavenlyBody[] getHeavenlyBodies() {

    ArrayList<HeavenlyBody> planetlist = new ArrayList<>();
    Star starCopy = new Star(getName(), getAvgRadiusInKm());
    planetlist.add(starCopy);

    for (Planet planet : planets) {
      for (HeavenlyBody hb : planet.getHeavenlyBodies()) {
        planetlist.add(hb);
      }
    }
    HeavenlyBody[] copyAll = new HeavenlyBody[planetlist.size()];
    return planetlist.toArray(copyAll);
  }


  /**
 *  toString method, that prints out planets, moons from arraylist.
 *  source used: https://www.simplilearn.com/tutorials/java-tutorial/stringbuilder-in-java
 */

  public String toString() {
    StringBuilder sb = new StringBuilder("Star: " + this.getName() + ", " 
        + "average radius " + this.getAvgRadiusInKm() + "km\n");
    for (Planet planet : planets) {
      for (HeavenlyBody moon : planet.getHeavenlyBodies()) {
        sb.append("").append(moon).append("\n");
      }
    }
    return sb.toString();
  }
}