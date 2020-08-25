package net.broscorp.gc;

import java.util.ArrayList;
import java.util.List;

public class MasterClass {

  private SlaveClass slaveClass;
  private static List<MasterClass> list;
  private static int countOfConstructor = 0;
  private int count;

  public MasterClass() {
    this.count = countOfConstructor++;
    //list = new ArrayList<>();
  }

  public void setSlaveClass(SlaveClass slaveClass) {
    this.slaveClass = slaveClass;
    this.count = countOfConstructor++;
  }

  /*  @Override
  protected void finalize() throws Throwable {
    //list.add(this);
    System.out.println("Class Master (number = " + count + ") has been deleted!");
    super.finalize();
  }*/
}
