package assignmenttwo.solitares;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PlanetTest {

  @Test
  void testPlanetConstructor_validInput() {
    Planet planet = new Planet("Test", 10000);
    assertEquals("Test", planet.getName());
    assertEquals(10000, planet.getAvgRadiusInKm());
  }

  @Test
  void testPlanetConstructor_nullName() {
    assertThrows(IllegalArgumentException.class, () -> new Planet(null, 1000));
  }

  @Test
  void testPlanetConstructor_emptyName() {
    assertThrows(IllegalArgumentException.class, () -> new Planet("", 1000));
  }

  @Test
  void testPlanetConstructor_radiusTooSmall() {
    assertThrows(IllegalArgumentException.class, () -> new Planet("Test", 1999));
  }

  @Test
  void testPlanetConstructor_radiusTooLarge() {
    assertThrows(IllegalArgumentException.class, () -> new Planet("Test", 2000001));
  }

  
}
