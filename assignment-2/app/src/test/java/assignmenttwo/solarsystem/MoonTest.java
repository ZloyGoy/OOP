package assignmenttwo.solarsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MoonTest {

  @Test
  void testMoonConstructor_nullName() {
    assertThrows(IllegalArgumentException.class, () -> new Moon(null, 1000, 100));
  }

  @Test
  void testMoonConstructor_emptyName() {
    assertThrows(IllegalArgumentException.class, () -> new Moon("", 1000, 100));
  }

  @Test
  void testMoonConstructor_radiusTooSmall() {
    assertThrows(IllegalArgumentException.class, () -> new Moon("TestMoon", 5, 100));
  }

  @Test
  void testMoonConstructor_radiusTooLarge() {
    assertThrows(IllegalArgumentException.class, () -> new Moon("TestMoon", 10001, 100));
  }

  @Test
  void testMoonConstructor_orbitRadiusTooSmall() {
    assertThrows(IllegalArgumentException.class, () -> new Moon("TestMoon", 10000, 59));
  }

  @Test
  void testMoonConstructor_validInput() {
    Moon moon = new Moon("TestMoon", 10000, 100);
    assertEquals("TestMoon", moon.getName());
    assertEquals(10000, moon.getAvgRadiusInKm());
    assertEquals(100, moon.getAvgOrbitRadiusInKm());
  }
}
