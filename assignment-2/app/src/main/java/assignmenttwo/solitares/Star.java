package assignmenttwo.solitares;

/**
 * Star class based on oop.
 */

public class Star {
  
  private String name;
  private int avgRadiusInKm;

  /**
 * Star class methods, constructors, setters and getters.
 */

  public Star(String name, int avgRadiusInKm) {
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
    if (avgRadiusInKm < 16700) {
      throw new IllegalArgumentException("Stars cannot be smaller than 16 700km.");
    } else {
      avgRadiusInKm = rad;
    }
  }

  @Override
  public String toString() {
    return "\tStar: " + this.getName() + ", " + "average radius " + this.getAvgRadiusInKm() + "km";
  }
}
