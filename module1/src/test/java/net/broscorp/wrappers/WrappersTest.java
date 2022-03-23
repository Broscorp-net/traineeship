package net.broscorp.wrappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class WrappersTest {

  @Test
  void wrappersPositiveTestForEquals() {

    Long intFromLong = new Long(15L);
    Long longFromLong = new Long(15L);

    assertEquals(intFromLong, longFromLong);
    assertNotSame(intFromLong, longFromLong);

  }

  @Test
  void wrappersNegativeTestForEquals() {

    Long intFromLong = Long.valueOf(15);
    Long longFromLong = Long.valueOf(15L);

    assertEquals(intFromLong, longFromLong);
    assertSame(intFromLong, longFromLong);

  }

  @Test
  void wrappersUnboxingExceptionTest() {

    Integer emptyObject = null;

    assertThrows(NullPointerException.class, () -> {
      int value = emptyObject;
    });
  }

}
