import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BoxingExampleTest {

  @Test
  void testForWrappersComparing() {
    Integer a = 1;
    Integer b = 1;
    assertTrue(a == b);
  }

  @Test
  void testForBoxing() {
    int a = 1;
    assertTrue(Integer.valueOf(a) instanceof Integer);
  }

  @Test
  void testForUnboxing() {
    Integer a = 1;
    Integer b = 1;
    assertTrue(a.intValue() == b.intValue());
  }

}