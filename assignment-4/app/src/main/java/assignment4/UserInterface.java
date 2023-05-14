package assignment4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
  * Filehandling.
  * loads the file.
  * writes into file.
  */

public class UserInterface {
  private ArrayList<Star> solarsystem = new ArrayList<Star>();
  private HeavenlyBody context = null;
  Scanner scanner = new Scanner(System.in, "UTF-8");
  FileHandling fh = new FileHandling("solarsystems.data");

  public UserInterface(ArrayList<Star> star) {
    this.solarsystem = new ArrayList<Star>(star);
  }

  /**
  * readFile method, reads the file and adds the contents into star arraylist.
  * Planets and moons included.
  */

  public void selectBody() {
    if (context == null) {
      int index = 0;
      if (solarsystem.isEmpty()) {
        System.out.println("\nNo solar systems to select");
        return;
      } else {
        for (Star starBody : solarsystem) {
          System.out.println("\n" + index++ + ". " + starBody.getName() + ":" + starBody.getRadius());
        }
        System.out.println("Please select: ");
        int num = scanner.nextInt();
        context = solarsystem.get(num);
      }
    } else {
      if (context instanceof Star) {
        int index = 1;
        var solarsystem = ((Star) context).getPlanets();
        if (solarsystem.isEmpty()) {
          System.out.println("No Planets");
          return;
        }
        for (var planet : solarsystem) {
          System.out.println(index++ + ". " + planet.getName() + ":" + planet.getRadius() 
                            + ":" + planet.getAvgOrbitRadius());
        }
        System.out.println("Select planet or 0 to return to solar system");
        int num = scanner.nextInt();
        scanner.nextLine();
        if (num == 0) {
          context = null;
        } else {
          context = solarsystem.get(num - 1);
        }
      } else if (context instanceof Planet) {
        int index = 1;
        var moons = ((Planet) context).getMoons();
        if (moons.isEmpty()) {
          System.out.println("No Moons");
          return;
        }
        for (var moon : moons) {
          System.out.println(index++ + ". " + moon.getName() + ":" + moon.getRadius() + ":" + moon.getAvgOrbitRadius());
        }
        System.out.println("Select moon or 0 to return to solar system");
        int num = scanner.nextInt();
        scanner.nextLine();
        if (num == 0) {
          context = null;
        } else {
          context = moons.get(num - 1);
        }
      } else if (context instanceof Moon) {
        context = null;
      }
    }
  }

  

  /**
   * readFile method, reads the file and adds the contents into star arraylist.
   * Planets and moons included.
   */

  public void addBody() {
    Scanner scanBody = new Scanner(System.in, "UTF-8");
    if (context == null) {
      while (true) {
        System.out.println("Enter star name: ");
        String starName = scanBody.nextLine();
        System.out.println("Enter star radius: ");
        int starRadius = scanBody.nextInt();
        scanBody.nextLine();
        solarsystem.add(new Star(starName, starRadius));
        System.out.println("You successfully added: \n" + starName + ":" + starRadius);
        break; // exit the loop when finished
      }
    } else {
      if (context instanceof Star) {
  
        while (true) {
          final var planet = ((Star) context).getPlanets();
          System.out.println("Planet name: ");
          final String planetName = scanBody.nextLine();
          System.out.println("Planet radius: ");
          final int planetRadius = scanBody.nextInt();
          scanBody.nextLine();
          System.out.println("Planet orbit radius: ");
          final int planetOrbit = scanBody.nextInt();
          scanBody.nextLine();
          Planet p = new Planet(planetName, planetRadius, planetOrbit);
          planet.add(p);
          System.out.println("You successfully added: \n" + planetName + ":" + planetRadius + ":" + planetOrbit);
          System.out.println("Do you want to add another planet? (Y/N)");
          String answer = scanBody.nextLine();
          if (answer.equalsIgnoreCase("N")) {
            break;
          }
        }
      }
      if (context instanceof Planet) {
        while (true) {
          final var moon = ((Planet) context).getMoons();
          System.out.println("Moon name: ");
          final String moonName = scanBody.nextLine();
          System.out.println("Moon radius: ");
          final int moonRadius = scanBody.nextInt();
          scanBody.nextLine();
          System.out.println("Moon orbit radius: ");
          final int moonOrbit = scanBody.nextInt();
          scanBody.nextLine();
          Moon m = new Moon(moonName, moonRadius, moonOrbit);
          moon.add(m);
          System.out.println("You successfully added: \n" + moonName + ":" + moonRadius + ":" + moonOrbit);
          System.out.println("Do you want to add another moon? (Y/N)");
          String answer = scanBody.nextLine();
          if (answer.equalsIgnoreCase("N")) {
            break;
          }
        }
      }   
    }
  }
  
  /**
   * readFile method, reads the file and adds the contents into star arraylist.
   * Planets and moons included.
   */

