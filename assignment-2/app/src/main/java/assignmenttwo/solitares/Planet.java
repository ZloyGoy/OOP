package assignmenttwo.solitares;

/**
 * Planet class based on oop.
 */

public class Planet {

  private String name;
  private int avgRadiusInKm;

  /**
 * Planet class methods, constructors, setters and getters.
 */
  
  public Planet(String name, int avgRadiusInKm) {
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
    if (avgRadiusInKm < 2000 || avgRadiusInKm > 200000) {
      throw new IllegalArgumentException("Planets cannot be smaller than 2 000km and not larger than 200 000km.");
    } else {
      avgRadiusInKm = rad;
    }
  }
  
  @Override
  public String toString() {
    return "\tPlanet: " + this.getName() + ", " + "average radius " + this.getAvgRadiusInKm() + "km";
  }
}

