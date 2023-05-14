/*
 * This Java source file was generated by the Gradle 'init' task.
 */

package assignmenttwo;

import assignmenttwo.solarsystem.HeavenlyBody;
import assignmenttwo.solarsystem.Moon;
import assignmenttwo.solarsystem.Planet;
import assignmenttwo.solarsystem.Star;
import java.util.Arrays;


/**
 * This is the generated Hello World Greeting App.
 */
public class App {

  private void sunPlanetMoon() {
    System.out.println("Stars: ");
    assignmenttwo.solitares.Star sun = new assignmenttwo.solitares.Star("Sun", 696342);
    System.out.println(sun);

    System.out.println("\nPlanets:");
    assignmenttwo.solitares.Planet p2 = new assignmenttwo.solitares.Planet("Mercury", 2439);
    System.out.println(p2);
    assignmenttwo.solitares.Planet p3 = new assignmenttwo.solitares.Planet("Venus", 6051);
    System.out.println(p3);
    assignmenttwo.solitares.Planet p4 = new assignmenttwo.solitares.Planet("Earth", 6371);
    System.out.println(p4);
    assignmenttwo.solitares.Planet p5 = new assignmenttwo.solitares.Planet("Mars", 3389);
    System.out.println(p5);
    assignmenttwo.solitares.Planet p6 = new assignmenttwo.solitares.Planet("Jupiter", 69911);
    System.out.println(p6);
    assignmenttwo.solitares.Planet p7 = new assignmenttwo.solitares.Planet("Saturn", 58232);
    System.out.println(p7);
    assignmenttwo.solitares.Planet p8 = new assignmenttwo.solitares.Planet("Uranus", 25362);
    System.out.println(p8);
    assignmenttwo.solitares.Planet p9 = new assignmenttwo.solitares.Planet("Neptune", 24622);
    System.out.println(p9);


    System.out.println("\nMoons:");
    assignmenttwo.solitares.Moon m1 = new assignmenttwo.solitares.Moon("Moon", 1737);
    System.out.println(m1);
    assignmenttwo.solitares.Moon m2 = new assignmenttwo.solitares.Moon("Phobos", 12);
    System.out.println(m2);
    assignmenttwo.solitares.Moon m3 = new assignmenttwo.solitares.Moon("Io", 1821);
    System.out.println(m3);
    assignmenttwo.solitares.Moon m4 = new assignmenttwo.solitares.Moon("Europa", 1560);
    System.out.println(m4);
    assignmenttwo.solitares.Moon m5 = new assignmenttwo.solitares.Moon("Ganymde", 2634);
    System.out.println(m5);
    assignmenttwo.solitares.Moon m6 = new assignmenttwo.solitares.Moon("Callisto", 2410);
    System.out.println(m6);
    assignmenttwo.solitares.Moon m7 = new assignmenttwo.solitares.Moon("Mimas", 198);
    System.out.println(m7);
    assignmenttwo.solitares.Moon m8 = new assignmenttwo.solitares.Moon("Enceladus", 252);
    System.out.println(m8);
    assignmenttwo.solitares.Moon m9 = new assignmenttwo.solitares.Moon("Tethys", 533);
    System.out.println(m9);
    assignmenttwo.solitares.Moon m10 = new assignmenttwo.solitares.Moon("Dione", 561);
    System.out.println(m10);
    assignmenttwo.solitares.Moon m11 = new assignmenttwo.solitares.Moon("Rhea", 7764);
    System.out.println(m11);
    assignmenttwo.solitares.Moon m12 = new assignmenttwo.solitares.Moon("Titan", 2575);
    System.out.println(m12);

  }

