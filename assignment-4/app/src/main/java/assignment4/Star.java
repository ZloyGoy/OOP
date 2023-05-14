package assignment4;

import java.util.ArrayList;
import java.util.List;

/**
  * Star class that extends HeavenlyBody.
  */

public class Star extends HeavenlyBody {

  ArrayList<Planet> arrPlanet = new ArrayList<Planet>();

  /**
  * Constructor for star. 
  */

  public Star(String name, int avgRadius) {
    super(name, avgRadius);
    setName(name);
    arrPlanet = new ArrayList<Planet>();
  }

  public void addPlanet(Planet planet) {
    this.arrPlanet.add(planet);
  }

  protected List<Planet> getPlanets() {
    return arrPlanet;
  }


  /**
  * Checks whether it is an instance of Planet. 
  * If it is, it casts the HeavenlyBody object to a Planet object and adds it to the arrPlanet list.
  */

  public void addHeavenlyBody(HeavenlyBody hb) {
    if (hb instanceof Planet) {
      this.arrPlanet.add((Planet) hb);
    }
  }

  public void removeHeavenlyBody(int index) {
    this.arrPlanet.remove(index);
  }

  @Override
  public String toString() {
    return this.getName() + ":" + this.getRadius();
  }
}
