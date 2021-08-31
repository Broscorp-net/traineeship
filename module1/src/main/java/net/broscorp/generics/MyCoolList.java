package net.broscorp.generics;

import java.util.function.Function;
import jdk.jshell.spi.ExecutionControl.NotImplementedException;
//import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class MyCoolList {

  public void add(Object o) throws NotImplementedException {
    throw new NotImplementedException(" ");
  }

  public Object get(int index) throws NotImplementedException {
    throw new NotImplementedException(" ");
  }

  public Object remove(int index) throws NotImplementedException {
    throw new NotImplementedException(" ");
  }

  public MyCoolList map(Function f) throws NotImplementedException {
    throw new NotImplementedException(" ");
  }

  public int size() throws NotImplementedException {
    throw new NotImplementedException(" ");
  }

}
