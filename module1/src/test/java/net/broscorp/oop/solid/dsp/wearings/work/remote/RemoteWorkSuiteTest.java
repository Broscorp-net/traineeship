package net.broscorp.oop.solid.dsp.wearings.work.remote;

import net.broscorp.oop.solid.dsp.*;
import org.junit.jupiter.api.Test;

/**
 * ! REMOVE ME !
 *
 * This test and similar ones created by trainee will be needed as the only place after refactoring
 * where all classes will be used.
 */
public class RemoteWorkSuiteTest {

  @Test
  void wearSuiteTest() {
    final AutoWearableSuite suite = new AutoWearableSuite(new Object[]{
        new LeftQuantumSock(),
        new RightQuantumSock(),
        new RedPants(),
    });

    suite.dressUp(new RemoteDeveloper());

    System.out.println("Remote Developer are ready to perform a code!");
  }

  static class RemoteDeveloper implements Human {

  }

}
