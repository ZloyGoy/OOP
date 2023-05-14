package assignmenttwo.solitares;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;


class StarTests {

  @Test
  void testStarCreation() {
    Star sun = new Star("Sun", 695700);
    assertEquals("Sun", sun.getName());
    assertEquals(695700, sun.getAvgRadiusInKm());
  }

  @Test
  void testNameCannotBeNull() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Star(null, 695700);
    });
  }

  @Test
  void testNameCannotBeEmpty() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Star("", 695700);
    });
  }

  @Test
  void testAvgRadiusMustBeLargerThan16699() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Star("Jupiter", 16699);
    });
  }
}
