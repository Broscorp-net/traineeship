package net.broscorp.gc;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GarbageCollectorTest {

  @Test
  void createMillionObjects() {
    List<String> stringList = new ArrayList<String>(1_000_000);
    for(int i = 0; i < 1_000_000; i++) {
      stringList.add("string object # " + i + " creation");
    }
    Assertions.assertEquals(1_000_000, stringList.size());
  }
}
