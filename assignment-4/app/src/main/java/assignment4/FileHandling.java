package assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

/**
   * Filehandling.
   * loads the file.
   * writes into file.
   */

public class FileHandling {

  private ArrayList<Star> bodies = new ArrayList<Star>();
  private File registry;

  public FileHandling(String filename) {
    registry = new File(filename);
  }
    

  /**
   * readFile method, reads the file and adds the contents into star arraylist.
   * Planets and moons included.
   */

  public ArrayList<Star> readFile() throws FileNotFoundException {
    ArrayList<Star> star = new ArrayList<Star>();
    Scanner scanner = new Scanner(registry, "UTF-8");
    Star currentStar = null;
    Planet currentPlanet = null;
  
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      int dashes = 0;
      while (line.charAt(dashes) == '-') {
        dashes++;
      }
  
      String[] parts = line.split(":");
      String name = parts[0].substring(dashes);
      int radius = Integer.parseInt(parts[1]);
  
      if (dashes == 0) {
        currentStar = new Star(name, radius);
        star.add(currentStar);
      } else if (dashes == 1) {
        currentPlanet = new Planet(name, radius, Integer.parseInt(parts[2]));
        currentStar.addHeavenlyBody(currentPlanet);;
      } else if (dashes == 2) {
        Moon moon = new Moon(name, radius, Integer.parseInt(parts[2]));
        currentPlanet.addMoon(moon);
      }
    }
    scanner.close();
    bodies = star;
    return star;
  }

  /**
  * Write methods, takes the star arraylist and stores the contents into file.
  * Files are being written with toString to keep the formatting.
  */

  public void writeFile(ArrayList<Star> arrList) throws IOException {
    try (FileWriter fw = new FileWriter(registry, StandardCharsets.UTF_8, false)) {
      for (var star : arrList) {
        fw.write(star.toString() + "\n");
        for (var planet : star.getPlanets()) {
          fw.write("-" + planet.toString() + "\n");
          for (var moon : planet.getMoons()) {
            fw.write("--" + moon.toString() + "\n");
          }
        }
      }
    }
  }

  public ArrayList<Star> getBodies() {
    return new ArrayList<Star>(bodies);
  }
}
