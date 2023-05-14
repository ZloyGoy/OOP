package assignmenttwo.solarsystem;

/**
 * Class Moon methods, constructor with conditions.
 */
 
public class Moon extends HeavenlyBody {
  private double avgOrbitRadiusInKm;

  protected Moon(String name, int avgRadiusInKm, double avgOrbitRadiusInKm) {
    super(name, avgRadiusInKm);
    this.avgOrbitRadiusInKm = avgOrbitRadiusInKm;
    getAvgOrbitRadiusInKm();

  }

  /**
 * getAvgOrbitRadiusInKm method that returns double.
 */
  public double getAvgOrbitRadiusInKm() {
    if (avgOrbitRadiusInKm < 60) {
      throw new IllegalArgumentException("Mminimum orbit radius of a Moon is 60km.");
    }
    return avgOrbitRadiusInKm;
  }
  
  public String toString() {
    return "\t\tMoon: " + this.getName() + ", " + "average radius " + this.getAvgRadiusInKm() 
            + "km," + " average orbit radius " + this.getAvgOrbitRadiusInKm() + "km";
  }
}
