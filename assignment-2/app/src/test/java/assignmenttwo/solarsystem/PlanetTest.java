package assignmenttwo.solarsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class PlanetTest {

  @Test
  void testAddMoon_validInput() {
    Planet planet = new Planet("Test", 10000, 18000);
    Moon moon = planet.addMoon("TestMoon", 5000, 100);
    assertEquals("TestMoon", moon.getName());
    assertEquals(5000, moon.getAvgRadiusInKm());
    assertEquals(100, moon.getAvgOrbitRadiusInKm());
  }

  @Test
  void testPlanetConstructor_nullName() {
    assertThrows(IllegalArgumentException.class, () -> new Planet(null, 1000, 18000));
  }

  @Test
  void testPlanetConstructor_emptyName() {
    assertThrows(IllegalArgumentException.class, () -> new Planet("", 1000, 18000));
  }

  @Test
  void testPlanetConstructor_radiusTooSmall() {
    assertThrows(IllegalArgumentException.class, () -> new Planet("Test", 1999, 18000));
  }

  @Test
  void testPlanetConstructor_radiusTooLarge() {
    assertThrows(IllegalArgumentException.class, () -> new Planet("Test", 2000001, 18000));
  }

  @Test
  void testPlanetConstructor_orbitRadiusTooSmall() {
    assertThrows(IllegalArgumentException.class, () -> new Planet("Test", 10000, 17999));
  }

  @Test
  void testAddMoon_radiusTooLarge() {
    Planet planet = new Planet("Test", 10000, 18000);
    assertThrows(IllegalArgumentException.class, () -> planet.addMoon("TestMoon", 5001, 100));
  }

  @Test
  void testGetHeavenlyBodies_emptyList() {
    Planet planet = new Planet("Test", 10000, 18000);
    assertEquals(1, planet.getHeavenlyBodies().length);
  }

  @Test
  void testGetHeavenlyBodies_populatedList() {
    final Planet planet = new Planet("Test", 10000, 18000);
    final Moon moon1 = planet.addMoon("Moon1", 5000, 100);
    final Moon moon2 = planet.addMoon("Moon2", 4000, 200);
    final Moon moon3 = planet.addMoon("Moon3", 3000, 300);
    
    HeavenlyBody[] planetarySystem = planet.getHeavenlyBodies();
    assertEquals(4, planetarySystem.length);

    // decomment the helper method you find last in this class.
    assertInArray(planet, planetarySystem);
    assertInArray(moon1, planetarySystem);
    assertInArray(moon2, planetarySystem);
    assertInArray(moon3, planetarySystem);
  }

  @Test
  void testGetHeavenlyBodies_returnCopies() {
    Planet planet = new Planet("Test", 10000, 18000);
    Moon moon1 = planet.addMoon("Moon1", 5000, 100);

    HeavenlyBody[] planetarySystem = planet.getHeavenlyBodies();
    assertEquals(2, planetarySystem.length);
    assertIsNotReferenced(planet, planetarySystem);
    assertIsNotReferenced(moon1, planetarySystem);
  }


  private void assertIsNotReferenced(Object o, Object[] objects) {
    for (Object obj : objects) {
      if (obj == o) {
        fail("Object " + o + " is referenced in array");
      }
    }
  }

  // Remove the comments around this one when you need it.
  private void assertInArray(HeavenlyBody body, HeavenlyBody[] bodies) {
    for (HeavenlyBody b : bodies) {
      if (b.getAvgRadiusInKm() == body.getAvgRadiusInKm()
          && b.getName().equals(body.getName())) {
        return;
      }
    }
    fail("HeavenlyBody " + body + " not found in array");
  }
}
