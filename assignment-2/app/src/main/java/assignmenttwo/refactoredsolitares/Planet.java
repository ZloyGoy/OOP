package assignmenttwo.refactoredsolitares;

/**
 * Planet class with constructor extends to HeavenlyBody.
 */

public class Planet extends HeavenlyBody {

  /**
 * Planet constructor with conditions.
 */

  public Planet(String name, int avgRadiusInKm) {
    super(name, avgRadiusInKm);
  }

  public String toString() {
    return "\tPlanet: " + this.getName() + ", " + "average radius " + this.getAvgRadiusInKm() + "km";
  }
}