  public void removeBody() throws IOException {
    if (context == null) {
      int index = 0;
      if (solarsystem.isEmpty()) {
        System.out.println("\nThere is nothing to remove");
        return;
      }
      for (Star starBody : solarsystem) {
        System.out.println("\n" + index++ + ". " + starBody.getName() + ":" + starBody.getRadius());
      }
      System.out.println("Choose which system to remove ");
      int num = scanner.nextInt();
      solarsystem.remove(num);
      fh.writeFile(solarsystem);
    } else {
      if (context instanceof Star) {
        int index = 0;
        var solarsystem = ((Star) context).getPlanets();
        if (solarsystem.isEmpty()) {
          System.out.println("\nNo Systems to remove");
          return;
        }
        for (var planet : solarsystem) {
          System.out.println(index++ + ". " + planet.getName() + ":" + planet.getRadius() + ":" 
                            + planet.getAvgOrbitRadius());
        }
        System.out.println("Planet to remove: ");
        var num = scanner.nextInt();
        solarsystem.remove(num);
        fh.writeFile(this.solarsystem);
      }
      if (context instanceof Planet) {
        int index = 0;
        var solarsystem = ((Planet) context).getMoons();
        if (solarsystem.isEmpty()) {
          System.out.println("\nNo Moons to remove");
          return;
        }
        for (var moon : solarsystem) {
          System.out.println(index++ + ". " + moon.getName() + ":" + moon.getRadius() + ":" + moon.getAvgOrbitRadius());
        }
        System.out.println("Moon to remove: ");
        var num = scanner.nextInt();
        solarsystem.remove(num);
        fh.writeFile(this.solarsystem);
      }
    }
  }

  /**
   * readFile method, reads the file and adds the contents into star arraylist.
   * Planets and moons included.
   */

  public void printBody() {
    if (solarsystem.isEmpty()) {
      System.out.println("\nEmpty list");
      return;
    }

    for (Star starList : solarsystem) {
      System.out.println("\n" + starList);

      if (!starList.getPlanets().isEmpty()) {
        for (Planet planetList : starList.getPlanets()) {
          System.out.println("-" + planetList);
          if (!planetList.getMoons().isEmpty()) {
            for (Moon moonList : planetList.getMoons()) {
              System.out.println("--" + moonList);
            }
          } else {
            System.out.println("    No Moons");
          }
        }
      } else {
        System.out.println("  No Planets");
      }
    }
  }

  /**
   * readFile method, reads the file and adds the contents into star arraylist.
   * Planets and moons included.
   */

  public void sortByRadius() {
    if (solarsystem.isEmpty()) {
      System.out.println("\nEmpty list");
      return;
    }
  
    // Sort stars by radius size
    Collections.sort(solarsystem, new Comparator<Star>() {
      public int compare(Star s1, Star s2) {
        return Double.compare(s1.getRadius(), s2.getRadius());
      }
    });
    for (Star starList : solarsystem) {
      System.out.println("\n" + starList);
  
      // Sort planets by radius size
      if (!starList.getPlanets().isEmpty()) {
        Collections.sort(starList.getPlanets(), new Comparator<Planet>() {
          public int compare(Planet p1, Planet p2) {
            return Double.compare(p1.getRadius(), p2.getRadius());
          }
        });
        for (Planet planetList : starList.getPlanets()) {
          System.out.println("-" + planetList);
  
          // Sort moons by radius size
          if (!planetList.getMoons().isEmpty()) {
            Collections.sort(planetList.getMoons(), new Comparator<Moon>() {
              public int compare(Moon m1, Moon m2) {
                return Double.compare(m1.getRadius(), m2.getRadius());
              }
            });
            for (Moon moonList : planetList.getMoons()) {
              System.out.println("--" + moonList);
            }
          } else {
            System.out.println("    No Moons");
          }
        }
      } else {
        System.out.println("  No Planets");
      }
    }
  }

  /**
   * readFile method, reads the file and adds the contents into star arraylist.
   * Planets and moons included.
   */

  public void sortByOrbitalRadius() {
    if (solarsystem.isEmpty()) {
      System.out.println("\nEmpty list");
      return;
    }
  
    Collections.sort(solarsystem, new Comparator<Star>() {
      public int compare(Star s1, Star s2) {
        return Integer.compare(s1.getRadius(), s2.getRadius());
      }
    });
  
    for (Star starList : solarsystem) {
      System.out.println("\n" + starList);

      if (!starList.getPlanets().isEmpty()) {
        Collections.sort(starList.getPlanets(), new Comparator<Planet>() {
          public int compare(Planet p1, Planet p2) {
            return Integer.compare(p1.getAvgOrbitRadius(), p2.getAvgOrbitRadius());
          }
        });
        for (Planet planetList : starList.getPlanets()) {
          System.out.println("-" + planetList);

          if (!planetList.getMoons().isEmpty()) {
            Collections.sort(planetList.getMoons(), new Comparator<Moon>() {
              public int compare(Moon m1, Moon m2) {
                return Integer.compare(m1.getAvgOrbitRadius(), m2.getAvgOrbitRadius());
              }
            });
            for (Moon moonList : planetList.getMoons()) {
              System.out.println("--" + moonList);
            }
          } else {
            System.out.println(" No Moons");
          }
        }
      } else {
        System.out.println(" No Planets");
      }
    }
  } 

  public ArrayList<Star> getBodies() {
    return new ArrayList<Star>(solarsystem);
  }
}