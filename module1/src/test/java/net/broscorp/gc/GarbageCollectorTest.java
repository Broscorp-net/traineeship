package net.broscorp.gc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GarbageCollectorTest {
  private static final Path pathToLogs = Paths.get("logs.txt");

  @BeforeEach
  void createLogsFile() {
    try {
      Files.deleteIfExists(pathToLogs);
      Files.createFile(pathToLogs);
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }

  @AfterEach
  void removeLogsFile() {
    try {
      Files.deleteIfExists(pathToLogs);
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }

  @Test
  void creatingObjectsAndDroppingReferencesToThem() {
    A a;
    B b;
    List<String> lines = new ArrayList<>();

    for (int i = 0; i < 1_000_000; i++) {
      a = new A();
      b = new B();
    }

    try {
      TimeUnit.SECONDS.sleep(1);

      lines.addAll(Files.readAllLines(pathToLogs));
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
      fail();
    }

    assertTrue(lines.size() > 0);
    assertTrue(lines.stream().anyMatch(line -> line.contains(A.class.getTypeName())));
    assertTrue(lines.stream().anyMatch(line -> line.contains(B.class.getTypeName())));
  }

  @Test
  void resurrectingObjectDuringGC() {
    List<String> lines = new ArrayList<>();

    new A() {
      @Override
      protected void finalize() throws Throwable {
        super.resurrect();
        super.finalize();
      }
    };

    try {
      while (lines.isEmpty()) {
        System.gc();
        lines.addAll(Files.readAllLines(pathToLogs));
      }
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
      fail();
    }

    assertEquals(1, lines.size());
    assertTrue(lines.get(0).contains(A.class.getTypeName()));
    assertNotNull(A.globalInst);
  }

  @Test
  void circularReferences() {
    List<String> lines = new ArrayList<>();

    A.globalInst = new A();
    B.globalInst = new B();

    A.globalInst.setDiffObj(B.globalInst);
    B.globalInst.setDiffObj(A.globalInst);

    A.globalInst = null;
    B.globalInst = null;

    try {
      while (lines.size() != 2) {
        System.gc();
        lines.addAll(Files.readAllLines(pathToLogs));
      }
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
      fail();
    }

    lines = lines.stream()
        .filter(line -> line.contains(A.class.getTypeName())
            || line.contains(B.class.getTypeName()))
        .collect(Collectors.toList());

    assertEquals(2, lines.size());
    assertNull(A.globalInst);
    assertNull(B.globalInst);
  }

}
