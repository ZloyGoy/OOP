package assignmenttwo.solitares;

/**
 * Moon class based on oop.
 */

public class Moon {

  private String name;
  private int avgRadiusInKm;

  /**
 * Moon class methods, constructors, setters and getters.
 */

  public Moon(String name, int avgRadiusInKm) {
    this.name = name;
    this.avgRadiusInKm = avgRadiusInKm;
    
    setName(this.name);
    setAvgRadiusInKm(this.avgRadiusInKm);
    toString();
  }

  public String getName() {
    return name;
  }

  private void setName(String newName) {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("Name cannot be empty or null.");
    } else {
      name = newName;
    }
  }

  public int getAvgRadiusInKm() {
    return avgRadiusInKm;
  }

  /**
  * setAvgRadiusInKm class with various conditions for different classes.
  */

  public void setAvgRadiusInKm(int rad) {
    if (avgRadiusInKm < 6 || avgRadiusInKm > 10000) {
      throw new IllegalArgumentException("Moons cannot be smaller than 6km and not larger than 10 000km.");
    } else {
      avgRadiusInKm = rad;
    }
  }

  @Override
  public String toString() {
    return "\tMoon: " + this.getName() + ", " + "average radius " + this.getAvgRadiusInKm() + "km";
  }
}
