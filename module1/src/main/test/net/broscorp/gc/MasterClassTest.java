package net.broscorp.gc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MasterClassTest {

  @Test
  void bigNumberOfClasses() {
    for (int i = 0; i < 10000000; i++) {
      MasterClass masterClass = new MasterClass();
      SlaveClass slaveClass = new SlaveClass();
    }

  }

  @Test
  void referencedObjects() {
    for (int i = 0; i < 10000000; i++) {
      MasterClass masterClass = new MasterClass();
      SlaveClass slaveClass = new SlaveClass();
      slaveClass.setMasterClass(masterClass);
      masterClass.setSlaveClass(slaveClass);
    }
  }
}