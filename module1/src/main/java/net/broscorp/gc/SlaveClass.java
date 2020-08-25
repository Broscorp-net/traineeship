package net.broscorp.gc;

import java.util.ArrayList;
import java.util.List;

public class SlaveClass {

  private MasterClass masterClass;
  private static List<SlaveClass> list;
  private static int countOfConstructor = 0;
  private int count;

  public SlaveClass() {
    this.count = countOfConstructor++;
    //list = new ArrayList<>();
  }

  public void setMasterClass(MasterClass masterClass) {
    this.masterClass = masterClass;
    this.count = countOfConstructor++;
  }

  /*  @Override
  protected void finalize() throws Throwable {
    //list.add(this);
    System.out.println("Class Slave (number = " + count + ") has been deleted!");
    super.finalize();
  }*/
}
