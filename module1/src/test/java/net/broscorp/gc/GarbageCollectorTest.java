package net.broscorp.gc;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GarbageCollectorTest {


  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }


  @Test
  @DisplayName("Should finalize started")
  public void shouldGcFinalizeStarted() {

    SimpleObject simpleObject;

    int amountobjects = 250_000;
    for (int i = 0; i < amountobjects; i++) {
       simpleObject = new SimpleObject(String.valueOf(i));
    }
    simpleObject = null;

    SimpleObject simpleObject1 = new SimpleObject("SimpleObject 1");
    SimpleObject simpleObject2 = new SimpleObject("SimpleObject 2");
    simpleObject1.simpleObject = simpleObject2;
    simpleObject2.simpleObject = simpleObject1;
    simpleObject1 = null;
    simpleObject2 = null;

    assertNull(simpleObject);
    assertNull(simpleObject1);
    assertNull(simpleObject2);

  }
}
