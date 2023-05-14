package assignmenttwo.solitares;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MoonTest {

  @Test
  void testMoonConstructor_validInput() {
    Moon moon = new Moon("Test", 10);
    assertEquals("Test", moon.getName());
    assertEquals(10, moon.getAvgRadiusInKm());
  }

  @Test
  void testMoonConstructor_nullName() {
    assertThrows(IllegalArgumentException.class, () -> new Moon(null, 10));
  }

  @Test
  void testMoonConstructor_emptyName() {
    assertThrows(IllegalArgumentException.class, () -> new Moon("", 10));
  }

  @Test
  void testMoonConstructor_sizeTooSmall() {
    assertThrows(IllegalArgumentException.class, () -> new Moon("Test", 5));
  }

  @Test
  void testMoonConstructor_sizeTooLarge() {
    assertThrows(IllegalArgumentException.class, () -> new Moon("Test", 10001));
  }


}
