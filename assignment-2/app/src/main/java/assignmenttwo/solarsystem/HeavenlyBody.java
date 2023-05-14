package assignmenttwo.solarsystem;

/**
 * Abstract class HeavenlyBody methods, constructor and conditions.
 */

public abstract class HeavenlyBody implements Comparable<HeavenlyBody> {

  /**
 * Setters, getters, constructor, method to check radius.
 */

  private String name;
  protected int avgRadiusInKm; 

  protected HeavenlyBody(String name, int avgRadiusInKm) {
    setName(name);
    setAvgRadiusInKm(avgRadiusInKm);
  }

  public String getName() {
    return name;
  }

  /**
  * setName class with canditions.
  */

  public void setName(String newName) {
    if (newName == null || newName.equals("")) {
      throw new IllegalArgumentException("Name cannot be empty or null.");
    }
    name = newName;
  }

  public int getAvgRadiusInKm() {
    return avgRadiusInKm;
  }

  /**
  * setAvgRadiusInKm class with various conditions for different classes.
  */

  public void setAvgRadiusInKm(int radius) {
    if (this instanceof Moon) {
      if (radius < 6 || radius > 10000) {
        throw new IllegalArgumentException("Moons cannot be smaller than 6km and not larger than 10 000km.");
      }
    } else if (this instanceof Planet) {
      if (radius < 2000 || radius > 200000) {
        throw new IllegalArgumentException("Planets cannot be smaller than 2 000km and not larger than 200 000km.");
      }
    } else if (this instanceof Star) {
      if (radius < 16700) {
        throw new IllegalArgumentException("Stars cannot be smaller than 16700km.");
      }
    } else {
      throw new IllegalStateException("Something went wrong.");
    }
    avgRadiusInKm = radius;
  }

  protected void checkAvgRadiusInKm(int radius) {

  }

  /**
 * CompareTo method from OrderInHeaven. 
 * Compare takes lists obj and compares based on a average radius in km.
 */

  public int compareTo(HeavenlyBody otherBody) {
    if (this.avgRadiusInKm < otherBody.avgRadiusInKm) {
      return -1;
    } else if (this.avgRadiusInKm > otherBody.avgRadiusInKm) {
      return 1;
    } else {
      return 0;
    }
  }

  @Override
  public String toString() {
    return "Heavenly Body: " + this.getName() + ", " + "average radius " + this.getAvgRadiusInKm() + "km";
  }
}
