package assignmenttwo.refactoredsolitares;

/**
 * Moon class with constructor that checks conditions.
 */

public class Moon extends HeavenlyBody {
  
  /**
 * Constructor which extends to heavenlybody.
 */

  public Moon(String name, int avgRadiusInKm) {
    super(name, avgRadiusInKm);
  }
    
  public String toString() {
    return "\tMoon: " + this.getName() + ", " + "average radius " + this.getAvgRadiusInKm() + "km";
  }
}
