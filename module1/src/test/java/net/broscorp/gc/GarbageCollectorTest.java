package net.broscorp.gc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Hryhorii Perets
 */
public class GarbageCollectorTest {


  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }


  @Test
  @DisplayName("Should finalize started")
  public void shouldGcThenFinalizeStarted() {

    for (int i = 0; i < 250_000; i++) {
       new SimpleObject(String.valueOf(i));
    }

    //System.gc();

  }
}
