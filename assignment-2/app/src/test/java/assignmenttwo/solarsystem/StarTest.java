package assignmenttwo.solarsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;


class StarTest {

  @Test
  void testStarConstructor_nullName() {
    assertThrows(IllegalArgumentException.class, () -> new Star(null, 2000000));
  }

  @Test
  void testStarConstructor_emptyName() {
    assertThrows(IllegalArgumentException.class, () -> new Star("", 2000000));
  }

  @Test
  void testStarConstructor_radiusTooSmall() {
    assertThrows(IllegalArgumentException.class, () -> new Star("TestStar", 16699));
  }

  @Test
  void testStarConstructor_validInput() {
    Star star = new Star("TestStar", 2000000);
    assertEquals("TestStar", star.getName());
    assertEquals(2000000, star.getAvgRadiusInKm());
  }

  @Test
  void testAddPlanet_nullName() {
    Star star = new Star("TestStar", 2000000);
    assertThrows(IllegalArgumentException.class, () -> star.addPlanet(null, 100000, 100));
  }

  @Test
  void testAddPlanet_emptyName() {
    Star star = new Star("TestStar", 2000000);
    assertThrows(IllegalArgumentException.class, () -> star.addPlanet("", 100000, 100));
  }

  @Test
  void testAddPlanet_radiusTooSmall() {
    Star star = new Star("TestStar", 2000000);
    assertThrows(IllegalArgumentException.class, () -> star.addPlanet("TestPlanet", 1999, 100));
  }

  @Test
  void testAddPlanet_radiusTooLarge() {
    Star star = new Star("TestStar", 2000000);
    assertThrows(IllegalArgumentException.class, () -> star.addPlanet("TestPlanet", 2000001, 100));
  }

  @Test
  void testAddPlanet_validInput() {
    Star star = new Star("TestStar", 2000000);
    Planet planet = star.addPlanet("TestPlanet", 100000, 18000);
    assertEquals("TestPlanet", planet.getName());
    assertEquals(100000, planet.getAvgRadiusInKm());
    assertEquals(18000, planet.getAvgOrbitRadiusInKm());
  }

  @Test
  void testGetHeavenlyBodies() {
    final Star star = new Star("TestStar", 2000000);
    final Planet planet1 = star.addPlanet("TestPlanet1", 100000, 18000);
    final Planet planet2 = star.addPlanet("TestPlanet2", 200000, 28000);
    final Moon moon1 = planet1.addMoon("TestMoon1", 50, 60);
    final Moon moon2 = planet2.addMoon("TestMoon2", 60, 60);
    
    HeavenlyBody[] bodies = star.getHeavenlyBodies();
    
    // decomment the helper method you find last in this class
    assertInArray(star, bodies);
    assertInArray(planet1, bodies);
    assertInArray(planet2, bodies);
    assertInArray(moon1, bodies);
    assertInArray(moon2, bodies);
  }

  @Test
  void testGetHeavenlyBodies_areCopied() {
    final Star star = new Star("TestStar", 2000000);
    final Planet planet1 = star.addPlanet("TestPlanet1", 100000, 18000);
    final Planet planet2 = star.addPlanet("TestPlanet2", 200000, 28000);
    final Moon moon1 = planet1.addMoon("TestMoon1", 50, 60);
    final Moon moon2 = planet2.addMoon("TestMoon2", 60, 60);
    
    HeavenlyBody[] bodies = star.getHeavenlyBodies();
    
    assertEquals(5, bodies.length);
    assertIsNotReferenced(star, bodies);
    assertIsNotReferenced(planet1, bodies);
    assertIsNotReferenced(planet2, bodies);
    assertIsNotReferenced(moon1, bodies);
    assertIsNotReferenced(moon2, bodies);
  }

  private void assertIsNotReferenced(Object o, Object[] objects) {
    for (Object obj : objects) {
      if (obj == o) {
        fail("Object " + o + " is referenced in array");
      }
    }
  }

  // Decomment this one when you need it.
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
    
    
