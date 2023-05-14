package assignmenttwo.refactoredsolitares;

/**
  * HeavenlyBody abstract method that has constructors, setters, getters, toString.
  */

public abstract class HeavenlyBody {

  /*
  * HeavenlyBody class.
  */

  private String name;
  private int avgRadiusInKm;

  protected HeavenlyBody(String name, int avgRadiusInKm) {
    setName(name);
    setAvgRadiusInKm(avgRadiusInKm);
  }

  public String getName() {
    return name;
  }

  /**
  * setName with condition.
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

  @Override
  public String toString() {
    return "d";
  }
}
