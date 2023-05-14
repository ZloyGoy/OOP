package assignmenttwo.refactoredsolitares;

/**
 * Star class extends to HeavenlyBody class.
 */

public class Star extends HeavenlyBody {

  /**
 * Star constructor with conditions.
 */

  public Star(String name, int avgRadiusInKm) {
    super(name, avgRadiusInKm);
  }
  
  public String toString() {
    return "\tStar: " + this.getName() + ", " + "average radius " + this.getAvgRadiusInKm() + "km";
  }
}