  private void heavenlyBody() {
    System.out.println("Stars: ");
    assignmenttwo.refactoredsolitares.Star sun = new assignmenttwo.refactoredsolitares.Star("Sun", 696342);
    System.out.println(sun);

    System.out.println("\nPlanets:");
    assignmenttwo.refactoredsolitares.Planet p2 = new assignmenttwo.refactoredsolitares.Planet("Mercury", 2439);
    System.out.println(p2);
    assignmenttwo.refactoredsolitares.Planet p3 = new assignmenttwo.refactoredsolitares.Planet("Venus", 6051);
    System.out.println(p3);
    assignmenttwo.refactoredsolitares.Planet p4 = new assignmenttwo.refactoredsolitares.Planet("Earth", 6371);
    System.out.println(p4);
    assignmenttwo.refactoredsolitares.Planet p5 = new assignmenttwo.refactoredsolitares.Planet("Mars", 3389);
    System.out.println(p5);
    assignmenttwo.refactoredsolitares.Planet p6 = new assignmenttwo.refactoredsolitares.Planet("Jupiter", 69911);
    System.out.println(p6);
    assignmenttwo.refactoredsolitares.Planet p7 = new assignmenttwo.refactoredsolitares.Planet("Saturn", 58232);
    System.out.println(p7);
    assignmenttwo.refactoredsolitares.Planet p8 = new assignmenttwo.refactoredsolitares.Planet("Uranus", 25362);
    System.out.println(p8);
    assignmenttwo.refactoredsolitares.Planet p9 = new assignmenttwo.refactoredsolitares.Planet("Neptune", 24622);
    System.out.println(p9);

    
    System.out.println("\nMoons:");
    assignmenttwo.refactoredsolitares.Moon m1 = new assignmenttwo.refactoredsolitares.Moon("Moon", 1737);
    System.out.println(m1);
    assignmenttwo.refactoredsolitares.Moon m2 = new assignmenttwo.refactoredsolitares.Moon("Phobos", 12);
    System.out.println(m2);
    assignmenttwo.refactoredsolitares.Moon m3 = new assignmenttwo.refactoredsolitares.Moon("Io", 1821);
    System.out.println(m3);
    assignmenttwo.refactoredsolitares.Moon m4 = new assignmenttwo.refactoredsolitares.Moon("Europa", 1560);
    System.out.println(m4);
    assignmenttwo.refactoredsolitares.Moon m5 = new assignmenttwo.refactoredsolitares.Moon("Ganymde", 2634);
    System.out.println(m5);
    assignmenttwo.refactoredsolitares.Moon m6 = new assignmenttwo.refactoredsolitares.Moon("Callisto", 2410);
    System.out.println(m6);
    assignmenttwo.refactoredsolitares.Moon m7 = new assignmenttwo.refactoredsolitares.Moon("Mimas", 198);
    System.out.println(m7);
    assignmenttwo.refactoredsolitares.Moon m8 = new assignmenttwo.refactoredsolitares.Moon("Enceladus", 252);
    System.out.println(m8);
    assignmenttwo.refactoredsolitares.Moon m9 = new assignmenttwo.refactoredsolitares.Moon("Tethys", 533);
    System.out.println(m9);
    assignmenttwo.refactoredsolitares.Moon m10 = new assignmenttwo.refactoredsolitares.Moon("Dione", 561);
    System.out.println(m10);
    assignmenttwo.refactoredsolitares.Moon m11 = new assignmenttwo.refactoredsolitares.Moon("Rhea", 7764);
    System.out.println(m11);
    assignmenttwo.refactoredsolitares.Moon m12 = new assignmenttwo.refactoredsolitares.Moon("Titan", 2575);
    System.out.println(m12);

  }

  private void solarSytem() {
    Star sun = new Star("Sun", 696342);
    Planet earth = sun.addPlanet("Earth", 6371, 63710);
    earth.addMoon("Moon", 1737, 17370);
    
    Planet mars = sun.addPlanet("Mars", 3389, 33890);
    mars.addMoon("Phobos", 12, 120);
    mars.addMoon("Deimos", 6, 60);

    Planet jupiter = sun.addPlanet("Jupiter", 69911, 699110);
    jupiter.addMoon("Io", 1821, 18210);
    jupiter.addMoon("Europa", 1560, 15600);
    jupiter.addMoon("Ganymede", 2634, 26340);
    jupiter.addMoon("Callisto", 2410, 24100);

    Planet saturn = sun.addPlanet("Saturn", 58232, 582320);
    saturn.addMoon("Mimas", 198, 1980);
    saturn.addMoon("Enceladus", 252, 2520);
    saturn.addMoon("Tethys", 533, 5330);
    saturn.addMoon("Dione", 561, 5610);
    saturn.addMoon("Rhea", 764, 7640);
    saturn.addMoon("Titan", 2575, 25750);


    System.out.println(sun);
  }

  private void orderInHeaven() {

    Star sun = new Star("Sun", 696342);
    Planet earth = sun.addPlanet("Earth", 6371, 63710);
    earth.addMoon("Moon", 1737, 17370);
    
    Planet mars = sun.addPlanet("Mars", 3389, 33890);
    mars.addMoon("Phobos", 12, 120);
    mars.addMoon("Deimos", 6, 60);

    Planet jupiter = sun.addPlanet("Jupiter", 69911, 699110);
    jupiter.addMoon("Io", 1821, 18210);
    jupiter.addMoon("Europa", 1560, 15600);
    jupiter.addMoon("Ganymede", 2634, 26340);
    jupiter.addMoon("Callisto", 2410, 24100);

    Planet saturn = sun.addPlanet("Saturn", 58232, 582320);
    saturn.addMoon("Mimas", 198, 1980);
    saturn.addMoon("Enceladus", 252, 2520);
    saturn.addMoon("Tethys", 533, 5330);
    saturn.addMoon("Dione", 561, 5610);
    saturn.addMoon("Rhea", 764, 7640);
    saturn.addMoon("Titan", 2575, 25750);

    HeavenlyBody[] solarSystem = sun.getHeavenlyBodies();
    Arrays.sort(solarSystem);
    for (HeavenlyBody i : solarSystem) {
      printHeavenlyBody(i); 
    }
  }

  private void printHeavenlyBody(HeavenlyBody arr) {
    System.out.println("Heavenly Body: " + arr.getName() + ", average radius " + arr.getAvgRadiusInKm() + "km");
  }

  /**
   * The App starting point.
   *
   * @param args Unused program arguments.
   */
  public static void main(String[] args) {
    App theApp = new App();
    //theApp.sunPlanetMoon();
    //theApp.heavenlyBody();
    theApp.solarSytem();
    //theApp.orderInHeaven();
  }
}