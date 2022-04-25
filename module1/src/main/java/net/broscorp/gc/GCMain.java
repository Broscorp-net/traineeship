package net.broscorp.gc;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class GCMain {

  private static final Logger logger = Logger.getLogger("com.company.gc.GCMain");

  public static void main(String[] args) {
    GCMain one = new GCMain();
    GCMain two = new GCMain();
    one = two;
    two = one;
  }


  private static void create() {
    List<GCMain> list = new ArrayList<>(10_000_000);
    for (int i = 0; i < 50_000_000; i++) {
      GCMain gcMain = new GCMain();
    }
  }

  @Override
  protected void finalize() {
    logger.info("Finalize method worked");
  }
}
