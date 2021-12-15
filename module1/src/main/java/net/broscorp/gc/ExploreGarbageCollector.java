package net.broscorp.gc;

import java.util.ArrayList;
import java.util.List;

public class ExploreGarbageCollector {

  static Runtime runtime = Runtime.getRuntime();

  public static void main(String[] args){

    loadAndCleanMemory();

  }

  private static void loadAndCleanMemory() {
    System.out.println("get total memory = " + runtime.totalMemory());
    System.out.println("get free memory = " + runtime.freeMemory());

    List<String> stringList = new ArrayList<>(1_000_000);

    System.out.println(" total memory after initialize list = " + runtime.totalMemory());
    System.out.println("get free memory = " + runtime.freeMemory());

    for(int i = 0; i < 1_000_000; i++) {
      String string = "string object # " + i + " creation";
      stringList.add(string);
    }
    stringList = null;

    System.out.println(" total memory after add all object in list = " + runtime.totalMemory());
    System.out.println("get free memory = " + runtime.freeMemory());

    System.gc();

    System.out.println(" total memory after gc = " + runtime.totalMemory());
    System.out.println("get free memory = " + runtime.freeMemory());
  }

  @SuppressWarnings("debrecation")
  @Override
  protected void finalize(){
    System.out.println("Java deleted object use GC )");
  }


}
