package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BoxingTest {

  @Test
  public void sameWrapperMustReturnTrueTest() {
    Integer wrappedInt1 = 12;
    Integer wrappedInt2 = 12;
    assertTrue(wrappedInt1 == wrappedInt2);
  }

  @Test
  public void sameWrapperMustReturnFalseTest() {
    Integer wrappedInt1 = new Integer(12);
    Integer wrappedInt2 = new Integer(12);

    assertFalse(wrappedInt1 == wrappedInt2);
  }

  @Test
  public void fakeInternMustReturnFalseTest() {
    List<Integer> list = new ArrayList<>();
    list.add(129);
    list.add(129);

    assertFalse(list.get(0) == list.get(1));
  }

  @Test
  public void unexpectedUnboxingMustThrowExceptionTest() {

    assertThrows(NullPointerException.class, () -> {
      Integer nothingSuspectingNullWrapper = null;
      if (nothingSuspectingNullWrapper < 0) {
        // dont touch me here
      }
    });

  }

}
